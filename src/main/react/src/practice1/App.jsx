import { Route, Routes } from "react-router-dom";
import Detail from "./components/Detail";
import Edit from "./components/Edit";
import Index from "./components";
import Create from "./components/Create";

export default function App(props){

  return(<>
  
  컴포넌트
<Routes>
  <Route path="/" element={<Index/>}></Route>

<Route path="/task/create" element={<Create/>}></Route>
<Route path="/task/create" element={<Detail/>}></Route>
<Route path="/task/edit" element={<Edit/>}></Route>


  
</Routes>
  </>)
}