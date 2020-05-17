<template>
    <div id="about" style="padding: 20px">
        <div  class=" block" >
            <el-row>
                <el-col :span="12" :offset="6">
                    <el-timeline>
                        <el-timeline-item timestamp="2018/4/12" placement="top" >
                            <el-card>
                                <h4>更新 页面</h4>
                                <p>王余凡 提交于 2019/12/24 22:55</p>
                            </el-card>
                        </el-timeline-item>
                        <el-timeline-item timestamp="2018/4/3" placement="top" type="danger" size="large">
                            <el-card>
                                <h4>编写网页代码</h4>
                                <p>王余凡 提交于 2019/12/24 21:46</p>
                            </el-card>
                        </el-timeline-item>
                        <el-timeline-item timestamp="2018/4/2" placement="top" type="primary "size="large">
                            <el-card >
                                <h4>萌发想法</h4>
                                <span>青春是一个短暂的美梦, 当你醒来时, 它早已消失无踪</span>
                                <el-divider direction="vertical"></el-divider>
                                <span>为了无法计算的价值</span>

                                <el-divider content-position="right">王余凡</el-divider>
                                <p>王余凡 提交于 2019/12/22 20:46</p>
                            </el-card>

                        </el-timeline-item>
                    </el-timeline>
                </el-col>
            </el-row>
        </div>

    </div>
</template>

<script>
    export default {
        name: "about",

    }
</script>

<style scoped>

</style>