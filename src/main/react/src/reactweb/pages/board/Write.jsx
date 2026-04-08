import axios from "axios";
import { Navigate } from "react-router-dom";

import ReactQuill from 'react-quill-new';
import 'react-quill-new/dist/quill.snow.css';
import { useState } from "react";


export default function Write(props) {

  // [1] REST API로  글쓰기 요청
  const boardWrite = async (e) => {
    e.preventDefault();

    // (0) token 가져오기
    const token = localStorage.getItem('token');

    // (1) 입력받은 값 가져오기
    const btitle = e.target.btitle.value;
   // const bcontent = e.target.bcontent.value;   textarea 에서 --> quill 변경 
    const uploadFile = e.target.uploadFile.files[0];

    // value : 입력받은 자료, fi;es : file type의 등록된 파일 , files[0] 선택된 1개 파일

    // (2) 객체를 구성하지 않고 멀티(대용량/바이트)폼 객체 , mutipart/from-data
    const formData = new FormData();  // 대용량 폼을 지원하는 객체 
    formData.append("btitle", btitle); // .append(속성명, 값)  대용량폼에 속성 추가한다.
    formData.append("bcontent", value); //textarea 에서 --> quill 에디터가 담고 valuew 상태변수 대입 


    if (uploadFile) { formData.append("uploadFile", uploadFile) }

    // (3) AXIOS 
    const response = await axios.post("http://localhost:8080/api/board/write4",  // 서버 주소
      formData,   // 전송할 객체
      { withCredentials: true } // *쿠키로 변경 *
    );

    const data = response.data
    if (data == true) {
      alert("글쓰기 성공");
      location.href="/";
    } else {
      alert("글쓰기 실패 ")
    }

  }
  //
  const [value, setValue] = useState(''); // 웹 에디터 입력값을 갖는 상태변수

  const modules = {
    toolbar : [
      [{header : [1,2,3,4]}],
      [{"list" : "ordered"},{"list" : "bullet"} ] ,
      ["image"] // 이미지 기능 추가
    ]
  }

  const formats= [
    "image"
  ]


  return (<>
    <div>
      <h3> 글쓰기 페이지 </h3>
      <form onSubmit={boardWrite}>
        제목 : <input name="btitle" />                     <br />
        { /* 웹 에디터 */}
        <ReactQuill theme="snow" 
        value={value} 
        onChange={setValue} 
        modules={modules} 
        formats={formats} />

        내용 : <textarea name="bcontent" ></textarea>       <br />
        첨부파일 : <input name="uploadFile" type="file" />  <br />
        <button type="submit"> 등록하기 </button>
      </form>
    </div>
  </>)
}