import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);

export default new Vuex.Store({
    /* 全局变量*/
    state: {
        blogState: false, // 状态
        blogList: [],
        ourList:[],
        themes:[ 'main','a' ]
    },
    /* 处理全局变量 只有他才有权利修改state中的数据 */
    mutations: {},
    /* 异步处理全局变量 不能直接修改 state中的数据 通过context.commit() 触发 mutations */
    actions: {},
    modules: {}
});
