console.log("index.js 실행");

// 1] 전체 조회 document.querySelector(출력할 위치");

const onFindAll = async() => {
    // 1. 어디에 ,
    const tbody = document.querySelector("#boardTable tbody");

    // 2. 무엇을 , 출력할 내용물
    let html="";

        // 동기화 : 1. 현재 함수명 앞에 async 키워드를 붙인다. 2. axios 앞에 await 키워드를 붙인다.
        const response = await axios.get("/board");
        const data = response.data;     // response : 응답정보 객체, response.data : 응답값
        for (let index =0; index<=data.length-1; index++){
            const board = data[index];
            html += `<tr>
                         <td> ${board.bno}</td>
                         <td> ${board.bcontent}</td>
                         <td> ${board.bwriter}</td>
                         <td> ${board.bdate}</td>
                         <td>
                            <button onclick="onDelete(${board.bno})"> 삭제</button>
                            <button onclick="onUpdate(${board.bno})"> 수정</button>
                        </td>
                     </tr>`
        }
        console.log(response);

    // 3. 출력 , innerHTML=html; 출력할 위치에 내용을 대입한다.
    tbody.innerHTML=html;
}

onFindAll();
// 2] 등록 , 실행조건 : 등록버튼을 클릭했읗 때
const onWrite = async () => {

    // 1. 입력받은 값을 가져온다.
    const bcontentInput = document.querySelector("#bcontnet");
    const bwriterInput = document.querySelector("#bwriter");

    // 2. 객체 생성
    const bcontent = bcontentInput.value;
    const bwriter = bwriterInput.value;

    // 3. 입력받은 값으로 객체 생성
    const obj = {"bcontent" : bcontent, "bwriter": bwriter}
    // 3. 배열 저장  (AXIOS을 이용하여 서버에게 저장한다.)
        // 동기화 AXIOS,1] 현재 함수 앞에 async 키워드를 붙인다. axios 앞에 await 키워드를 붙인다
    const response = await axios.post("/board", obj);      // axios.HTTP메소드명("통신할주소", body본문)
    const data = response.data;
    // 4. 성공안내
    if( data == true ){
        alert("등록성공"); bcontentInput.value = ''; bwriterInput.value = '';
        onFindAll();
    }
    else{ alert("등록실패 : 관리자에게 문의 ");}
}
// 3] 개별 수정
const onUpdate = async (bno)=> {
    //1) 새롭게 수정할 내용 입력받기
    const bcontent = prompt("수정할 내용 : ");
    // 2) 객체(body)구성    속성명과 대입할 값의 변수명이 같다면 속성명 생략 가능
    const obj = {bno, bcontent} // vs { "bno" : bno, "bcontent" : bcontent}
    // 3) axios을 이용해서 서버에게 수정할 요청 후 응답 받기
    const response = await axios.put("/board", obj);
    const data = response.data;
    console.log(obj);
    // 4) 결과 제어
    if (data == true) {
        alert("수정 성공");
        onFindAll();
    } else {
        alert("수정 실패 : 관리자에게 문의")
    }

}
// 4] 개별 삭제
const onDelete = async(bno) => {        // 삭제할 번호를 받는다.

    // 2] axios를 활용하여 삭제할 번호를 서버에게 요청/ 응답 받는다.
    const response = await axios.delete(`/board?bno=${bno}`)
    const data = response.data;
    if (data == true) {
        alert("삭제성공");
        onFindAll(); // 화면 새로고침
    } else {
        alert("삭제 실패 : 관리자에게 문의")
    }
}