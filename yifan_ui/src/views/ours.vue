<template>

    <div id="ours">
    </div>

</template>

<script>
    import { ourJs } from '@/utils/our'
    export default {
        name: "ours",
        data(){
            return {};
        },
        methods:{
            async   createPic(){
                //vue中在页面渲染完之后获取元素
                this.$nextTick(function () {
                    ourJs();
                });
            }
        },
        created(){
            this.createPic();
        }
    }
</script>

<style lang="scss" scoped>
    @import "../utils/our.css";
</style>