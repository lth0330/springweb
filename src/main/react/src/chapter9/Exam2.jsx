import { useState } from "react"

function WriterForm(props){

  // event  / e 객체이란?  해당 이벤트가 발생했을때 정보를 담고 있는 객체
return(<>
  <form onSubmit={(event) => {
    event.preventDefault();
    console.log("이벤트객체 : ",event)
    
    console.log("이벤트발새한 주체 : " ,event.target) // <form
    console.log(event.target.gubun) // <form> -> 하위요소, target.class명
    let gubun = event.target.gubun         // <form> -> <select>
    let title = event.target.title  // <form> -> <input>

    props.WriteAction(gubun, title)  // 부모 컴포넌트로부터 받은 함수에 입력받은 구분과 타이틀을 대입하여 함수 실행
  }}>
    <select name="gubun">
      <option value="front">프론트앤드</option>
      <option value="back">백앤드</option>
    </select>
    <input type="text" name="title"/>
    <input type="submit" value="추가"/>
  </form>
</>)
}

export default function Exam2(props){

  // 상태변수란? 하나의 값을 저장하고 변경되면 해당 컴포넌트 재호출 
  const[message,setMessage] = useState("폼값 전송 진행중")

  // 자식에게 전달할 함수
  const WriteAction = (gubun, title) => {
    if(gubun != '' && title != ''){
      let formValue = `검증 완료 폼값 : ${gubun}, ${title}`
      setMessage(formValue)
    }else{
      alert("빈칸있음")
    }
  }
  return(<>
    <h3>chapter 9 </h3>
    <WriterForm WriteAction={WriteAction}/>
    <div> {message}</div>

  </>)
}