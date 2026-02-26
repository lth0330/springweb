console.log("practice.js 실행");


// post
const post = async () => {
    try{
    const response = await axios.get("/attendance?studentName=홍길동&date=2026-02-26&status=출석")
    console.log(response.data)
    }catch(e){console.log(e);}

}
post();