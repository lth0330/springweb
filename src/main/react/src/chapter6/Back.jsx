
const BackComp = ({  onMyEvent1,onMyEvent2}) => {
  return(<>
    <li>
      <a href="/" onClick={ ( ) => {onMyEvent1("백앤드 클릭됨1")}}>벡앤드1</a><br/>
      <a href="/" onClick={ ( ) => {onMyEvent1("백앤드 클릭됨2")}}>벡앤드2</a>
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