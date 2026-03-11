import BackComp from "./Back";
import FrontComp from "./FrontComp";


export default function Exam1(props){
  return(<>
      <h3> Chapter p.110</h3>
      <ol>
        <FrontComp/>
        <BackComp onMyEvent2={(msg) =>alert(msg)}></BackComp>
      </ol>
  </>)
}
