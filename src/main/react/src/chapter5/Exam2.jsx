
function FrontComp(props){
  // { /*   */ } 중괄호 안에 /* */ 쓰기
  return(<>
      {/* JSX(return에서 사용되는 (xml)문법)에서 주석처리하는 방법*/}
      <li>
        <a href="/" onClick={ ( ) => {event.preventDefault(); props.onMyEvent1() }} >프론트엔드</a>
      </li>
      <ul>
        <li>HTML</li>
        <li>CSS3</li>
        <li>자바스크립트</li>
        <li>JQuery</li>
      </ul>
  
  </>)
}

function Exam2(){

  function 출력함수(){alert("출력된 메세지1");} // 선언적 함수

  // 익명함수는 이름이 없는 함수(재사용이 안된다. 일회성 또는 이벤트 함수로 사용 )
  return(<>
      <h3>이벤트 처리 p.100</h3>
      <button onClick={ 출력함수 } > 리액트 버튼</button>
      <button onClick={function(){alert('출력된 메세지2');}}>리액트 버튼2(익명함수)</button>
      <button onClick={()=> {alert("출력되는 메세지3")}}>리액트 버튼3(화살표 함수)</button>
      <FrontComp onMyEvent1 = { ( )=>{alert("프론트엔드 클릭됨")}}></FrontComp>
  
  </>)
}

export default Exam2;
/*
  리액트 이벤트에서 주의할점
  1. OnClick --> onClick , 합성이벤트(리액트가 핸들러/연결을 통해 이벤트 실행)
  2. OnClick에서 함수를 실행하는 구조가 아니고 *전달*하는 구조
      1] 선언방법 : function 함수명(){}
      2] 호출방법 : 함수명()
      3] 함수란? 여러개 계산식/코드 (데이터x) 묶음 
      4] 변수란? 하나의 값을 저장하는 공간
    ** HTML : <button onclick="출력함수()">
    ** REACT :<button onClick={ 출력함수 } > 
*/