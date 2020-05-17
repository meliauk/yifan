<template>

    <div id="blogInfo">
        <!-- 左边-->
        <div class="col-md-offset-1 col-md-2 hidden-sm" style="color: white; margin-top: 10vh">
            <p>加 广告</p>
            <el-divider></el-divider>
            <p> *  广告xxx</p>
        </div>
        <!-- 中间-->
        <div class="col-sm-12 col-md-6" style="margin: 50px 20px">
            <div id="blog-view">
                <!-- 标题  -->
                <div class="page-header" style="border:none;margin-bottom: 0px">
                    <h2 style="text-align: center">{{ blog.blogTitle }}</h2>
                    <h6 style="text-align: center">作者 : {{ blog.blogAuthor }}</h6>
                    <hr/>
                </div>
                <textarea name="editormd" style="display:none;" >{{ blog.blogContent }}</textarea>
            </div>
            <br/>
            <div>
                <el-page-header @back="toblog" content="回页面"></el-page-header>
            </div>
        </div>
        <!-- 右边-->
        <div class="col-sm-12 col-md-2 right-Info" style="margin-top: 20vh;">
            <p class="info-right-label">{{ blog.blogPublishType }}</p>
            <el-divider></el-divider>
            <p  class="info-right-sameBlog" v-for="(sitem,sindex) in sameBlogList" :key="sindex"> {{ sindex+1 }} :    {{ sitem.blogTitle }}  + {{ sitem.blogPublishType }} </p>
        </div>
    </div>
</template>
<script>
    import { getSameBlog } from '@/api/blog'
    export default {
        name: "Info",
        data(){
            return{
                blog:[],
                blogcurrent:1,
                sameBlogList:[],
                label:'',
            }
        },
        methods:{
            toblog(){
                /* 定位到具体某一个*/
                window.history.go(-1);
                /* 定位到某一页*/
                this.$router.push({
                    path: '/',
                    query: {
                        currentPage: this.blogcurrent
                    }
                })

            },
            getBlogAllInfo(){
                this.$nextTick(()=>{
                    let editorView = editormd.markdownToHTML("blog-view", {
                        // htmlDecode      : "style,script,iframe",  // you can filter tags decode
                        emoji           : true,
                        taskList        : true,
                        tex             : true,  // 默认不解析
                        flowChart       : true,  // 默认不解析
                        sequenceDiagram : true,  // 默认不解析
                    });
                })
            },
            getSame(label,count){
                getSameBlog(label,count).then(res=>{
                    this.sameBlogList = res.data;
                    console.log(" same => "+res.data)
                }).catch(()=>{alert("请求失败...")})
            }
        },
        mounted(){
            if( this.$route.query.oneour === undefined ){
                this.blog = this.$route.query.oneblog;
                this.label = this.$route.query.oneblog.blogPublishType;
                this.blogcurrent = this.$route.query.onecurrent;
            }else {
                this.blog = this.$route.query.oneour;
            }
            this.getSame(this.label,3);
            this.getBlogAllInfo();
        },
    }
</script>

<style lang="scss" scoped>
    /*  中间*/
    #blog-view{
        border-radius: 5px;
    }
    .el-page-header{
        border-radius: 5px;
        background: #fff;
        height: 50px;
        line-height: 50px;
        width: 100%;
    }
    /* 右边 */
    .right-Info p:hover{
        cursor: pointer;
    }



</style>