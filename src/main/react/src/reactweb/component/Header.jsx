import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

export default function Header(props) {

  // [2] 로그인 상태를 저장하는 상태 변수
  const [login, setLogin] = useState(false);  // 초기값은 false , 로그인 안했다는 뜻

  // [3] 로그인중인 회원 정보를 담는 상태변수
  const [user, setUser] = useState(null);  // 초기값은 비로그인 상태

  // [1] 로그인 상태에 따라 상단 메뉴 분기
  const getMyInfo = async () => {


    // 3) 헤더에 표시할 로그인된 유저 아이디 가져오기
    const response = await axios.get("http://localhost:8080/api/member3/my/info",  // 통신할 (스프링 컨트롤러 매핑) 주소
      { withCredentials : true } // hearder 에 토큰 전송이 아닌 쿠키 전송으로 변경
      // axios 특징 : content-type : application/json 기본값 
      // 만약에 COntent-type이 json이 아닌 경우 명시한다.
    );

    // 4) 통신 결과 
    const data = response.data;
    if (data && data != false) {
      setLogin(true);
      setUser(data);  // 응답 받은 자료(회원정보)를 저장 
    } else {
      setLogin(false);  // 비로그인 상태 변경 
    }
  }

  // [4] 헤더가 열리면 최초 1번 실행,  로그인상태(백엔드에서 검증해야한다.)
    useEffect(() => { getMyInfo(); }, [])

  // [5] 로그아웃
  const logout = async() => {

    const response = await axios.get("http://localhost:8080/api/member3/logout", {withCredentials : true})  // 쿠키 (+토큰) 전송)  // 통신할 서버의 경로 (controller 매핑 주소)
    

     // 2) 로그인 상태 변경 , 안내후 페이지 변경 
        setLogin( false );
        alert('로그아웃');  
        location.href="/"; 
  }


  // JS 삼항연산자, 조건 ? 참 : 거짓  (조건이 참이면 참실행문 실행, 조건이 거짓이면 거짓 실행문 실행) 
  // JS 단축평가 , 조건 && 실행문   ( 조건이 참이면 실행문 실행, 조건이 거짓이면 생략)
  return (<>
    <div>
      {/* 로그인 상태에 따른 메뉴 분기*/}
      <Link to="/"> 홈</Link> 
      <Link to="/board"> 게시물</Link>

      {/* 비로그인 메뉴 */}
      {login == false && (<>
        <Link to="/member/login"> 로그인</Link> |
        <Link to="/member/signup">회원가입</Link> |
      </>)}



       
 	
            { /* 로그인 메뉴  */}
            { login == true && ( <> 
                <span> { user.mid } 님 </span> |
                <Link to="/member/page"> 내정보 </Link> |
                <Link to="/board/write"> 글쓰기 </Link> |
                <Link to="/chat"> 채팅방 </Link> |
                <button onClick={ logout }> 로그아웃 </button>
            </> )}  


      <hr />
    </div>
  </>)
}