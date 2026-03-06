console.log("예제10 write.js 실행")

// 등록 함수 정의
const 등록 = async () => {

    // 1. 입력받은 DOM 가져오기
    const writeInput = document.querySelector(".writeInput");
    const contentInput = document.querySelector(".contentInput");
    const titleInput = document.querySelector(".titleInput");
    // 2. DOM에서 입력받은 값 가져오기
    const bwriter = writeInput.value;
    const bcontent = contentInput.value;
    const btitle = titleInput.value;

    // 3. 객체 구성
    const obj={bwriter,bcontent,btitle};

    // 4. AXIOS 이용하여 서버에게 저장 요청 / 응답 받기
    const response = await axios.post("/board", obj);
    const data = response.data;

    // 5. 결과
    if (data == true){
        alert("등록성공")
        location.href ="/예제10/index.html"   // 페이지 이동 : HTML - <a> ,    js - location.href="
    }
    else {alert("등록실패")}
}

