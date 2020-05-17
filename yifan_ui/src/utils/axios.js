import axios from 'axios';
import { Message } from 'element-ui';
/*
* axios拦截器
* */
// 创建axios
const BASEURL = process.env.NODE_ENV === 'production' ? '' : '/devApi';
console.log(BASEURL)
const instance = axios.create({
    baseURL:BASEURL,
    /*
    *  这里请求的 '/devApi'为 http://localhost:8080/devApi  => 会替换成 vue.config.js 中 proxy 的 target 值 （ http://localhost:1234/devApi ）
    * */
    timeout:3000,
});

// 添加请求拦截器
instance.interceptors.request.use(function (config) {
    // 在发送请求之前做些什么
    return config;
}, function (error) {
    // 对请求错误做些什么
    return Promise.reject(error);
});

// 添加响应拦截器
instance.interceptors.response.use(function (response) {
    // 对响应数据做点什么
    return response;
}, function (error) {
    // 对响应错误做点什么
    return Promise.reject(error);
});



export default instance;





/**
 * 使用export default时，但不能同时存在多个default。
 * 文件 import 不需要花括号，
 */