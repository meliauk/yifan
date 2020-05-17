<template>

    <div id="blog" style="padding-top: 20px; height: 100%;">
        <!-- 搜索-->
        <div class="row" style="margin: auto 0px">
            <div class="col-sm-6 col-sm-offset-3">
                <el-row>
                    <el-input :span="12"
                              show-word-limit maxlength="30"
                              clearable
                              v-model="inputBlog"
                              placeholder="请输入内容"
                              @input="findBlog()"

                    >
                        <!--@ keyup.enter.native-->
                        <i slot="prefix" class="el-icon-search el-input__icon"></i>
                    </el-input>
                </el-row>
            </div>
        </div>
        <br/>
        <!-- 内容-->
        <div class="row" style="margin: auto 0px">
            <!-- 左边-->
            <div class="hidden-xs col-md-2 col-lg-offset-1 " style="margin-top: 30vh;color: black">
                <div>
                    <span>这是相关信息呀!!!</span>
                    <el-divider></el-divider>
                    <span>这是相关公告~~</span>
                </div>
            </div>
            <!-- 中间-->
            <div class="col-sm-12 col-md-6">
                <!--blogs-->
                <el-row class="blog-content"  v-for="(item,index) in $store.state.blogList" :key="index" @click.native="toblogInfo(item)" >
                    <el-card  shadow="hover">
                        <el-container>
                            <el-header>{{ item.blogTitle  }}</el-header>
                            <el-main>
                                <span style="width: 30px;display: inline-block"></span>
                                {{item.blogDesc}}
                            </el-main>
                            <el-footer>
                                <span><i class="el-icon-time"></i>  {{ item.blogTime }}</span>
                                <span><i class="el-icon-view"></i> {{ item.blogRead }}</span>
                                <span><i class="el-icon-chat-square"></i> {{ item.blogComm }}</span>
                                <span><i class="el-icon-star-off"></i> {{ item.blogLike }}</span>
                                <ui style="float: right;color: #900000">
                                    <li> <span class="glyphicon glyphicon-star" style="margin-right: 5px"></span>{{item.blogPublishType}} </li>
                                </ui>
                            </el-footer>
                        </el-container>
                    </el-card>
                </el-row>
                <!--上下页-->
                <el-row :style="{ display:(sate?'':'none')}" >
                    <ul class="pager" style="width: 100%;padding-bottom: 70px">
                        <li class="previous">
                            <button type="button" id="1" class="btn btn-default pull-left bpage" @click="blogs(--current,$event)" >
                                <span aria-hidden="true">&larr;</span> 上一页
                            </button>
                        </li>
                        <li class="text-center"><span>{{current}}/{{pages}}</span></li>
                        <li class="next">
                            <button type="button"  class="btn btn-default pull-right bpage" @click="blogs(++current,$event)" disabled="disabled">
                                下一页 <span aria-hidden="true">&rarr;</span>
                            </button>
                        </li>
                    </ul>
                </el-row>
            </div>
            <!-- 右边-->
            <div class=" col-md-3" style="position: fixed; right: 0px" >
                <div class="demo-image__placeholder col-xs-12" style="padding-bottom: 50px;">
                    <div class="block" >
                        <el-image :src="src">
                            <div slot="placeholder" class="image-slot text-center" style="line-height: 80px">
                                加载中<span class="dot">...</span>
                            </div>
                        </el-image>
                        <h4 >这就是我</h4>
                        <h6>QQ : 2050781802</h6>
                    </div>
                </div>
                <div class="Blog-type" style="padding: 15px;width:240px ">
                    <span class="span-type">Java</span>
                    <span class="span-type">JavaScript</span>
                    <span class="span-type">Vue</span>
                    <span class="span-type">Mysql</span>
                    <span class="span-type">Other</span>
                </div>
            </div>

        </div>
        <!-- 漂浮-->
        <div class="float_div  hidden-xs">
            <img  class="hidden-sm" @click="float_div()" src="qt.png" alt="图片" style="z-index: 99" width="260px">
        </div>

    </div>

</template>

<script>
    import { getBlog,selectBlog } from '@/api/blog';
    export default {
        name: "blog",
        data() {
            return {
                inputBlog: '',
                src: 'https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg',
                current:1,
                selectCurrent:1,
                size:5,
                pages:0,
                sate:true,//上下页 显示

            }
        },
        created(){
            if(this.$route.query.currentPage===undefined){
                this.blogs(1);
            }else {
                this.current = this.$route.query.currentPage;
                this.blogs(this.current);
            }
        },
        methods:{
            float_div(){
                console.log("===> 点击了切换主题" + this.$store.state.themes.length);
                let i = 0;
                // 取到设置皮肤的link
                let themeLink = document.querySelector('link[name="theme"]');

                if(themeLink.getAttribute("href") ==="theme/"+ this.$store.state.themes[i]+".css" && i< this.$store.state.themes.length ){
                    i+=1 ;
                }else {
                    i = 0 ;
                }
                themeLink.setAttribute('href', "theme/"+ this.$store.state.themes[i]+".css");

            },
            blogs(current,e){
                getBlog(this.current,this.size).then(res=>{
                    if(this.current>=1 && this.current<=res.data.pages){
                        this.pages = res.data.pages;
                        this.$store.state.blogList = res.data.records;
                        $(".bpage").removeAttr("disabled");
                    }else {
                        let that = e.target;
                        alert("已经没用数据了亲~");
                        $(that).attr("disabled","disabled");
                        return false;
                    }
                }).catch(()=>{  this.sate = false;console.log("请求失败")})

            },

            findBlog(){
                console.log(" this.inputBlog ===> "+this.inputBlog);
                if(this.inputBlog === null || this.inputBlog === ''){
                    this.blogs(1);
                }else {
                    selectBlog(this.inputBlog,this.selectCurrent,this.size).then(res=>{
                        console.log(this.selectCurrent);
                        if(res.data.length!==0){
                            this.$store.state.blogList = res.data.records;
                            console.log( this.$store.state.blogList );
                        }else {
                            alert("您搜索的内容不存在~")
                        }

                    }).catch(()=>{console.log("请求失败")})
                }
            },
            toblogInfo(item){
                this.$router.push({
                    path: '/Info',
                    query: {
                        oneblog:item,
                        onecurrent: this.current
                    }
                })
            },

        },


    }
</script>

<style lang="scss" scoped>

    .float_div{
        animation: myfirst 3s infinite  linear;
        transform-origin:top center; // 设置旋转的中心点 transform-origin
        display: inline-block;
        position: fixed;
        top: 0px;
        left: 100px;
    }
    @keyframes myfirst
    {
        8%{
            transform:rotate(-4deg);
        }
        16%{
            transform:rotate(-8deg);
        }
        24%{
            transform:rotate(-12deg);
        }
        32%{
            transform:rotate(-8deg);
        }
        40%{
            transform:rotate(-4deg);
        }
        50%{
            transform:rotate(0deg);
        }
        60%{
            transform:rotate(4deg);
        }
        68%{
            transform:rotate(8deg);
        }
        76%{
            transform:rotate(12deg);
        }
        84%{
            transform:rotate(8deg);
        }
        92%{
            transform:rotate(4deg);
        }
        100%{
            transform:rotate(0deg);
        }
    }
    /deep/ .el-input__inner{
        height: 40px;
        line-height: 40px;
    }

    /*  中间  */
    .el-card{
        background: rgba(255,255,255,0.9);
        margin-bottom: 20px;
        width: 100%;
        border-radius: 10px;
    }
   .el-container{
       height: 180px;
    }
    .el-header {
        color: #343434;
        text-align: center;
        line-height: 60px;
        font-size: 20px;
        font-weight: bold;
    }
    .el-footer {
        line-height: 60px;
        text-align: left;
    }
    .el-footer span{
        margin-right: 20px;
    }
    .el-main {
        color: #262626;
        display:-webkit-box;
        -webkit-line-clamp:3;
        -webkit-box-orient: vertical;
        overflow:hidden;
        padding:0 10px;
    }

    /* 右边 */
    .span-type{
        color:white;
        border-radius: 5px;
        padding: 5px;
        display: inline-block;
        background: #2C7EEA;
        margin: 5px 5px;
    }
    .demo-image__placeholder{
        text-align: left;
    }
    .block{
        padding-top: 20px;
        width: 190px;
        height: 190px;
        border: 1px  #ccc dashed;
        background: rgba(255,255,255,0.9);
        /*background: cadetblue;*/
        border-radius: 10px;
        text-align: center
    }
    .el-image{
        width:80px; height:80px;
        border-radius: 50% 50%;
    }

</style>