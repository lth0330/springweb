/*
  부모 컴포넌트로 부터 상태변경 함수를 props로 받아서
  props {} 구조분해할당하여 a 클릭하면 상태를 back으로 수정한다.
  */
const BackComp = ({ setMode}) => {
  
  return(<>
    <li>
      <a href="/" onClick={ ( ) => {
        event.preventDefault();
        setMode("back")}}>벡앤드</a>
    </li>
    <ul>
        <li>HTML5</li>
        <li>CSS5</li>
        <li>????</li>
        <li>JAVA</li>
    </ul>
  </>)
}
export default BackComp