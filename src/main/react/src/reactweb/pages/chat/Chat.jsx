import axios from "axios";
import { useEffect, useState } from "react"

 // [6] npm i @stomp/stompjs 설치
// [7] import
 import {Client} from '@stomp/stompjs'
 	
export default function Chat( props ){


  // [8] Client 객체를 저장하는 (레퍼런스)변수 , useRef vs useSate
  // 특정한 상태/값 저장하고 화면 렌더링에 영향을 주지 않는 저장소 
  // useRef가 변해도 렌더링은 안된다,  useState가 변하면 렌더링 된다.


  const client = useRef(null);

  // [14] 서버에게 받은 메세지들을 저장하는 상태함수
  const [ messages, setMessages] = useState("");

  // [4] 로그인 정보 상태 변수
  const [ loginUser, setLoginUser] = useState (null);

  // [3] AXIOS 회원정보 불러오기 함수 
  const getMyInfo = async () =>{

    try{
      const response = await axios.get(
        "http:localhost:8080/api/member3/my/info",
        {withCredentials:true})
        setLoginUser( response.data||null); // *단축평가 : 조건 && 참, 조건 || 거짓 
    }
    catch(e){console.log(e)}
  }

  // [5] 해당 컴포넌트 생명주기, 1번 실행
  useEffect( ()=>{
    getMyInfo();

    // [8] 웹소켓 연결하기
    const stomp = new Client({
      brokerURL : "ws://localhost:8080/ws", // 스프링 웹소켓 엔드포인트로 설정한 주소
      reconnectDelay : 5000,  // 연동 실패시 5초 마다 재연동
      onConnect : ()=>{ // 연동 성공 시 실행할 로직 
        console.log("소켓 연결 성공")


        // [13] 메세지 구독 ( 서버 -> 클라이언트 ) 
        // stomp.subscribe("주소")
        stomp.subscribe("/topic/message", (메세지) => {
          console.log(메세지);
          const data = JSON.parse(메세지);
          messages.push(data);
          setMessages([...messages])
        })
      }
    });

    // [9] 웹소켓 실행  .activate();
    stomp.activate();

    // [10] 웹소켓을 안전하게 useRef에 보관한다.  useRef
    client.current = stomp;  // 수정시  .current = 새로운값
    
    // [11] 컴포넌트 언마운트 될때
    return() => {
      stomp.deactivate(); // 소켓 닫기 
    }

  },[])
  console.log(loginUser)


  // [2] 입력받은 값을 저장하는 상태변수
  const[sendMsg,SetSendMsg] = useState("초기값");

  // [1] 전송 버튼 클릭 시 입력받은 값 가져오기 = 서버에게 채팅 메세지 보내기 
  const sendMessage = () => {

    // 1) 입력받은 값 확인하기  
    console.log("입력받은 값 : ", sendMsg)

client.current.publish({
  destination : "/chat",
  body : JSON.stringify(obj)
})

    SetSendMsg(""); // 메세지 전송 후 입력상자, 초기화 
  }



    return (
        <div>
            <h3> 채팅 </h3>
            <div className="contents">
                <div className="msgbox"> 
                    <div className="sender"> 유재석 </div>
                    <div className="msg"> 안녕하세요. </div>
                </div>
                <div className="msgbox">
                    <div className="msg"> 안녕하세요2. </div>
                </div>
            </div>

            {/* 입력상자 value 속성에 상태변수 대입시 입력이 불가능하다. */}
            {/* 상태변수는 랜더링 해야한다. onChange={(e)=>{SetSendMsg(e.target.value)}} */}
            <input value={sendMsg} onChange={(e)=>{SetSendMsg(e.target.value)}}/>
            <button onClick={sendMessage}> 전송 </button>
        </div>
    )
}