import React, { useEffect, useState } from "react";
import axios from "axios";
import { act } from "react";

export default function DepartmentManager() {

  const [departView, setDepartView] = useState([]);
  const [dName, setDName] = useState("");

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

  const addDepartment = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post("http://localhost:8080/api/department", {
        dName: dName,
      });

      const data = response.data
      if (data == true) {
        alert("등록 성공");
        setDName("");
        getDepartment();
      }
    } catch (e) {
      console.log(e);
      alert("등록 실패");
    }
  };


  const deleteDepartment = async (dno) => {
    try {
      const response = await axios.delete(
        `http://localhost:8080/api/department/${dno}`
      );

      const data = response.data
      if (data == true) {
        alert("삭제 성공");
        getDepartment();
      }

    } catch (e) {
      console.log(e);
      alert("삭제 실패");
    }
  };


  const updateDepartment = async (dno) => {

    const upName = prompt("수정할 부서명 : ")

    try {
      const response = await axios.put(
        `http://localhost:8080/api/department/${dno}`,
        { dName: upName }
      );

      const data = response.data
      if (data == true) {


        alert("수정 성공");

        getDepartment();

      }

    } catch (e) {
      console.log(e);
      alert("수정 실패");
    }
  };

  return (
    <div className="sidebar">
      <h3>부서 관리</h3>

      <form className="dept-input" onSubmit={addDepartment}>
        <input
          placeholder="부서명 입력" value={dName}
          onChange={(e) => setDName(e.target.value)}
        />
        <button type="submit">추가</button>
      </form>

      <table className="dept-table">
        <thead>
          <tr>
            <th>부서명</th>
            <th>관리</th>
          </tr>
        </thead>
        <tbody>
          {
            departView.map((dept) => {
              <tr key={dept.dno}>
                <td>{dept.dName}</td>
                <td>
                  <span className="edit" onClick={() => updateDepartment(dept.dno)}>수정</span>
                  <span
                    className="delete"
                    onClick={() => deleteDepartment(dept.dno)}
                  >
                    삭제
                  </span>
                </td>
              </tr>
            })
          }
        </tbody>
      </table>
    </div>
  );
}