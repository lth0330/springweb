import { useState } from "react"
import FrontComp from "./FrontComp";
import BackComp from "./Back";

export default function Exam2(props){

  // 1) useState 선언 : const [변수명, set변수명] = useState(초기값);
  const [mode, setMode] = useState('both')   //상태 변수

  // 2) 상태(값) 변경하는 함수 : set변수명(새로운값);   
  const handleSetMode = (mode) => {setMode(mode);}

  // 3) 컴포넌트 저장용 변수
  let contents ="";

  // 4) 상태에 따라 컴포넌트 그리기  , 분기(if) , setMode가 실행되서 상태가 변경되면 화면을 다시 그리므로(리랜더링/함수재호출)
  if(mode == "front" ){
    contents = <>
    <FrontComp onSetMode={(mode)=>{setMode(mode);}}/>
    </>
  }else if(mode == "back"){
    contents =<>
      <BackComp setMode = {setMode}/>
    </>
  }else{
    contents=<>
    <FrontComp onSetMode={(mode)=>{handleSetMode(mode);}}/>
    <BackComp setMode = {setMode}/>
    </>
  }

  // 5) 분기(if)에 따른 결과물을 return 에서 출력된다.
  return(<>
     <h3>chapter 7 p.118</h3> 
     <a href="/" onClick={()=>{setMode('both');}}> React-State</a>
     <ol>
      {contents}
     </ol>
  </>)
}