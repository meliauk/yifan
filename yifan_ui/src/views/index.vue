<template>
    <div >
        <div id="nav" class="navbar navbar-default" style="background: rgba(255,255,255,0);border: none">
            <el-menu :default-active="activeIndex"  class="el-menu-demo " mode="horizontal" @select="handleSelect" style="background: rgba(255,255,255,0); color: white;font-weight: bold">
                <el-menu-item index="1">
                    <router-link :to="{name:'blog'}">文章</router-link>
                </el-menu-item>
                <el-menu-item index="2">
                    <router-link :to="{name:'ours'}">我她</router-link>
                </el-menu-item>
                <el-menu-item index="3">
                    <router-link :to="{name:'timeRec'}">时间</router-link>
                </el-menu-item><!--
                <el-menu-item index="4">
                    <router-link :to="{name:'message'}">留言</router-link>
                </el-menu-item>-->
                <el-menu-item index="5">
                    <router-link :to="{name:'about'}">关于</router-link>
                </el-menu-item>
            </el-menu>
        </div>
        <router-view/>
    </div>

</template>

<script>
    export default {
        name: "index",
        data(){
            return{
                activeIndex: '1',
            }
        },
        mounted(){
        },
        methods: {
            handleSelect(key, keyPath) {
                console.log(key, keyPath);
            }
        }
    }
</script>

<style type="scss" scoped>
    .el-menu--horizontal>.el-menu-item{
        border-radius: 10%;
        color:rgba(0, 0, 0, 0.774);
    }
    .el-menu--horizontal>.el-menu-item.is-active {
        border-bottom: 2px solid #409EFF;
        color: #399af5;
    }
     .el-menu-item :hover{
        background: #77b5f5;
        border-radius: 10%;
    }
    #nav{
        box-shadow: none;
        margin: 0px auto;
    }
    .el-menu{
        width: 340px;
        margin: 0 auto;
    }
    ul li{
        padding: 0;
    }
    .el-menu-item{font-size: 20px}
    .el-menu-item a{
        display: inline-block;
        text-align: center;
        width: 85px;
        height: 60px;
        line-height: 60px;
    }
    .el-menu.el-menu--horizontal{
        border: none;
    }
    .el-row {
        margin-bottom: 20px
    }
    .el-row:last-child {
        margin-bottom: 0;
    }

</style>