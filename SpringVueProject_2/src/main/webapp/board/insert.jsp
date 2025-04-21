<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<style type="text/css">
.container{
   margin-top: 50px;
}
.row {
   margin: 0px auto;
   width: 800px;
}
h3{
  text-align: center;
}
</style>
</head>
<body>
  <div class="container">
   <div class="row">
     <h3>글쓰기</h3>
     <table class="table">
     <tr>
      <th width=15%>이름</th>
      <td width=85%>
       <input type=text ref=name size=20 v-model="name"
        class="input-sm"
       >
      </td>
     </tr>
     <tr>
      <th width=15%>제목</th>
      <td width=85%>
       <input type=text ref=subject size=50 v-model="subject" 
        class="input-sm"
       >
      </td>
     </tr>
     <tr>
      <th width=15%>내용</th>
      <td width=85%>
       <textarea rows="5" cols="52" ref=content v-model="content"></textarea>
      </td>
     </tr>
     <tr>
      <th width=15%>비밀번호</th>
      <td width=85%>
       <input type=password ref=pwd size=10 v-model="pwd"
        class="input-sm"
       >
      </td>
     </tr>
     <tr>
       <td colspan="2" align=center>
         <input type=button value="글쓰기" class="btn-sm btn-danger"
           @click="insert()"
         >
         <input type=button value="취소" class="btn-sm btn-primary"
          onclick="javascript:history.back()"
         >
       </td>
     </tr>
   </table>
   </div>
  </div>
  <script type="importmap">
  {
     "imports":{
       "vue":"https://unpkg.com/vue@3/dist/vue.esm-browser.js"
     }
  }
  </script>
  <script type="module">
   import {createApp} from "vue"
   const app=createApp({
      data(){
         return {
            name:'',
            subject:'',
            content:'',
            pwd:'',
            msg:''
         }
      },
      methods:{
         insert(){
             
             this.dataRecv()
         },
         async dataRecv(){
            if(this.name==='')
             {
                 alert("추가")
                 this.$refs.name.focus()
                 return
             }
            const res= await axios.post('/board/insert_vue',{
               name:this.name,
               subject:this.subject,
               content:this.content,
               pwd:this.pwd
            })
            if(res.data.msg==='yes')
            {
              location.href="/board/list"
            }
            else
            {
               alert("글쓰기 입력에 실패하셨습니다")
            }
         }
      }
   })
   app.mount(".container")
  </script>
</body>
</html>