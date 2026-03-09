/* [1] 프론트관련 컴포넌트*/

function FrontComp(){ // 생성방법 1: function 컴포넌트명(){}
  return (<>
      <li>프론트 앤트</li>
    <ul>
      <li>HTML5</li>
      <li>CSS3</li>
      <li>Javascript</li>
      <li>JQuery</li>
    </ul>
  
  
  </>)  // 생성방법2 : 컴포넌트내 return (<> HTML 코드<>)
}

// 백앤트 관련 컴포넌트
const BackComp= () => {
  return(<>
  
  <li>백 앤트</li>
    <ul>
      <li>HTML5</li>
      <li>CSS3</li>
      <li>Javascript</li>
      <li>JQuery</li>
    </ul>

  </>)
}
let FormComp = function(){
  return(<>
    <form>
    <select name="gubun">
      <option value="front">프론트엔드</option>
      <option value="front">백엔드</option>
    </select>
    <input  type="text" name="title"/>
    <input type="submit" value="추가"/>
  </form>
  </>)
}

function App() {
  return (
      <>
        <h2>React-기본</h2>
  <ol>
    <FrontComp/>
    <BackComp></BackComp>
    
  </ol>
    <FormComp></FormComp>
      </>
  )
}

export default App
