import { NavLink } from "react-router-dom";


export default function TopNavi(props) {


  // jsx 와 js 구분 : 컴포넌트(함수)내 return(반환값) 뒤로 jsx 문법 그외 js
  return(<>
    <nav> {/* jsx 형식의 주석 처리*/}
      <NavLink to="/">생명주기</NavLink>
      <a href="/" >생명주기 </a>
      <NavLink to="/local"> 내부통신</NavLink>
       <NavLink to="/external">외부통신</NavLink>
    



    </nav>
 
    </>)
}