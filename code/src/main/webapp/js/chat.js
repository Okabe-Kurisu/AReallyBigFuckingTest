$(function () {

    $("document").ready(function() {
        getUserNames()
    })

    //获取好友列表
    function getUserNames(){
        param = {
            uid:2,
        }
        $.ajax({
            url: "/message/getSendMessageUserId",
            data: param,
            type: "POST",
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
            dataType: "json",
            success: function(data) {
                if (data.code == 200) {
                    console.log(data.data[0].nickname)
                }else{
                    mdui.snackbar("聊天失败,");
                }
            },
            error: function() {
                mdui.snackbar("注册失败");
            },
        })


    }

})