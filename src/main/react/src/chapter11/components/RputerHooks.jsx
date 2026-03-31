
export default function RouterHooks(props){
  return(<>

    // [1] useSearchParams 훅 선언한다.   이유 : URL 상의 쿼리스트링 값 가져오기
    const = [searchParams , setSearchParams] = useSeachParams();
    const mode = searchParams.get('mode'); // 쿼리스트링내 mode 변수명 값 가져오기
    const pageNum = searchParams.get('pageNum') // 쿼리스트링내 pageNum변수명 값 가져오기

    // [2] changeMode,  만약에 mode가 list 이면 view 변경 아니면 list 로 변경 
    const changeMode = ( ) => {
        const changeMode = ( mode =="list") ? "view" : "list" ;
        setSearchParams({mode : nextMode, pageNum : pageNum})
    }

  </>)
}