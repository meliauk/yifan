
import router from '../router/index';
import store from '../store/index';
import {getOneOur,getOur } from '@/api/blog';

export const ourJs = function () {

    var Pname = [];
    Ours();

    var ww = innerWidth;//获取浏览器宽度
    var wh = innerHeight;//获取浏览器高度

    var imgW = 0;//设置图片宽度
    var imgH = 0;//设置图片高度

    var seatX = 0;//设置X轴位置
    var seatY = 0;//设置Y轴位置
    var Zi= 2;

    var people = document.getElementById("ours");//获取屏幕
    var Pimg =  people.getElementsByTagName("img");

    async function Ours() {
        await getOur().then(res=>{
            Pname = res.data;
            for(var i=0; i<Pname.length; i+=1){//循环创建
                var img=document.createElement('img');//要创建的对象
                img.id="p"+i;//定义每个li的ID
                //li.textContent = i;//每个li标上数字
                people.appendChild(img);//创建li
                size();//设置每个图片随机大小
                seatx();//设置每个照片随机位置
                seaty();
                img.style.width=imgW+"px";//设置CSS样式
                img.style.height=imgH;
                img.style.left=seatX+"px";
                img.style.top=seatY+"px";
                img.style.zIndex=i;
                img.src="pic/"+Pname[i].blogId+".jpg";
                img.index=i;
                img.onclick=function(){//点击事件
                    router.push({
                        path: '/Info',
                        query: {
                            oneour : Pname[this.index],
                        },
                    });
                };
            }

        }).catch(()=>{
            console.log("请求失败")
        });

        Zi = Pname.length;
    }

//———————————— 实时监听浏览器大小变化
    window.onresize = function () {

        ww = window.innerWidth//浏览器窗口的内部宽度（包括滚动条）

            || document.documentElement.clientWidth

            || document.body.clientWidth;

        wh = window.innerHeight//浏览器窗口的内部高度（包括滚动条）

            || document.documentElement.clientWidth

            || document.body.clientHeight;

    };

//————————————设置图片随机大小
    function size(){
        var imgWW;
        if(ww > 900){
            imgWW = Math.floor(Math.random()*(160-80+1)+150);//设置图片宽度
        }
        if(ww <= 900 ){
            imgWW = Math.floor(Math.random()*(160-80+1)+50);//设置图片宽度
        }
        if(imgWW==imgW){//判断宽度是否与上一个宽度一样
            size();//一样重新设置宽度
        } else {
            imgW=imgWW;//不一样就设置
            imgH = "auto";//等比例高度
        }



    }

//————————————设置随机X坐标位置
    function seatx(){
        var seatXX = Math.floor(Math.random()*(ww-imgW)-20);//设置X轴位置
        if(seatXX==seatX&& (seatXX-seatX >30) ){//判断宽度是否与上一个X轴位置一样
            seatx();//一样重新设置X轴位置
        } else {
            seatX=seatXX;//不一样就设置
        }
    }

//————————————设置随机Y坐标位置
    function seaty(){
        var seatYY = Math.floor(Math.random()*wh*0.7);//设置Y轴位置
        if(seatYY==seatY || seatYY< 90){//判断高度是否与上一个Y轴位置一样Y轴位置一样
            seaty();//一样重新设置Y轴位置
        }else {
            if ( seatYY>(wh-imgH) ){//判断是否贴底
                seatY=seatYY-imgH-30;//是》剪掉60像素
            } else {
                seatY=seatYY-20;//否》剪掉20像素
            }
        }
    }



    var g=0;
    function ShuaXin(){
        var Pimg = people.getElementsByTagName("img");
        for(var i=0; i<Pimg.length; i++){
            Pimg[i].className="";
        }
        size();//设置每个图片随机大小
        seatx();//设置每个照片随机位置
        seaty();
        SP();
        Pimg[g].style.width=imgW+"px";//设置CSS样式
        Pimg[g].style.height=imgH;
        Pimg[g].style.left=seatX+"px";
        Pimg[g].style.top=seatY+"px";
        Zi=Zi+1;
        Pimg[g].style.zIndex=Zi;
        Pimg[g].className="flip";
    }
    function SP(){
        var e = 0;
        var f = (Pimg.length-1);
        var gg = Math.floor(Math.random()*(f-e+1)+e);
        if(gg==g){
            SP();
        } else {
            g=gg;
        }
    }
    setInterval(ShuaXin,2000);
};