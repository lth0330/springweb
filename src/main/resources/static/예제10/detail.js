console.log("예제10 detail,js 실행");

// 1] 쿼리스트링이란? URL(주소) 뒤에 ? 로 매개변수(값) 포함하는 경우
// 2] JS에서 쿼리스트링의 값 가져오는 방법
// new URLSearchParams( location.search ).get( "변수명" );
const bno = new URLSearchParams( location.search ).get( "bno" );
// 3] 확인
console.log( bno );

// 개별조회 함수 정의
const 개별조회 = async( ) =>{
    // 1) 어디에
    const boardBox = document.querySelector('#boardBox');
    // 2) 무엇을 , 쿼리스트링에존재하는( 클릭한 게시물 ) bno 에 게시물 정보 서버에게 요청/응답
    const response = await axios.get( `/board?bno=${ bno }` ); // ?쿼리스트링 방법
    const data = response.data;
    // += 누적 vs = 대입
    let html = `제목 : <div> ${ data.btitle } </div>
                작성자/작성일 : <div> ${ data.bwriter } / ${ data.createDate } </div>
                내용 : <div> ${ data.bcontent } </div>
                <button onclick="개별수정( ${ data.bno } )"> 수정 </button>
                <button onclick="개별삭제( ${ data.bno } )"> 삭제 </button>`;
    // 3) 출력
    boardBox.innerHTML = html;
} //
// 개별조회 함수 호출
개별조회();


// 개별삭제 함수 정의
const 개별삭제 = async (bno) => {
    // 1. 현재 게시물 삭제하기 위해 현재 게시물번호 확인(bno)
    // 2. axios 이용하여 서버에서 게시물 확인하여 요청 결과받기;

    const response = await axios.delete(`/board?bno=${bno}`);
    const data = response.data;

    // 3. 결과
    if (data) {
        alert("삭제 성공")
        location.href = "/예제10/index.html"

    }else {alert("삭제 실패")}
}


// 개별수정 함수 정의
const 개별수정 = async (bno) => {
    // 1. 현재 게시물 수정하기 위해 현재 게시물번호 확인
    console.log(bno);

    // 2. 수정할 내용 입력받기, 테스트용
    const btitle =prompt("수정할 제목");
    const bcontent = prompt("수정할 내용")
    const bwriter = prompt("수정할 작성자")

    // 3. axios 이용한 서버에게 수정 요청 응답 받기
    const obj = {bno,btitle,bcontent,bwriter}
    console.log(obj);
    const response = await axios.put(`/board`,obj);
    const data = response.data;

    // 4. 결과
    if (data){
        alert("수정성공")
        location.reload();
    }else {alert("수정 실패");}
}

const cno = new URLSearchParams( location.search ).get( "cno" );

// 댓글 조회
const 댓글조회 = async( ) => {

    const commentspace = document.querySelector('.commentspace');
    const response = await axios.get(`/comment?bno=${bno}`);
    const data = response.data;
    let html = ""
    for (let index = 0; index <= data.length - 1; index++) {
        const commentDto = data[index];
        html += `<div><span>${commentDto.cwriter}</span></br><span>${commentDto.createDate}</span><span> 
                            <button onclick="댓글수정()">수정</button> 
                            <button onclick="댓글삭제()">삭제</button></span>
                       </div></br>
                           <div> ${commentDto.ccontent} </div>`
        // 3) 출력
        commentspace.innerHTML = html;
    } //
}
    댓글조회();
// 댓글 등록
const 댓글등록 = async ()=>{

    const writerInput = document.querySelector(".commentwriter");
    const contentInput  = document.querySelector(".commentcontent")

    const cwriter = writerInput.value;
    const ccontent = contentInput.value;

    const obj = {cwriter,ccontent,bno};
    const response = await axios.post("/comment",obj)
    const data = response.data;

    if(data){
        alert("댓글등록 성공");
    }
    else {alert("댓글등록 실패")}
}



// 댓글 수정


// 댓글 삭제