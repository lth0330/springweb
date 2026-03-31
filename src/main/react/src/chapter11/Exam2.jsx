import { Route, Routes } from "react-router-dom";
import TopNavi from "./components/TopNavi";
import Home from "./components/Home";
import NotFound from "./components/NotFound";
import CommonLayout from "./components/CommonLayout";
import LayoutIndex from "./components/LayoutIndex";

// Exam2.jsx
export default function Exam2(props){

  return(<>
    <TopNavi> </TopNavi>
    <Routes>{/*라우터들 설정 시작*/}
      <Route path="/" element={<Home/>} />    {/*라우터 설정 */}
    
      <Route path="/intro" element={<CommonLayout/>}>
        <Route index element ={<LayoutIndex/>} />
      </Route>

      <Route path="*" element={<NotFound/>}/> {/*라우터 설정 */}

      </Routes>
  </>)
}