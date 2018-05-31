$(function () {
    //全局变量
    var createDialog_inst;
    var changeDiscuss_inst;
    // 判断是话题中心还是我的话题（0：话题中心，1：我的话题）
    var discuss_page = 0;

    $("document").ready(function () {
        // 初始化操作
        intiDiscuss();

        initHotDiscuss();

        //初始化分页器
        initPagination()

    });

    //绑定事件

    //话题中心绑定事件
    $(".discuss-center").click(function () {
        $(".pagination-bar").show()
        discuss_page = 0;
        getAllDiscuss();
    });

    //我的话题绑定事件
    $(".my-discuss").click(function () {
        $(".pagination-bar").hide()
        discuss_page = 1;
        getUserDiscuss();
    });

    //创建话题绑定事件
    $(".create-discuss").click(function () {
        var dDialog = $(".addDiscuss-dialog");
        createDialog_inst = new mdui.Dialog(dDialog, overlay = true);
        createDialog_inst.open();
        // 初始化时间框件
        laydate.render({
            elem: '#discuss-startTime'
            , type: 'datetime'
        });
    });

    // 提交话题按钮点击事件（创建话题）
    $(".submit-discussion").click(function () {
        var discuss_name = $(".discuss-name").val();
        var discuss_description = $(".discuss-description").val();
        var date_str = $("#discuss-startTime").val()

        if (discuss_name === "" || discuss_description === "" || date_str === "") {
            mdui.snackbar("数据不能为空");
            return;
        }
        var date = new Date(date_str)
        var time = date.getTime() / 1000;
        param = {
            "discuss.name": discuss_name,
            "discuss.detail": discuss_description,
            "discuss.start_time": time
        }
        $.ajax({
            url: "/discuss/submitDiscuss",
            //async: false,
            type: "POST",
            data: param,
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
            dataType: "json",
            success: function (data) {
                console.log(data)
                console.log("正在添加话题...");
                if (data.code == 200) {
                    mdui.snackbar("话题添加成功");
                    createDialog_inst.close()
                } else {
                    mdui.snackbar("话题添加失败");
                }
            },
            error: function () {
                mdui.snackbar("话题添加失败");
            },
        })
    });

    // 结束话题点击事件
    $(".discuss-list").on("click", ".end-discuss", function (event) {
        event.stopPropagation();
        var did = $(this).attr("did");
        // 含文本、标题确认按钮和取消按钮回调
        mdui.confirm('您确认结束话题吗', '结束话题',
            function () {
                var time = Date.parse(new Date()) / 1000;
                param = {
                    "discuss.did": did,
                    "discuss.visibility": 1,
                    "discuss.end_time": time
                }
                $.ajax({
                    url: "/discuss/updateDiscuss",
                    type: "POST",
                    data: param,
                    contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                    dataType: "json",
                    success: function (data) {
                        if (data.code == 200) {
                            mdui.alert('话题结束成功');
                        } else {
                            mdui.snackbar("话题结束失败");
                        }
                    },
                    error: function () {
                        mdui.snackbar("请求错误");
                    },
                });

            },
            function () {

            },
            options = {
                confirmText: "确认",
                cancelText: "取消"
            }
        );
    });

    // 修改话题点击事件(显示修改话题dialog)
    $(".discuss-list").on("click", ".change-discuss", function (event) {
        event.stopPropagation();
        // 显示dialog
        var dDialog = $(".changeDiscuss-dialog");
        changeDiscuss_inst = new mdui.Dialog(dDialog, overlay = true);
        changeDiscuss_inst.open();

        // 填充文本框
        var name = $(this).parent().parent().find(".mdui-card-primary-title").text()
        var des = $(this).parent().parent().find(".mdui-card-primary-subtitle").text()
        $(".cdiscuss-name").val(name);
        $(".cdiscuss-description").val(des);

        // 传递话题id
        var did = $(this).attr("did");
        $(".change-confirm").attr("did", did)
    });

    // 修改话题提交按钮点击实现（修改话题）
    $(".change-confirm").click(function () {
        var name = $(".cdiscuss-name").val();
        var des = $(".cdiscuss-description").val();
        var did = $(this).attr("did");
        param = {
            "discuss.did": did,
            "discuss.name": name,
            "discuss.detail": des
        };
        $.ajax({
            url: "/discuss/updateDiscuss",
            type: "POST",
            data: param,
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
            dataType: "json",
            success: function (data) {
                if (data.code == 200) {
                    changeDiscuss_inst.close()
                    mdui.alert('话题修改成功');
                } else {
                    mdui.snackbar("话题修改失败");
                }
            },
            error: function () {
                mdui.snackbar("请求错误");
            },
        });
    });

    //话题卡片点击事件
    $(".discuss-list").on("click", ".mdui-col", function () {
        var did = $(this).attr("did");
        var dname = $(this).attr("dname")
        sessionStorage.setItem('blog_did', did);
        sessionStorage.setItem('blog_dis_title', dname);
        window.location.href = "/discuss_blog.html";
    });

    // 话题搜索
    $(".discuss-search").keyup('keyup', function (event) {
        console.log(discuss_page)
        var key = $(".discuss-search").val();
        param = {
            discuss_page: discuss_page,
            key: key
        };
        $.ajax({
            url: "/discuss/searchDiscuss",
            type: "POST",
            data: param,
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
            dataType: "json",
            success: function (data) {
                if (data.code == 200 && data.data != null) {
                    $(".discuss-list").text("");
                    var discusses = data.data;
                    for (x in discusses) {
                        var discuss = discusses[x]
                        if (discuss_page === 0) {
                            var res = format_discuss_centerHtml(discuss);
                        }
                        else if (discuss.is_edit >= 4) {
                            var res = "<div class=\"mdui-col\" did=\"" + discuss.did + "\" dname=\"" + discuss.name + "\">\n" +
                                "                    <div class=\"mdui-grid-tile\">\n" +
                                "                        <div class=\"mdui-card\">\n" +
                                "                            <div class=\"mdui-card-media\">\n" +
                                "                                <img src=\"img/sign_bg.jpg\"/>\n" +
                                "                                <div class=\"mdui-card-media-covered\">\n" +
                                "                                    <div class=\"mdui-card-primary\">\n" +
                                "                                        <div class=\"mdui-card-primary-title\">" + discuss.name + "</div>\n" +
                                "                                        <div class=\"mdui-card-primary-subtitle\">" + discuss.detail + "</div>\n" +
                                "                                    </div>\n" +
                                "                                    <div class=\"mdui-card-actions\">\n" +
                                "                                        <button class=\"mdui-btn mdui-ripple mdui-ripple-white end-discuss\" did=\"" + discuss.did + "\">结束话题</button>\n" +
                                "                                        <button class=\"mdui-btn mdui-ripple mdui-ripple-white mdui-btn-raised change-discuss\" did=\"" + discuss.did + "\" disabled>禁止修改</button>\n" +
                                "                                        <button class=\"mdui-btn mdui-ripple mdui-ripple-white followDiscuss\" did=\"" + discuss.did + "\">关注</button>\n" +
                                "                                    </div>\n" +
                                "                                </div>\n" +
                                "                            </div>\n" +
                                "                        </div>\n" +
                                "                    </div>\n" +
                                "                </div>"
                        }
                        else {
                            var res = "<div class=\"mdui-col\" did=\"" + discuss.did + "\" dname=\"" + discuss.name + "\">\n" +
                                "                    <div class=\"mdui-grid-tile\">\n" +
                                "                        <div class=\"mdui-card\">\n" +
                                "                            <div class=\"mdui-card-media\">\n" +
                                "                                <img src=\"img/sign_bg.jpg\"/>\n" +
                                "                                <div class=\"mdui-card-media-covered\">\n" +
                                "                                    <div class=\"mdui-card-primary\">\n" +
                                "                                        <div class=\"mdui-card-primary-title\">" + discuss.name + "</div>\n" +
                                "                                        <div class=\"mdui-card-primary-subtitle\">" + discuss.detail + "</div>\n" +
                                "                                    </div>\n" +
                                "                                    <div class=\"mdui-card-actions\">\n" +
                                "                                        <button class=\"mdui-btn mdui-ripple mdui-ripple-white end-discuss\" did=\"" + discuss.did + "\">结束话题</button>\n" +
                                "                                        <button class=\"mdui-btn mdui-ripple mdui-ripple-white change-discuss\" did=\"" + discuss.did + "\">修改话题</button>\n" +
                                "                                    </div>\n" +
                                "                                </div>\n" +
                                "                            </div>\n" +
                                "                        </div>\n" +
                                "                    </div>\n" +
                                "                </div>"
                        }

                        $(".discuss-list").append(res);
                    }

                } else {
                    mdui.snackbar("话题获取失败");
                }
            },
            error: function () {
                mdui.snackbar("请求错误");
            },
        });
    });

    //关注话题事件
    $(".discuss-list").on("click", ".followDiscuss", function (event) {
        var did = $(this).attr("did");
        param = {
            did: did
        }
        event.stopPropagation();
        $.ajax({
            url: "/discuss/followDiscussion",
            type: "POST",
            data: param,
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
            dataType: "json",
            success: function (data) {
                if (data.code == 200 && data.data == 1) {
                    mdui.snackbar("关注成功");
                } else {
                    mdui.snackbar("关注错误");
                }
            },
            error: function () {
                mdui.snackbar("请求错误");
            },
        });
    })

    // function
    var intiDiscuss = function () {
        getAllDiscuss(1, 10)
    };

    // 获得全部话题
    var getAllDiscuss = function (page, pageCap) {
        param = {
            page: page,
            pageCap: pageCap
        }
        $.ajax({
            url: "/discuss/searchDiscuss",
            type: "POST",
            data: param,
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
            dataType: "json",
            success: function (data) {
                if (data.code == 200 && data.data != null) {
                    $(".discuss-list").text("");
                    var discusses = data.data;
                    for (x in discusses) {
                        var discuss = discusses[x]
                        var res = format_discuss_centerHtml(discuss);

                        $(".discuss-list").append(res);
                    }

                } else {
                    mdui.snackbar("话题获取失败");
                }
            },
            error: function () {
                mdui.snackbar("请求错误");
            },
        });
    };

    // 获得当前登陆用户的话题
    var getUserDiscuss = function () {
        param = {
            discuss_page: discuss_page
        }
        $.ajax({
            url: "/discuss/searchDiscuss",
            type: "POST",
            data: param,
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
            dataType: "json",
            success: function (data) {
                if (data.code == 200 && data.data != null) {
                    $(".discuss-list").text("");
                    var discusses = data.data;
                    for (x in discusses) {
                        var discuss = discusses[x]
                        if (discuss.is_edit >= 4) {
                            var res = "<div class=\"mdui-col\" did=\"" + discuss.did + "\" dname=\"" + discuss.name + "\">\n" +
                                "                    <div class=\"mdui-grid-tile\">\n" +
                                "                        <div class=\"mdui-card\">\n" +
                                "                            <div class=\"mdui-card-media\">\n" +
                                "                                <img src=\"img/sign_bg.jpg\"/>\n" +
                                "                                <div class=\"mdui-card-media-covered\">\n" +
                                "                                    <div class=\"mdui-card-primary\">\n" +
                                "                                        <div class=\"mdui-card-primary-title\">" + discuss.name + "</div>\n" +
                                "                                        <div class=\"mdui-card-primary-subtitle\">" + discuss.detail + "</div>\n" +
                                "                                    </div>\n" +
                                "                                    <div class=\"mdui-card-actions\">\n" +
                                "                                        <button class=\"mdui-btn mdui-ripple mdui-ripple-white end-discuss\" did=\"" + discuss.did + "\">结束话题</button>\n" +
                                "                                        <button class=\"mdui-btn mdui-ripple mdui-ripple-white mdui-btn-raised change-discuss\" did=\"" + discuss.did + "\" disabled>禁止修改</button>\n" +
                                "                                    </div>\n" +
                                "                                </div>\n" +
                                "                            </div>\n" +
                                "                        </div>\n" +
                                "                    </div>\n" +
                                "                </div>"
                        }
                        else {
                            var res = "<div class=\"mdui-col\" did=\"" + discuss.did + "\" dname=\"" + discuss.name + "\">\n" +
                                "                    <div class=\"mdui-grid-tile\">\n" +
                                "                        <div class=\"mdui-card\">\n" +
                                "                            <div class=\"mdui-card-media\">\n" +
                                "                                <img src=\"img/sign_bg.jpg\"/>\n" +
                                "                                <div class=\"mdui-card-media-covered\">\n" +
                                "                                    <div class=\"mdui-card-primary\">\n" +
                                "                                        <div class=\"mdui-card-primary-title\">" + discuss.name + "</div>\n" +
                                "                                        <div class=\"mdui-card-primary-subtitle\">" + discuss.detail + "</div>\n" +
                                "                                    </div>\n" +
                                "                                    <div class=\"mdui-card-actions\">\n" +
                                "                                        <button class=\"mdui-btn mdui-ripple mdui-ripple-white end-discuss\" did=\"" + discuss.did + "\">结束话题</button>\n" +
                                "                                        <button class=\"mdui-btn mdui-ripple mdui-ripple-white change-discuss\" did=\"" + discuss.did + "\">修改话题</button>\n" +
                                "                                    </div>\n" +
                                "                                </div>\n" +
                                "                            </div>\n" +
                                "                        </div>\n" +
                                "                    </div>\n" +
                                "                </div>"
                        }

                        $(".discuss-list").append(res);
                    }

                } else {
                    mdui.snackbar("请先登陆");
                }
            },
            error: function () {
                mdui.snackbar("请求错误");
            },
        });
    };

    // 获得热门话题
    var initHotDiscuss = function () {
        $.ajax({
            url: "/discuss/selectHotDiscuss",
            type: "POST",
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
            dataType: "json",
            success: function (data) {
                if (data.code == 200 && data.data != null) {
                    $(".hot-discuss").text("");
                    var discusses = data.data;
                    for (x in discusses) {
                        var discuss = discusses[x];

                        var res = "<li class=\"mdui-list-item mdui-ripple mdui-p-l-1 hotspot-list\">\n" +
                            "                            <p class=\"mdui-list-item-icon mdui-text-color-red\"><i class=\"mdui-icon material-icons\">brightness_5</i></p>\n" +
                            "                            <div class=\"mdui-list-item-content\">" + discuss.name + "</div>\n" +
                            "                        </li>";

                        $(".hot-discuss").append(res);
                    }

                } else {
                    mdui.snackbar("话题获取失败");
                }
            },
            error: function () {
                mdui.snackbar("请求错误");
            },
        });
    }

    var format_discuss_centerHtml = function (discuss) {
        var res = "<div class=\"mdui-col\" did=\"" + discuss.did + "\" dname=\"" + discuss.name + "\">\n" +
            "                    <div class=\"mdui-grid-tile\">\n" +
            "                        <div class=\"mdui-card\">\n" +
            "                            <div class=\"mdui-card-media\">\n" +
            "                                <img src=\"img/sign_bg.jpg\"/>\n" +
            "                                <div class=\"mdui-card-media-covered\">\n" +
            "                                    <div class=\"mdui-card-primary\">\n" +
            "                                        <div class=\"mdui-card-primary-title\">" + discuss.name + "</div>\n" +
            "                                        <div class=\"mdui-card-primary-subtitle\">" + discuss.detail + "</div>\n" +
            "                                    </div>\n" +
            "                                    <div class=\"mdui-card-actions\">\n";

        if (discuss.followNum == 0) {
            res += "<button class=\"mdui-btn mdui-ripple mdui-ripple-white followDiscuss\" did=\"" + discuss.did + "\">关注</button>\n"
        } else {
            res += "<button class=\"mdui-btn mdui-ripple mdui-ripple-white\" did=\"" + discuss.did + "\" disabled>已关注</button>\n"
        }
        res += "                                    </div>\n" +
            "                                </div>\n" +
            "                            </div>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                </div>";

        return res;
    }

    var initPagination = function () {
        if (discuss_page == 0) {

            var num = 0;
            parm = {
                flag: discuss_page
            };
            $.ajax({
                url: "/discuss/selectDisCount",
                type: "GET",
                data: parm,
                async: false,
                contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                dataType: "json",
                success: function (data) {
                    if (data.code == 200 && data.data != null) {
                        num = data.data.num;
                        var num_y = num % 10;
                        num = num / 10;
                        if (num_y != 0) num += 1;
                    }
                }
            });
            $('.pagination-bar').pagination({
                pageCount: num,
                jump: true,
                callback: function (api) {
                    getAllDiscuss(api.getCurrent(), 10)
                }
            });
        }
        /*else {
            var num = 0;
            parm = {
                flag: discuss_page
            };
            $.ajax({
                url: "/discuss/selectDisCount",
                type: "GET",
                data: parm,
                async: false,
                contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                dataType: "json",
                success: function (data) {
                    if (data.code == 200 && data.data != null) {
                        num = data.data.num;
                        var num_y = num % 10;
                        num = num / 10;
                        if (num_y != 0) num += 1;
                    }
                }
            });
            $('.pagination-bar').pagination({
                pageCount: num,
                jump: true,
                callback: function (api) {
                    getUserDiscuss(api.getCurrent(), 10)
                }
            });
        }*/

    }
});
