
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'

// 기존코드
//createRoot(document.getElementById('root')).render(<App />)

// chapter 4 예제
import Exam1 from './chapter4/Exma1.jsx'; // 컴포넌트 불러오기
createRoot(document.querySelector("#root")).render(<Exam1/>);