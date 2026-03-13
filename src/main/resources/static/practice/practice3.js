console.log("practice.js 실행");


// 1. post
const 등록 = async () => {
    try{
        const data = {"studentName" : "홍길동111","data" : "2026-03-13","staus":" 출석"}
    const response = await axios.get("/attendance", data)
    console.log(response.data)
    }catch(e){console.log(e);}

}


// 2. Get
const 전체조회 = async () => {
    try {
        const response = await axios.get("/attendance");
        console.log(response.data);
    } catch(e){console.log(e);}

}

// 3. Get
const 개별조회 = async () => {
    try {
        const response = await axios.get("/attendance/detail?ano=1");
        console.log(response.data);
    }catch(e){console.log(e);}
}

// 4. delete
const 삭제 = async () => {
    try {
        const response = await axios.delete("/attendance?ano=1");
        console.log(response.data);
    } catch(e){console.log(e);}
}

// 5. put
const 수정 = async () => {
    try {
        const data = {
            "ano": 1,
            "status": "지각"
        };
        const response = await axios.put("/attendance", data);
        console.log(response.data);
    } catch(e){console.log(e);}
}