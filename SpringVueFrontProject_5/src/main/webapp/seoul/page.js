let listApp=Vue.createApp({
			data(){
				return{
					seoul_list:[],
					curpage:1,
					totalpage:0,
					startPage:0,
					endPage:0,
					type:1,
					title:'서울 명소'
				}
			},
			mounted(){
				// 시작과 동시에 한페이지 읽기
				this.dataRecv()
			},
			//update
			// Vue의 멤버함수
			methods:{
				prev:function(){
					this.curpage=this.curpage>1?this.curpage-1:this.curpage
					this.dataRecv()
				},
				next(){
					this.curpage=this.curpage<this.totalpage?this.curpage+1:this.curpage
					this.dataRecv()
				},
				pageChange(page){
					this.curpage=page
					this.dataRecv()
				},
				range(start,end){
					let arr=[]
					let len=end-start
					for(let i=0; i<=len;i++){
						arr[i]=start
						start++;
					}
					return arr;
				},
				seoul(type){
						this.type=type
						this.curpage=1
						this.dataRecv()
				},
				dataRecv(){
					axios.get("http://localhost:8080/web/seoul/list_vue.do",{
						params:{
							page:this.curpage,
							type:this.type
						}
					 }).then((response) => {
				            console.log(response)
				            this.seoul_list = response.data.list
				            this.title = response.data.title
				            this.curpage=response.data.curpage
				            this.totalpage=response.data.totalpage
				            this.startPage=response.data.startPage
				            this.endPage=response.data.endPage
				     }).catch((error) => {
				            console.log(error.response)
				     })
				}
			}
			// watch / computed / components
		}).mount(".container")