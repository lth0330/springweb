
const BackComp = ({ onMyEvent2}) => {
  return(<>
    <li>
      <a href="/" onClick={ ( ) => {onMyEvent2("백앤드 클릭됨")}}>벡앤드</a>
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