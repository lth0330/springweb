import { useEffect, useState } from "react";
import axios from 'axios'

const GlobalTop = (props) => {
  console.log("[1] 컴포넌트 실행");
  const [myList, setMyList] = useState([]);  // 빈배열을 갖는 상태변수

  // [1] AXIOS 사용하기 
  const axios1 = async () => {   // axios 통신하는 함수 하나 만든다. async 동기화 한다.
    const response = await axios.get("./json/myData.json")  // await 동기화된 axios 통신
    // 통신한 전체 결과물 중에 data만 선택해서 가져옴
    const result = response.data; // 통신 결과내 .data가 실직적인 결과물(내용물/body)가져온다.
    setMyList(result);    // axios 통신결과를 상태변수에 대입한다. <랜더링>
  }
  // [2]
  // (1) useEffect (()) => {})                      : 최초실행, 랜더링 할때마다 - 무한 랜더링
  // (2) useEffect (()) => {},[])                   : 최초실행
  // (3) useEffect (()) => {},[상태변수1, 상태변수2])  : 최초실행, 특정 상태가 변경될때마다
  useEffect(() => {
    console.log("[3] useEffect 실행")
    axios1();
  }, [])


  // [3] 현재 상태(myList => json => axios) 정보를 반복하여 html 구성 함수.
  // 리스트 또는 배열변수명에 .map ( (반복변수) => {return (<> JSX <> )})   // 주로 html를 구성할때 사용
  let listTag = myList.map((data) => {
    // 첫번째 반복 data = {"num":1,  "id":"yu",  "name":"유비", "cell":"(02) 235-1111" --------}
    // 두번째 반복 data = {"num":2,  "id":"kwan",  "name":"관우", "cell":"(02) 235-1111" --------}
    // 세번째 반복 data = {"num":3,  "id":"jang",  "name":"장비", "cell":"(02) 235-1111" --------}

    // onClick = {함수선언또는 함수명}
    return (<li key={data.id} >
    
      <a href={data.id} onClick={(e)=>{
      e.preventDefault();   // a 마크업에 관련된 기본 기능 제거 ( 깜빡거리는 기능 제거)
      props.myListClick(e.target.dataset.id);

      }}> {data.id}</a>

    </li>)
  })
  // 변수 예측

  console.log("[2] return 실행")
  return (<>
    <nav>
      <ul>{
        myList.map((data) => {
          return (<li key={data.id}>
            <a> {data.id}</a>

          </li>)
        })
      }
      </ul>
    </nav>

  </>)
}


export default function LocalJsonFetcher(props) {

  const [ myResult, setMyResult ] = useState({});  // 상태변수 , 배열 아닌 객체 , 빈객체
  console.log(myResult);  // 확인

  return (<>
    <h3> 내부 서버 통신</h3>
    <GlobalTop myListClick ={async(num) =>{
        console.log("클릭",num)

        const response = await axios.get(`./json/dto${num}.json`)
        const result = response.data;
        setMyResult(result);


    }}></GlobalTop>
  </>)
}