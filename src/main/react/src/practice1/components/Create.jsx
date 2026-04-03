import axios from "axios";
import { Link, useNavigate } from "react-router-dom";

function Write(props){

  // [*] location.href 처럼 깜빡거림 없이 라우터로 페이지 전환 , navigate("이동할경로")
    const navigate = useNavigate();

  const taskPost = async (event) => {
        event.preventDefault(); // 기존 이벤트 제거 // <a> <form> , 이동 이벤트 기본적으로 포함됨.
        // * event 이란? 해당 이벤트(등록/클릭) 를 발생 시킨 정보 담고 있는 객체 
        // 1) 입력받은 값 가져오기 , form 내 식별자는 name 속성 사용한다.
        let title = event.target.title.value; 
        let content = event.target.content.value;
        let requester = event.target.requester.value;
        let status = event.target.status.value;
        // 2) (REST API 전송할) 객체 구성 
        let obj = { title , content , requester , status }
        // 3) axios 
        const response = await axios.post( "http://localhost:8080/api/task" , obj )
        const data = response.data;
        // 4) 결과에 따른 분기
        if( data.id >= 1 ){ 
            alert('등록성공'); // location.href="/"; // <a> 깜빡거림 
            navigate("/") // 라우터 , 깜빡거림없음 
        }
        else{ alert('등록실패'); }
    }
    return (<>
        <h3> 등록 페이지 </h3>
        <Link to="/"> 뒤로가기 </Link>
        <form onSubmit={ taskPost }>
            제목 : <input name="title" /> <br/>
            내용 : <textarea name="content"></textarea> <br/>
            요청자명 : <input name="requester" /> <br/>
            상태 :  <select name="status">
                        <option>요청</option>
                        <option>진행중</option>
                        <option>완료</option>
                    </select> <br/>
            <button type="submit">등록하기</button>
        </form>
    </>)
}



export default function Create(props) {

  // 목록  
  return (<>
   <Write></Write>
  </>)
}