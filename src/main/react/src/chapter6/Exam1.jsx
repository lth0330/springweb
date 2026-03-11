import BackComp from "./Back";
import FrontComp from "./FrontComp";

/*
function Exam3(msg){
  alert(msg)

}

Exam3("클릭됨1")
Exam3("클릭됨2")
*/

export default function Exam1(){
  return(<>
      <h3> Chapter p.110</h3>
      <ol>
        <FrontComp/>
        <BackComp onMyEvent1={(msg) =>alert(msg) } ></BackComp>
        
      </ol>
  </>)
}
