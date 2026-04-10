import axios from "axios";
import React, { useEffect, useState } from "react";

export default function EmployeeManager() {

  const [name, setName] = useState("");
  const [position, setPosition] = useState("");
  const [boardView, setBoardView] = useState([]);
  const [departView, setDepartView] = useState([]);
  const getBoard = async () => {

    try {
      const response = await axios.get("http://localhost:8080/api/board");
      const data = response.data;
      setBoardView(data);
    } catch (e) {
      console.log(e);
    }

  }
  useEffect(() => {
    getBoard();
  }, []);

  const addBoard = async (e) => {
    e.preventDefault();

    let name = event.target.value;
    let position = event.target.value;
    let dName = event.target.value;
    let picture = event.target.value;
    const boardDto = { name, position, picture, dName }
    try {
      const response = await axios.post("http://localhost:8080/api/board", {
        boardDto
      });

      const data = response.data
      if (data == true) {
        alert("등록 성공");
      }
      console.log(data)
    } catch (e) {
      console.log(e);
      alert("등록 실패");
    }
  };

  // 부서 
  const getDepartment = async () => {
    try {
      const response = await axios.get("http://localhost:8080/api/department");
      const data = response.data
      setDepartView(data);
    } catch (e) {
      console.log(e);

    }
  };

  useEffect(() => {
    getDepartment();
  }, []);




  return (
    <div className="main">
      {/* 사원 등록 */}
      <form className="form-box" onSubmit={addBoard}>
        <h3>사원 등록</h3>

        <div className="form-row">
          <input type="text" placeholder="이름" name="name" />
          <input type="text" placeholder="직급" name="position" />
        </div>

        <div className="form-row">

          <select name="dName">

            {
              departView.map((dept) => {
                <option>부서를 선택하세요</option>
                <option  key={dept.dno}>{dept.dName}</option>
              })
            }
          </select>


          <input type="file" name="picture" />
        </div>

        <div className="form-action">
          <button className="primary" type="submit">등록</button>
        </div>
      </form>



      {/* 사원 목록 */}
      <div className="table-box">
        <h3>사원 전체 목록</h3>

        <table>
          <thead>
            <tr>
              <th>사진</th>
              <th>이름</th>
              <th>부서</th>
              <th>직급</th>
              <th>관리</th>
            </tr>
          </thead>
          <tbody>
            {
              boardView.map((view) => {
                return (<>
                  <tr>
                    <td><img className="img-box" /> </td>
                    <td>{view.name}</td>
                    <td>{view.dName}</td>
                    <td>{view.position}</td>
                    <td>
                      <span className="edit">수정</span>
                      <span className="delete">삭제</span>
                    </td>
                  </tr>
                </>)
              })
            }
            <tr>
              <td><img className="img-box" /> </td>
              <td>이서연</td>
              <td>디자인팀</td>
              <td>수석 디자이너</td>
              <td>
                <span className="edit">수정</span>
                <span className="delete">삭제</span>
              </td>
            </tr>

            <tr>
              <td><img className="img-box" /> </td>
              <td>박도윤</td>
              <td>기획팀</td>
              <td>팀장</td>
              <td>
                <span className="edit">수정</span>
                <span className="delete">삭제</span>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  );
}