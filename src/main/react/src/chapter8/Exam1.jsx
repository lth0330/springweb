

import image2 from "../assets/image2.png"
import "./index.css"  // 전통 css 파일 호출
//    ./ : 현재 폴더, ../ : 상위 폴더,   ../../: 두번 상위폴더 이동
export default function Exam1(props){
  const myStyle = { color : "white", backgroundColor:"DodgerBlue"}
  const iWidth = {maxWidth : "300px"} // 인라인 css 방식은 개체 형식이다
  // public 이하 경로만 지정.
  return(<>
    <h3>스타일과 이미지 p.127</h3>
    <ol>
      <li style={{color : "red"}}>프론트앤드</li>
      <ul>
        <li><img src="/img/image.png" style={iWidth}/></li>
        <li><img src={image2} style={iWidth}></img></li>
        <li><img src="https://placehold.co/600x400" style={iWidth}/></li>
      </ul>

      <li className="backEnd">백앤드</li>
      <ul>
        <li id="backEndSub"> java</li>
        <li className="warnings">Oracle</li>
        <li style={myStyle}>js</li>
      </ul>
    </ol>





  </>)
}