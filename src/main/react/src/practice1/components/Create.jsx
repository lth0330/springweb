function Write(props){


  const taskPost = async (event) =>{
    event.prventDefault();
  }



  return (<>
        <h3> 등록 페이지 </h3>
        <p> 제목, 요청내용, 요청자명, 상태를 </p>
        <form>
            제목 : <input /> <br/>
            내용 : <textarea></textarea> <br/>
            요청자명 : <input /> <br/>
            상태 :  <select>
                        <option> 요청 </option>
                        <option> 진행중 </option>
                        <option> 완료 </option>
                    </select> <br/>
            <button type="submit">등록하기</button>
        </form>
    </>)
}



export default function Create(props) {

  // 목록  
  return (<>
   <Write></Write>
  </>)
}