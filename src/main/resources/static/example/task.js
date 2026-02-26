console.log("task.js exe 실행")

// [1] 타입 : JS는 동적타입이므로
//  1. 기본자료 / 리터럴
console.log(3);  console.log(true); console.log(3.14); console.log("안녕")
//  2. 배열
console.log([3,true,3.14,"안녕"]);
//  3. 객체
console.log({"name" : "이태형", "age" : 27})
//  4. 함수
function fun1(){}
// [2] 다양한 함수 형식
    // function fun2(){}   // 선언적 함수
    // function () {}      // 익명 함수
() => {}            // 화살표(람다표현식) 함수  -- 리액트 표현
// [3] 화살표 함수는 익명이므로 변수에 저장한다.
const func3 = () => { }

//===============================================================================

/*
    AXIOS
        1. 정의 : 대표적으로 비동기/동기 통신 함수
            AXIOS(REACT) VS JS(FETCH) vs JQUERY(AJAX) 등
        2. 목적 : JS 환경에서 서버와의 통신
        3. 설치 :
            1. HTML에 CDN 코드를 추가한다.
            2.  <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
        4. 사용법
*/
//axios.HTTP메소드명("통신할 주소") VS 탈렌드API
axios.get("http://localhost:8080/day03/task")