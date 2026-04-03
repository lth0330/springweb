import { Route, Routes } from "react-router-dom"
import Login from "./pages/Member/Login"


export default function App(props) {

  return (<>


    <div id="wrap">
      {/* 헤더 */}
      <Routes>
        {/*  본문들*/}
        <Route path="/member/login" element={<Login/>}></Route>

        
      </Routes>
      {/* 푸터 */}
    </div>
  </>)
}