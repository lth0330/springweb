import { Outlet } from "react-router-dom";

export default function CommonLayout(props){
  return(<>
  
  <div>
    <header style={{background: ' lightgray', padding:'10px'}}>
      Outlet 컴포넌트 알아보기
    </header>
    <article>
      <Outlet> </Outlet> {/* 자식 컴포넌트가 랜더링 될 위치*/}
    </article>
  </div>
  <div style={{background: ' lightgray', padding:'10px'}}>
      공통 레이아웃
  </div>
  
  </>)
}