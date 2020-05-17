function changType(e){
    var text = $(e).val();
    if( $("#inp").val() != text ){
        $("#inp").val(text);
    }

    console.log(  $("#inp").val())
}

$(function () {

    //输入标签
    $("#tag").click(function () {
        var dis = $(".selectTags").css("display");
        if(dis == "block"){
            $(".selectTags").hide();
        }else {
            //默认标签第一个
            $("#language").addClass("active");

            $(".selectTags").show();
        }
    });


/*    if($(".input-error").val()!=null){
        alert($(".input-error").val());
    }*/


});

function selectTag(e) {
    var value = $(e).attr("data-tag")
    var tag = $("#tag").val();
    if(tag.indexOf(value) == -1){
        if(tag){
            $("#tag").val(tag+','+value);
        }else {
            $("#tag").val(value);
        }
    }
}


var editor = null;

$(function() {

    editor = editormd("test-editor", {
        width  : "100%",
        height : 800,
        path   : "/markdown/lib/",
        watch  : false,
        emoji: true,//表情
        syncScrolling : "single",
        toolbarAutoFixed:true,//工具栏自动固定定位的开启与禁用
        saveHTMLToTextarea: true,
        placeholder:"发布Blog",
        imageUpload:true,
        imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
        imageUploadURL : "/publish/uploadImage",//注意你后端的上传图片服务地址

      //  toolbarIcons: "simple"
    });



    // $("#blogtext").val(editor.getHTML())
});


/*==============ajax====================*/
/*

$('#submitBtn').click(function(){
    $.ajax({
        type: "POST",
        url: "/admin/addBlog",
        dataType: "json",
        data:{
            blogTitle:$("#blogTitle").val(),
            blogType:$("#blogType").val(),
            blogDesc:$("#blogDesc").val(),
            blogContent:$("#blogContent").val(),
            tag:$("#tag").val()
        },
        success: function (data) {
            alert("发布成功...")
        },
        error: function (e) {
            alert("发布失败...")
            console.log(e)
        }
    })
});


*/


