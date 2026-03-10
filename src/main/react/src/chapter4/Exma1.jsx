
// 컴포넌트를 만드는 방법
// 1. 해당 폴더 오른쪽 클릭  --> new file
// 2. 첫글자가 대문자로 시작하는 .jxs 파일확장자로 생성한다.
// 에] Exam1.jsx
// 3. function 컴포넌트명(){}
// 4. 컴포넌트 내 return ( <> jsx문법 </>)
// 5. 파일 내보내기할 컴포넌트 1개,  export fefault 컴포넌트명   ( 내보내기)



function FrontComp(props){
  
  console.log(props);

  const LiRows = []; // 배열 선언
  for(let i=0; i <props.propData1.length; i++){
    LiRows.push(
        <li key={i}> {props.propData1[i]}</li>
    );
  }
  return(<> 
    <li>{props.frTitle}</li>
    <ul>
      {LiRows}
    </ul>
  </>)
}

const BackComp = ({propData2,baTitle}) =>{
/*
const {a,b} = {a:1,b:2} // 구조분해
// 즉] 객체내 값들을 각 변수로 분해, a 속성 b속성으로 구성된 객체를 a, b 변수로 분해
confirm.log(a); //  구조분해 한 변수를 사용한다.
*/
  const liRows =[]
  let keyCnt=0;
  for(let row of propData2){
    liRows.push(
      <li key={keyCnt++}> {row}</li>
    )
  }
  return(<>
      <li> {baTitle}</li>
      <ul>
        {liRows}
      </ul>
      
  </>)
}
// (1) 구조분해 없이 여러개 속성을 한번에 받기
function MyComponent(props){
  // JSX에서는 주석이 안됨
  // props에 존재하지 않은 속성명은 출력되지 않는다. < 상위 컴포넌트에서 전달받은 속성명과 속성값만 사용가능
  return(<>
    <p>
      {props.p1} {props.p2} {props.p3} {props.p4} {props.p5}
    </p>
  </>)
}

// (2) 구조분해를 사용하여 필요한 속성만 받기
function MyComponent2({p1 ,p3, }){
  return(<>
      <p> {p1} {p3} </p>
  </>)
}

function Exam1 (){

  const frontData = ["HTML","CSS","JAVASCREAT"];
  const backData = ["JAVA","JSP","JPA","SPRING"];
  return(<>
  <h3>
    프롭스 예제 p.87
    <MyComponent p1={"HTML"} p2={"Css"} p3={"JAVA"} p5={"???"}/>
    <MyComponent2 p1={"HTML"} p2={"Css"} p3={"JAVA"} p5={"???"}/>
    <FrontComp propData1={frontData} frTitle="프론트앤드"/>
    <BackComp propData2={backData} baTitle="백앤드"/> 
  </h3>
  <h3> props 객체 p.90</h3>
 
  </>)
}
export default Exam1;