import server from '@/utils/axios'

/*
* 获取 blog
* */
export const getBlog = (current,size) =>{
    return server({
        method:'get',
        url:'/yifan/blogs',
        params:{
            current,
            size
        }
    })
}

/*
* 搜索 blog
* */
export const selectBlog = (infos,selectCurrent,size) =>{
    return server({
        method:'post',
        url:'/yifan/seleblog',
        params:{
            info:infos,
            current:selectCurrent,
            size,

        }
    })
};

/*
* 我们的文章
* */
export const getOur = () =>{
    return server({
        method:'get',
        url:'/yifan/seleOur',
    })
};

/*/!*
* 查询一个  详情
* *!/
export const getOneOur = (id) =>{
    return server({
        method:'get',
        url:'/yifan/oneOur',
        params:{
            id
        }
    })
};*/

/*
* 相关文章 标签  数量
* */
export const getSameBlog = (label,count) =>{
    return server({
        method:'get',
        url:'/yifan/sameBlog',
        params:{
            label,
            count
        }
    })
};
