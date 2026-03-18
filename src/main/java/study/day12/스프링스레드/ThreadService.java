package study.day12.스프링스레드;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ThreadService {

    // [1]
    public  int test1(){
        int result =0;
        for (int i = 1; i<=10; i++){
            System.out.println("TheardService.test1");

            //스레드 일시정지
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println(e);
            }
            result += i;
        }
        return result;

    }
    
    // [2]
    @Async // 비동기 : 먼저 반환/응답하고 내부적으로 처리
    // 사용자한테 바로 결과값을 보여줄필요 없을때 사용 다운로드, (관리자에게 승인 요청, )
    // AppStart 클래스 위에 @EnableAsync 활성화
    public void test2(){
        int result = 0;
        for (int i = 1; i<=10; i++){
            System.out.println("TheardService.test2");
            
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println(e);
            }
            result +=1;
            
            }
        // 리턴값 없이 결과값 출력 
        System.out.println("result = " + result);
    }
}
