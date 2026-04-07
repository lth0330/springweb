
import axios from "axios";
import {useEffect, useState } from "react"


function List(props) {

  const [postList, setPostList] = useState([]);
  const axiosLink = async () => {
    const response = await axios.get("http://localhost:8080/api/task")
    const body = response.data;
    setPostList(body);
  }

  useEffect(() => {
    axiosLink();
  },[]);

      // [4] 삭제 요청 REST API , delete update , write 존재하는 키워드 이므로 불가능하다.
    const deleteTask = async( id )=>{
        const result = confirm( '정말 취소할까요? '); // 확인true , 취소false 
        if( result == true ){
            const response = await axios.delete('http://localhost:8080/api/task?id='+id);
            // 본문이 없으므로 본문으로 분기하지 않고 HTTP 응답 코드 분기
            if( response.status == 204 ){ alert('삭제성공'); taskList(); } 
            else{ alert('삭제실패'); }
        }
    }

  return (<>
        <h3> 전체조회 </h3>
        <a href="/task/create"> 등록 </a>       { /* HTML 이동마크업 */}
        <table>
            <thead border = "1">
                <tr>
                    <th> 번호 </th> <th> 제목 </th> <th> 요청자명 </th> 
                    <th> 상태 </th> <th> 등록일 </th> <th> 비고 </th>
                </tr>
            </thead>
             <tbody>
                { 
                    postList.map( (task) => { 
                        return (<>
                            <tr>
                                <td> { task.id } </td> <td> { task.title } </td> <td> { task.requester } </td>
                                <td> { task.status } </td> <td> { task.updateDate.split('T')[0] } </td> 
                                <td> 
                                    <button> <Link to={'/task/detail?id='+task.id} > 상세보기 </Link> </button>
                                    <button> 수정 </button>
                                    <button onClick={() => deleteTask(task.id)}> 삭제 </button>
                                </td>
                            </tr>
                        </>)
                    })
                }
            </tbody>
        </table>
    </>)
}


export default function Index(props){

  return(<>
  <List></List>
  </>)
}