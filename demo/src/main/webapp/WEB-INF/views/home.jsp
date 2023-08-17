<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body>
    <!-- <form action="" enctype="multipart/form-data"> 없어도 파일 전송 가능
        아작스로 정보 보낼 때 form 태그가 필요한 건 아니에용!!(submit으로 보낼 때만 필요)-->
        <h1>수진이 동사무소 다녀왔어용</h1>
        <div id="disp"></div>
        <a href="/upload/공유.jpg" download="꽁유.jpg">공유 다운로드</a>
        <input type="file" name="" id="mFile" value=""><br>
        <button onclick="fpost()">post 테스통</button>
        <button onclick="ffile()">파일 테스통</button>
    <!-- </form> -->
    <script>
        function fpost(){
            // ajax 데이터 받을 때 추천 방법
            // 눈에 보이도록 -> debugging 편함
            // 개발할 때는 보내는 데이터의 모습을 눈 가까이 둡니당
            let data = [
                {
                    name : "로제",
                    age : ["1","2","3"]
                },
                {
                    name : "제니",
                    age : ["4","5","6"]
                },
                {
                    name : "리사",
                    age : ["7","8","9"]
                },
                {
                    name : "지수",
                    age : ["10","11","12"]
                }
            ]            
            var xhr = new XMLHttpRequest();
            xhr.open("POST","/sujin", true);    // get은 url에 정보를 담고 전달
            xhr.setRequestHeader("Content-Type","application/json; charset=UTF-8"); // json형태의 문자열이 넘어간다는 걸 알려줌. 
            xhr.onreadystatechange = function(){
                if(xhr.readyState == 4 && xhr.status == 200){
                    console.log(JSON.parse(xhr.responseText));
                    // jQuery에서는 dataType에 json을 적으면 JSON.parse를 해주는게 숨겨져 있음.
                    // js에서는 다 적어주어야함. 
                }
            }
            // js <-> java 서로의 객체타입은 이해 못함, 오직 이해하는 건 문자열 형태
            xhr.send(JSON.stringify(data)); // get 이외의 전송방식은 send안에 정보를 보냄
        }

        // 230704
        const myFile = document.querySelector("#mFile");
        const myDisp = document.querySelector("#disp");
        // function ffile(){
        //     // 아작스로 파일 올릴 땐 꼬옥 FormData가 필요!!!!
        //     // FormData는 무조건 multipart/form-data 형식(자동)

        //     let formData = new FormData();  // 생성하기만 하면 무조건 !!!
        //     //formData.append("이름", 값);    // formData 는 append만 주로 사용. 파일은 값에 파일 객체를 넣어주기
        //     console.log("생각 안나면 찍으세용 : ",myFile.files);
        //     formData.append("myFile", myFile.files[0]); 

        //     /* formData를 보낼 땐 다른 세세한 설정들은 필요없음 */
        //     var xhr = new XMLHttpRequest();
        //     xhr.open("POST","/mfile", true);  
        //     xhr.onreadystatechange = function(){
        //         if(xhr.readyState == 4 && xhr.status == 200){
        //             console.log(xhr.responseText);  // url경로를 돌려받음.
                    
        //             let aTag = document.createElement("a");
        //             aTag.href = xhr.responseText;
        //             aTag.innerHTML = "파일 다운로드";
        //             aTag.download = xhr.responseText.split("/")[2];
        //             myDisp.appendChild(aTag);
        //         }
        //     }
        //     xhr.send(formData); 
        // }

        // ajax 파일 업로드 jQuery 사용
        function ffile(){
            let formData = new FormData();
            formData.append("myFile", myFile.files[0]); 
            $.ajax({
                type : "POST",
                url : "/mfile",
                // 요기가 중요
                // jquery는 기본적으로 강제 초기값 세팅해줌. - 이것을 해제해주는 역할
                contentType : false,    // 필수, 강제 초기설정 하지망 www-url-encoded
                processData : false,    // 필수, 처리시에 www-url-encoded로 하는 거 하지망
                cache : false,          // 요건 옵션 안해도 됨
                data : formData, 
                dataType : "text",
                success : function(rslt){
                    let aTag = document.createElement("a");
                    aTag.href = rslt;
                    aTag.innerHTML = "파일 다운로드";
                    aTag.download = rslt.split("/")[2];
                    myDisp.appendChild(aTag);
                }
            })
        }
    </script>
</body>
</html>