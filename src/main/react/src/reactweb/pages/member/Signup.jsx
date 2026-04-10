import axios from "axios";
import { data } from "react-router-dom";


export default function Signup(props) {


  const signup = async (e) => {
    e.preventDefault();

    const mid = e.target.mid.value;
    const mpwd = e.target.mpwd.value;
    const mname = e.target.mname.value;

    const obj = { mid, mpwd, mname }

    const response = await axios.post("http://localhost:8080/api/member/signup", obj)

    const data = response.data
    console.log(data);

    if (data) {
      alert("회원가입 성공")
      location.href = "/";
    } else {
      alert("회원가입 실패")
    }
  }

  return (<>
    <div>
      <h3> 회원가입 페이지 </h3>
      <form onSubmit={signup}>
        아이디 : <input name="mid" />    <br />
        비밀번호 : <input name="mpwd" /> <br />
        이름 : <input name="mname" />   <br />
        <button type="submit"> 회원가입 </button>
      </form>
    </div>

  </>)
}