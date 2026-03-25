package study.day16;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor


public class FileService {
    // 업로드 경로 1] 로컬 환경
    private String baseDir = System.getProperty("user.dir"); // C:\Users\이태형\OneDrive\바탕 화면\springweb
    private String uploadDir = baseDir + "/build/resources/main/static/upload/"; // 상세 경로 추가
    // 업로드 경로 2] 클라우드 환경 * 추후에 *

    // [1] 업로드
    public String upload(MultipartFile uploadFile){

        // 1) 만약에 파일이 존재하지않으면
        if (uploadFile.isEmpty()){ return null;} // 업로드 실패 : 파일이 없음

        // 2) 업로드할 파일의 경로 *서버경로*    개발자(src파일) --> 배포/실행 --> 서버(build 파일)
        File uploadPath = new File(uploadDir);   // 업로드할 uploadDir + 파일명을 file 객체에 대입
        // ** 만약에 해당 경로의 폴더가 존재하지 않으면 폴더 생성
        if (!uploadPath.exists()){  // !부정문 , : file객체.exists() 경로가 존재하면 true
            uploadPath.mkdir(); // file객체.mkdir() : 경로 / 폴더 생성
        }
        // 3) 업로드
        String fileName = uploadFile.getOriginalFilename(); // 업로드할 파일명
        File uploadRealPath = new File(uploadDir +fileName);// 파일명과 경로를 연결하여 최종적인 경로 파일 객체 생성

        try {
        uploadFile.transferTo(uploadRealPath);    // 업로드 파일을 특정한 경로에 이송 / 복사 한다. * 예외처리 발생 *return null;
        } catch (IOException e) {System.out.println(e);}
        return null;

    }
}

/*
        // 1)  첨부파일 존재 여부
        System.out.println(uploadFile.isEmpty());

        // 2) 첨부파일의 파일명
        System.out.println(uploadFile.getOriginalFilename());

        // 3) 첨부파일의 확장자
        System.out.println(uploadFile.getContentType());

        // 4) 첨부파일의 용량
        System.out.println(uploadFile.getSize());
 */