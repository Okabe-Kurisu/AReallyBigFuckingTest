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

                        var res = formatBlogHtml(blog, "这是一条该话题下的博客");


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

    /*function formatBlogHtml(data, reason) {
        data.ocontent = data.content;
        if (typeof(sessionStorage.keyword)) {
            data.motto = data.motto.replace(sessionStorage.keyword, "<span class=\"mdui-text-color-red\">" + sessionStorage.keyword + "</span>");
            data.nickname = data.nickname.replace(sessionStorage.keyword, "<span class=\"mdui-text-color-red\">" + sessionStorage.keyword + "</span>");
            data.content = data.content.replace(sessionStorage.keyword, "<span class=\"mdui-text-color-red\">" + sessionStorage.keyword + "</span>");
        }
        var res = "<div class=\"mdui-card mdui-m-t-1 blog-card\" bid=" + data.bid + ">\n" +
            "<div class=\"dev-info\" style=\"display: none;\">\n" +
            "<p class=\"mdui-typo-caption mdui-text-color-pink-400 mdui-m-a-1\">这条微博出现在这里，因为<strong>" + data.reason + "</strong></p>\n" +
            "<p class=\"mdui-typo-caption mdui-text-color-pink-400 mdui-m-a-1\">用户权重：<strong>" + data.weight + "</strong></p>\n" +
            "<p class=\"mdui-typo-caption mdui-text-color-pink-400 mdui-m-a-1\">发布环境：<strong>" + data.browserSign + "</strong></p>\n" +
            "</div>\n" +
            "<div class=\"blog-head-menu\">\n" +
            "<button class=\"mdui-btn mdui-btn-dense mdui-text-color-teal dev-info-btn\" mdui-tooltip=\"{content: \'开发信息\', delay: 100}\">\n" +
            "<i class=\"mdui-icon material-icons\">arrow_drop_up</i>\n" +
            "</button>\n";
        if (typeof(sessionStorage.uid) != "undefined" && parseInt(sessionStorage.uid) == parseInt(data.uid)) {
            res += "<button class=\"mdui-btn mdui-btn-dense mdui-text-color-teal mdui-float-right blog-del-btn\">删除</button>\n" +
                "<button class=\"mdui-btn mdui-btn-dense mdui-text-color-teal mdui-float-right blog-edit-btn\">编辑</button>\n";
        }

        res += "</div>\n" +
            "<div class=\"mdui-card-header\">\n" +
            "<a href=\"./?method=userinfo&uid=" + data.uid + "\"><img class=\"mdui-card-header-avatar\" src=\"" + data.avatar + "\"/></a>\n" +
            "<div class=\"mdui-card-header-title\">" + data.nickname + "</div>\n" +
            "<div class=\"mdui-card-header-subtitle\">" + data.motto + "</div>\n" +
            "<!-- 时间戳生成发博时间 -->\n" +
            "<div class=\"mdui-card-menu mdui-text-color-grey-500\">\n" +
            "<p>" + formatMsgTime(data.release_time | data.releaseTime) + "</p>\n" +
            "</div>\n" +
            "</div>\n";
        // 如果blog中包含图片
        if (data.multimedia != null) {
            res += "<div class=\"mdui-card-media\">\n" +
                "<img class=\"blog-media\" src=\"" + data.multimedia + "\"/>\n" +
                "</div>\n";
        }
        // 如果blog中包含转发内容
        if (parseInt(data.type) == 1) {
            res += "<div class=\"mdui-card-content\" content=\"" + data.ocontent + "\">" + data.content + //转发博客的主体内容
                "<!-- 被转发微博在下面， 相当于是在本身微博的最后加上一个新的微博卡片 -->" +
                //先显示正在加载，然后在每次生成微博后绑定上真正的转发内容加载方法,待加载bid获取方法为$(".waitload").attr("bid")
                "<div class=\"mdui-spinner mdui-spinner-colorful waitload\"  bid=\"" + data.commentOn + "\"></div>" +
                "</div>\n"
        } else {
            res += "<div class=\"mdui-card-content\" content=\"" + data.ocontent + "\">" + data.content + "</div>\n"
        }
        res += "<div class=\"mdui-card-actions\">\n" +
            "<button class=\"mdui-btn mdui-btn-dense mdui-ripple mdui-text-color-theme thumb_up\" likeNum=\"" + data.likeNum + "\"><i\n" +
            "class=\"mdui-icon material-icons\">thumb_up</i>赞(<span class=\"likeNum\" >" + data.likeNum + "</span>)\n" +
            "</button>\n" +
            "<button class=\"mdui-btn mdui-btn-dense mdui-ripple mdui-text-color-theme commit-toggle\" commentNum=\"" + data.commentNum + "\"><i\n" +
            "class=\"mdui-icon material-icons\">forum</i>(<span class=\"commentNum\" >" + data.commentNum + "</span>)\n" +
            "</button>\n" +
            "<button class=\"mdui-btn mdui-btn-dense mdui-ripple mdui-text-color-theme favorite\"><i\n" +
            "class=\"mdui-icon material-icons\">folder</i>收藏\n" +
            "</button>\n" +
            "<button class=\"mdui-btn mdui-btn-dense mdui-float-right mdui-color-red report \"><i\n" +
            "class=\"mdui-icon material-icons\">flag</i>举报\n" +
            "</button></div><!-- todo: 如果是鹳狸猿改成封禁 -->\n" +
            "<div class=\"commit-panel mdui-collapse\" mdui-panel>" +
            "<div class=\"mdui-collapse-item commit\">" +
            "<div class=\"mdui-collapse-item-header\"></div>" +
            "<div class=\"mdui-collapse-item-body\">" +
            "<div class=\"mdui-divider\"></div>" +
            "<ul class=\"mdui-list mdui-list-dense\">" +
            "<!-- 用户评论部分 -->" +
            "<li class=\"mdui-list-item mdui-ripple mdui-p-l-1 send-card\">" +
            " <div class=\"mdui-list-item-avatar\"><img class=\"blog-avatar\" src=\"" + data.avatar + "\"/></div>" +
            "<div class=\"mdui-list-item-content\">" +
            "<input class=\"mdui-textfield-input\" type=\"text\" placeholder=\"发表评论\"/>" +
            "<div class=\"btn_list mdui-m-t-1\">" +
            "<div class=\"mdui-btn mdui-btn-dense mdui-color-red mdui-float-right mdui-ripple mdui-m-r-2 commit-send\">" +
            "<i class=\"mdui-icon material-icons\">check</i> 评论</div>" +
            "<div class=\"mdui-btn mdui-btn-dense mdui-color-red mdui-float-right mdui-ripple mdui-m-r-1 forward-send\">" +
            "<i class=\"mdui-icon material-icons\">format_quote</i> 转发并评论" +
            "</div></div></div></li>";
        if (parseInt(data.commentNum) != 0)
            res += "<li class=\"mdui-list-item mdui-ripple mdui-p-l-1 comment-load\"><div class=\"mdui-list-item-content mdui-center\">" +
                "<div class=\"mdui-spinner mdui-spinner-colorful\"></div></li>";
        res += "</ul></div></div></div></div></div>";
        $(".blogs").prepend(res);
    }*/

});
