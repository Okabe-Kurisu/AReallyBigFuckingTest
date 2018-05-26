$(function () {
    //全局变量


    $("document").ready(function () {
        // 初始化操作
        getBlogInDiscuss()

    });

    //绑定事件


    // function
    var getBlogInDiscuss = function () {
        var did = sessionStorage.getItem('blog_did');
        //显示标题
        var dname = sessionStorage.getItem('blog_dis_title');
        $(".blog-discuss-name").text(dname);
        //获取数据
        param = {
            did: did
        };
        $.ajax({
            url: "/discuss/getBlogInDiscuss",
            type: "POST",
            data: param,
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
            dataType: "json",
            success: function (data) {
                if (data.code == 200 && data.data != null) {
                    $(".blog-discuss-list").text("");
                    var blogs = data.data;
                    for (x in blogs) {
                        var blog = blogs[x];

                        var res = formatBlogHtml(blog);


                        $(".blog-discuss-list").append(res);
                    }

                } else {
                    mdui.snackbar("请先登陆");
                }
            },
            error: function () {
                mdui.snackbar("请求错误");
            },
        });
    }

    var formatBlogHtml = function (blog) {
        var res = "<div class=\"mdui-card mdui-m-t-1 blog-card\" bid=" + blog.bid + ">\n" +
            "                <div class=\"mdui-card-header\">\n" +
            "                    <img class=\"mdui-card-header-avatar\" src=\"" + blog.avatar + "\"/>\n" +
            "                    <div class=\"mdui-card-header-title\">" + blog.username + "</div>\n" +
            "                    <div class=\"mdui-card-header-subtitle\">" + blog.motto + "</div>\n" +
            "                    <!-- 时间戳生成发博时间 -->\n" +
            "                    <div class=\"mdui-card-menu mdui-text-color-grey-500\">\n" +
            "                        <p>" + formatMsgTime(blog.release_time) + "</p>\n" +
            "                    </div>\n" +
            "                </div>\n";
        // 如果blog中包含图片
        if (blog.multimedia != null) {
            res += "                <div class=\"mdui-card-media\">\n" +
                "                    <img src=\"" + blog.multimedia + "\"/>\n" +
                "                </div>\n";
        }
        // 如果blog中包含转发内容
        if (blog.type == 2) {
            res += "                <div class=\"mdui-card-content\">" + param.content + "</div>\n"
        } else {
            res += "                <div class=\"mdui-card-content\">" + blog.content + "</div>\n"
        }

        res += "                <div class=\"mdui-card-actions\">\n" +
            "                    <button class=\"mdui-btn mdui-btn-dense mdui-ripple mdui-text-color-theme thumb_up\"><i\n" +
            "                            class=\"mdui-icon material-icons\">thumb_up</i>赞(" + blog.likeNum + ")\n" +
            "                    </button>\n" +
            "                    <button class=\"mdui-btn mdui-btn-dense mdui-ripple mdui-text-color-theme commit-toggle\"><i\n" +
            "                            class=\"mdui-icon material-icons\">forum</i>(" + blog.commentNum + ")\n" +
            "                    </button>\n" +
            "                    <button class=\"mdui-btn mdui-btn-dense mdui-ripple mdui-text-color-theme favorite\"><i\n" +
            "                            class=\"mdui-icon material-icons\">folder</i>收藏\n" +
            "                    </button>\n" +
            "                    <button class=\"mdui-btn mdui-btn-dense mdui-float-right mdui-color-red report \"><i\n" +
            "                            class=\"mdui-icon material-icons\">flag</i>举报\n" +
            "                    </button><!-- todo: 如果是鹳狸猿改成封禁 -->\n" +
            "                </div>\n" +
            "            </div>";
        return res;
    }

});
