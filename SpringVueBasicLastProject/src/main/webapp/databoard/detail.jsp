<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
 margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 800px;
}
</style>
</head>
<body>
  <div class="container">
   <div class="row" id="detailApp">
     <h3 class="text-center">내용보기</h3>
     <table class="table">
       <tr>
        <th width=20% class="text-center">번호</th>
        <td width=30% class="text-center">{{vo.no}}</td>
        <th width=20% class="text-center">작성일</th>
        <td width=30% class="text-center">{{vo.dbday}}</td>
       </tr>
       <tr>
        <th width=20% class="text-center">이름</th>
        <td width=30% class="text-center">{{vo.name}}</td>
        <th width=20% class="text-center">조회수</th>
        <td width=30% class="text-center">{{vo.hit}}</td>
       </tr>
       <tr>
        <th width=20% class="text-center">제목</th>
        <td colspan="3">{{vo.subject}}</td>
       </tr>
       <tr v-if="vo.filecount>0">
        <th width=20% class="text-center">첨부파일</th>
        <td colspan="3">
          <ul>
            <li v-for="(fn,index) in filename">
              <a :href="'download.do?fn='+fn">{{fn}}</a>({{filesize[index]}}Bytes)
            </li>
          </ul>
        </td>
       </tr>
       <tr>
         <td colspan="4" valign="top" class="text-left"
          height="200">
           <pre style="white-space: pre-wrap;">{{vo.content}}</pre>
         </td>
       </tr>
       <tr>
         <td colspan="4" class="text-right">
          <a href="list.do" class="btn btn-xs btn-primary">목록</a>
         </td>
       </tr>
     </table>
   </div>
   <div style="height: 10px"></div>
   <div class="row" id="replyApp">
    <table class="table">
      <tr>
        <td>
          
        </td>
      </tr>
    </table>
    <c:if test="${sessionScope.id!=null }">
    <table class="table">
      <tr >
       <td><textarea rows="4" cols="65" style="float: left"
          v-model="msg" ref="msg"
       ></textarea>
        <input type=button value="댓글쓰기" class="btn-primary"
          style="float: left;height: 92px"
           @click="replyInsert()"
          >
       </td>
      </tr>
    </table>
    </c:if>
   </div>
  </div>
  <script>
   let detailApp=Vue.createApp({
	   data(){
		   return {
			   no:${param.no},
			   vo:{},
			   filename:[],
			   filesize:[]
		   }
	   },
	   mounted(){
		   axios.get('detail_vue.do',{
			   params:{
				   no:this.no
			   }
		   }).then(response=>{
			   console.log(response.data)
			   this.vo=response.data
			   let count=response.data.filecount
			   if(count>0)
			   {
				   this.filename=response.data.filename.split(",")
				   this.filesize=response.data.filesize.split(",")
			   }
		   }).catch(error=>{
			   console.log(error.response)
		   })
	   }
   }).mount("#detailApp")
   
   let replyApp=Vue.createApp({
	   data(){
		   return {
			   bno:${no},
			   reply_list:[],
			   msg:'',
			   sessionId:'${sessionId}'
			     
		   }
	   },
	   methods:{
		   replyInsert(){
			   if(this.msg==="")
			   {
				   this.$refs.msg.focus()
				   return
			   }
			   axios.post('../reply/insert_vue.do',null,{
				   params:{
					   bno:this.bno,
					   msg:this.msg
				   }
			   }).then(response=>{
				   console.log(response.data)
				   this.reply_list=response.data
				   this.msg=''
			   })
			   
			   
		   }
	   }
   }).mount("#replyApp")
  </script>
</body>
</html>