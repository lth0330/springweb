import axios from "axios";
import { use, useEffect, useState } from "react";
import { useSearchParams } from "react-router-dom"

export default function View(props) {


  // [1] 현재 URL 상의 쿼리스트링 값 가져오기 , 조회할 게시물 번호 가져오기
  const [params] = useSearchParams();
  const bno = params.get("bno");  // URL 상의 bno 값 가져오기 

  // [3] axios 결과를 담는 상태변수
  const [board, setBoard] = useState(null);

  // [2] axios
  const findByid = async () => {

    try {
      const response = await axios.get(`http://localhost:8080/api/board/view?bno=${bno}`);
      const data = response.data;
      setBoard(data);
    } catch (e) { console.log(e); }
  }

  useEffect(() => { findByid() }, []) // [3] 실행시점

  // [5] 만약에 아직 axios의 결과가 없으면
  if (!board) return <div> 불러오는 중 </div>

  return (
    <div>
      <h3> 게시물 상세</h3>
      <div> 작성자 : {board.mname} | 작성일 : {board.createDate}</div>
      <div> 제목 : 테스트 </div>

    
      <div dangerouslySetInnerHTML={{__html : board.bcontent}}/> 
      <div>
        { /* 만약에 첨부 파일이 존재하면 */
          board.bfile && (
            <>
              <a href={`http:://localhost:8080/upload/${board.bfile}`} download> 
                {board.bfile.split("_")[1]} 다운로드
              </a>
            </>
          )
        }
      </div>
    </div>
  )
}