$(function() {
    //全局变量
    //主数据库,主要存放关注表，at表，收藏表以及主页的微博信息存储
    var weiboDB = openDatabase('weibo', '1.0', '主表', 2 * 1024 * 1024);
    //临时数据库，存储临时微博，每次页面打开先删除全部表，然后向里面填充数值
    var tempDB = openDatabase('temp', '1.0', '临时表', 2 * 1024 * 1024);
    //全局变量
    var ataDialog_inst; //@dialog对话框
    var myDialog_inst //我的话题对话框
    var createDialog_inst //创建话题对话框

    $("document").ready(function() {
        initUser();
        initSearch();
        initPanel();
        initPage();
    })

    // 初始化页面类型
    function initPage(argument) {
        var request = GetRequest(); //取得url参数
        var method = request.method;
        //清空临时数据
        tempDB.transaction(function(tx) {
            tx.executeSql('DROP TABLE IF EXISTS blog');
            console.log("清空全部临时数据")
        })

        //清空测试数据
        weiboDB.transaction(function(tx) {
            tx.executeSql('DROP TABLE IF EXISTS blog');
            console.log("测试时每次打开网页会清空数据，测试完后记得删")
        })
        //用户标签初始化标记为0
        sessionStorage.tag = 0;
        //不应该显示的标签
        $(".userinfo").hide();
        $(".index").hide();
        $(".send-card").hide();
        // 如果是特殊类型的访问
        if (typeof(method) == "undefined") {
            // 主页
            $(".index").show();
            if (typeof(sessionStorage.uid) != "undefined") {
                $(".send-card").show();
            }
            params = {
                time: Math.round(new Date().getTime() / 1000),
            }
            var db = weiboDB;
            // 取到微博
            //获取热门微博，关注用户微博，关注话题微博
            getBlog(0, params, db);
            getBlog(4, params, db);
            if (typeof(sessionStorage.uid) != "undefined") {
                params.userid = sessionStorage.uid
                getBlog(5, params, db);
            }



            readBlog(db);
            //todo 加载太长了，写一个加载动画

        } else {
            if (method == "userinfo") {
                //用户页面
                var uid = request.uid;
                params = {
                    uid: uid
                };

                var db = tempDB;
                getBlog(1, params, db);
                readBlog(db);

                setUsercard(uid);
                setFanCard(uid);
                $(".userinfo").show();
                var meid = 0;
                if (typeof(sessionStorage.uid) != "undefined") {
                    meid = sessionStorage.uid
                }
                //如果这不是用户的主页，则显示关注按钮
                if (uid == meid) {
                    $(".usercard-action").hide()
                }

            }
            if (method == "search") {
                // 搜索页面
                $(".index").show();
                params = {
                    keyword: sessionStorage.keyword,
                    uid: 0,
                };
                if (typeof(sessionStorage.uid) != "undefined") {
                    meid = sessionStorage.uid
                }

                var db = tempDB;
                getBlog(2, params, db);
                readBlog(db);
            }
            if (method == "callat") {
                // at人页面
            }
        }

        function setUsercard(id) {
            params = {
                uid: id
            }
            var userinfo = null;
            $.ajax({
                url: "/user/getUserByUid",
                type: "POST",
                data: params,
                contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                dataType: "json",
                success: function(data) {
                    if (data.code == 200 && data.data != null) {
                        userinfo = data.data
                        $(".usercard-background").attr("src", userinfo.background);
                        $(".usercard-avatar").attr("src", userinfo.avatar);
                        $(".usercard-follerNum").html(userinfo.follerNum);
                        $(".usercard-folledNum").html(userinfo.folledNum);
                        $(".usercard-blogNum").html(userinfo.blogNum);
                    } else {
                        mdui.snackbar("当前用户不存在");
                        setTimeout("self.location= '/'", 1500);
                    }
                },
            })
        }

        function setFanCard(id) {
            params = {
                uid: id
            }
            var userinfo = null;
            $.ajax({
                url: "/user/getFanAvatarByUid",
                type: "POST",
                data: params,
                contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                dataType: "json",
                success: function(data) {
                    if (data.code == 200 && data.data != null) {
                        userinfo = data.data
                        for (x in userinfo) {
                            user = userinfo[x]
                            if (user.userid != id) {
                                text = '<a href="./?method=userinfo&uid=' + user.userid + '" class=" mdui-col"><img src="' + user.avatar + '" class="mdui-img-fluid"></a>'
                                var html = $(".usercard-folled").html()
                                $(".usercard-folled").html(html + text)
                            } else {
                                text = '<a href="./?method=userinfo&uid=' + user.fid + '" class=" mdui-col"><img src="' + user.avatar + '" class="mdui-img-fluid"></a>'
                                var html = $(".usercard-foller").html()
                                $(".usercard-foller").html(html + text)
                            }
                        }
                    }
                },
            })
        }
    }
    // 得到博客并存储到websql中
    function getBlog(type, params, db) {
        var urls = ["selectBlogByTime", "getUserBlog", "searchBlog", "callat", "getHotspot", "getFollowBlog", ]
        //reason是生成博客列表的时候标注的理由
        var reasons = ["没啥好显示的", "这是个人主页", "包含了搜索词", "包含了At信息", "他很热门", "你关注了该话题或博主"];
        var reason = reasons[type];
        //如果不是主页，数据存入临时表中
        $.ajax({
            url: "/blog/" + urls[type],
            type: "POST",
            async: false,
            data: params,
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
            dataType: "json",
            success: function(data) {
                console.log("加载博客数据")
                if (data.code == 200 && data.data != null) {
                    var blogs = data.data;
                    saveToSql(blogs, db, reason = reason);
                }
                console.log("博客数据加载完成");
            },
        })

    };


    // 将数据保存至数据库
    function saveToSql(data, db, reason) {
        db.transaction(function(tx) {
            tx.executeSql('CREATE TABLE IF NOT EXISTS blog (bid unique, userid, content, multimedia, type, releaseTime, isEdit, commentNum, likeNum, browserSign, commentOn, uid, avatar, nickname, motto, weight, isShow, reason)');
            for (x in data) {
                var temp = data[x];
                var bloginfo = [temp.bid, temp.bid, temp.bid, temp.bid, temp.user_id, temp.content, temp.multimedia, temp.type, temp.release_time, temp.is_edit, temp.commentNum, temp.likeNum, temp.browser_sign, temp.comment_on, temp.uid, temp.avatar, temp.nickname, temp.motto, temp.weight, reason];
                tx.executeSql('INSERT OR REPLACE INTO blog(bid, userid, content, multimedia, type, releaseTime, isEdit, commentNum, likeNum, browserSign, commentOn, uid, avatar, nickname, motto, weight, reason) VALUES(' +
                    '(SELECT CASE WHEN exists(SELECT ? FROM blog WHERE bid = ? ) THEN ? ELSE ? END' +
                    '), ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?, ? )', bloginfo);
            }
        })
    }

    //todo: 分页查询
    // 从数据库读取并生成微博
    function readBlog(db) {
        db.transaction(function(tx) { //这tm是异步方法
            tx.executeSql('SELECT * FROM blog order by releaseTime, weight DESC', [], function(tx, results) {
                console.log("开始生成博客html");
                var datas = results.rows;
                var len = datas.length;
                if (len != 0) {
                    for (x in datas) {
                        insertBlog(datas[x]);
                        tx.executeSql('UPDATE blog set isShow = 1 WHERE bid = ?', [datas[x].bid]);
                        if (x == (len - 1))
                            break;
                    }
                } else {
                    insertNone();
                }
                insertForword();
                initCard();
                mdui.mutation();
                console.log("生成博客html完成");
            }, null);
        })
    }

    function insertNone() {
        var res = "<div class=\"mdui-card mdui-color-red mdui-text-color-white mdui-m-t-5\">" +
            "<div class=\"mdui-card-content\">这里空空如也</div>" +
            "</div>";
        $(".blogs").html(res);
    }

    // 得到用户信息
    function initUser(argument) {
        //初始化用户信息弹框
        $(".me").on("click", function(argument) {
            var userPanel = $(".userpanel");
            closePanel();
            var inst = new mdui.Collapse(userPanel, accordion = true);
            inst.toggle("#userpanel");
        })
        // 得到用户信息
        if (typeof(sessionStorage.me) == "undefined") { //检测到未登录
            $(".userpanel").hide();
            $(".me").hide();
            $(".send-card").hide();
        } else { //已登录
            var me = JSON.parse(sessionStorage.me);
            sessionStorage.uid = me.uid;
            $(".login-btn").hide();
            $(".userpanel-avatar").attr("src", me.avatar);
            $(".userpanel-nickname").html(me.nickname);
            $(".userpanel-motto").html(me.motto);
            $(".userpanel-href").html("/?method=userinfo&uid=" + me.uid);
        }
    }

    //得到热搜列表，点击热搜词填充，以及进行搜索
    function initSearch(argument) {
        //初始化热搜框
        $(".search-input").on("focus", function(argument) {
            var hotspotPanel = $(".hotspot");
            closePanel();
            var inst = new mdui.Collapse(hotspotPanel, accordion = true);
            inst.toggle("#hotspot");
        })


        //得到热搜列表
        $.ajax({
            url: "/data/hotspot",
            type: "POST",
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
            dataType: "json",
            success: function(data) {
                if (data.code == 200) {
                    var hotspot = data.data;
                    sessionStorage.hotspot = hotspot;
                    $(".hotspot-list").each(function(argument) {
                        $(this).children('.mdui-list-item-content').html(hotspot[0]);
                        hotspot.shift();
                    })
                }
            },
        })

        //点击条目填充搜索栏
        $(".hotspot-list").click(function(argument) {
            $('.search-input').val($(this).children('.mdui-list-item-content').html())
            $('.search-input').focus();
        })

        $(".search-input").keypress(function(event) {
            var keynum = (event.keyCode ? event.keyCode : event.which);
            if (keynum == '13') {
                var url = "./?method=search";
                sessionStorage.keyword = $(".search-input").val();
                self.location = url;
            }
        });
    }


    function initPanel(argument) {
        //让panel弹出来能再收回去
        $(document).click(function(ev) {
            var openPanel = $(".mdui-collapse-item-open");
            if (openPanel.length != 0) {
                var ev = ev || window.event;
                var x = $(event.target);
                if (x.parents('.mdui-collapse-item-open').length == 0 && sessionStorage.panel == 1) {
                    var inst = new mdui.Collapse(openPanel.parent(), accordion = true);
                    inst.closeAll();
                    sessionStorage.panel = 0;
                } else {
                    sessionStorage.panel = 1
                }
            }
        })
    }

    $(".logout").click(function() {
        $.ajax({
            url: "/user/logout",
            type: "POST",
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
            dataType: "json",
            success: function(data) {
                mdui.snackbar("退出成功");
                sessionStorage.removeItem("me")
                weiboDB.transaction(function(tx) {
                    tx.executeSql('DROP TABLE IF EXISTS follow');
                    tx.executeSql('DROP TABLE IF EXISTS callat');
                    tx.executeSql('DROP TABLE IF EXISTS favarite');
                })
                console.log("用户信息清理完成")
                self.location = '/';
            },
            error: function() {
                mdui.snackbar("退出失败");
            },
        })
    })

    $(".back-up").on("click", smoothscroll);

    //召唤用户数据统计
    $(".usertag-btn").on("click", function(argument) {
        var me = JSON.parse(sessionStorage.me)
        var keywords = eval(me.keyword);
        if (keywords.length == 0) {
            mdui.snackbar("还没有任何标签信息，请多使用本网站或者等一会再来", timeout = 1500)
            return;
        }
        for (keyword in keywords) {
            $("#tagsList").append("<a>" + keywords[keyword] + "</a>")
        }
        if (sessionStorage.tag != 1) {
            initTag()
            sessionStorage.tag = 1
        }
        var dDialog = $(".usertag");
        var inst = new mdui.Dialog(dDialog, overlay = true);
        inst.open();
    })


    //滚动会最上方
    function smoothscroll(argument) {
        var currentScroll = document.documentElement.scrollTop || document.body.scrollTop;
        if (currentScroll > 0) {
            window.requestAnimationFrame(smoothscroll);
            window.scrollTo(0, currentScroll - (currentScroll / 5));
        }
    }

    //召唤用户数据统计
    $(".usertag-btn").on("click", function(argument) {
        var me = JSON.parse(sessionStorage.me)
        var keywords = eval(me.keyword);
        if (keywords.length == 0) {
            mdui.snackbar("还没有任何标签信息，请多使用本网站或者等一会再来", timeout = 1500)
            return;
        }
        for (keyword in keywords) {
            $("#tagsList").append("<a>" + keywords[keyword] + "</a>")
        }
        if (sessionStorage.tag != 1) {
            initTag()
            sessionStorage.tag = 1
        }
        var dDialog = $(".usertag");
        var inst = new mdui.Dialog(dDialog, overlay = true);
        inst.open();
    })


    // 如果没登录，就让用户登陆
    function gotoLogin(argument) {
        mdui.snackbar("请登录");
        setTimeout("self.location= '/auth.html'", 1000);
    }

    // @列表点击事件
    $(".friend-list").on("click", ".callat-item", function() {
        var uid = $(this).attr("userid")
        var username = $(this).attr("username");
        var v = $("#blog-content").val();
        $("#blog-content").val(v + " @" + username + " ");
        ataDialog_inst.close();
    })

    // #列表点击事件
    $(".discuss-list").on("click", ".callat-item", function() {
        var uid = $(this).attr("userid")
        var username = $(this).attr("username");

        //todo: 未添加到博客话题表

        var v = $("#blog-content").val();
        $("#blog-content").val(" #" + username + " "+v);
        ataDialog_inst.close();
    })

    // 发布微博数据
    $(".send").click(function(argument) {
        param = {
            content: $("#blog-content").val(),
            multimedia: ""
        }
        if (typeof(sessionStorage.img) != "undefined") {
            param.multimedia = sessionStorage.img;
            sessionStorage.removeItem("img");
        }
        if (typeof(sessionStorage.time) != "undefined") {
            param.release_time = sessionStorage.time;
        }
        $.ajax({
            url: "/blog/submitBlog",
            data: param,
            type: "POST",
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
            dataType: "json",
            success: function(data) {
                console.log("正在发布微博...")
                var rtn = data.data.data;
                rtn.releaseTime = rtn.release_time;
                rtn.browserSign = rtn.browser_sign;
                rtn.commentOn = rtn.comment_on;
                if (typeof(sessionStorage.time) == "undefined") {
                    insertBlog(rtn, reason = "是你发送的");
                    initCard();
                }else{
                    sessionStorage.removeItem("time");
                }
                mdui.snackbar("发送成功");
            },
            error: function() {
                mdui.snackbar("微博发送失败");
            },
        })
    })

    $(".setTime").click(function(argument) {
        var beDialog = $(".setTime-dialog");
        var inst = new mdui.Dialog(beDialog, overlay = true);
        inst.open();
        $("#ECalendar_date").ECalendar({
            type: "time", //模式，time: 带时间选择; date: 不带时间选择;
            stamp: false, //是否转成时间戳，默认true;
            format: "yyyy-mm-dd hh:ii", //时间格式 默认 yyyy-mm-dd hh:ii;
            skin: 3, //皮肤颜色，默认随机，可选值：0-8,或者直接标注颜色值;
            step: 10, //选择时间分钟的精确度;
            callback: function(v, e) {
                v += ":00"
                var stringTime = v;
                var timestamp2 = Date.parse(new Date(stringTime));
                timestamp2 = timestamp2 / 1000;
                sessionStorage.time = timestamp2;
                inst.close()

            }
        });
    })



    function insertBlog(data, reason) {
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
            "<a href=\"./?method=userinfo&uid=" + data.userid + "\"><img class=\"mdui-card-header-avatar\" src=\"" + data.avatar + "\"/></a>\n" +
            "<div class=\"mdui-card-header-title\">" + data.nickname + "</div>\n" +
            "<div class=\"mdui-card-header-subtitle\">" + data.motto + "</div>\n" +
            "<!-- 时间戳生成发博时间 -->\n" +
            "<div class=\"mdui-card-menu mdui-text-color-grey-500\">\n" +
            "<p>" + formatMsgTime(data.releaseTime) + "</p>\n" +
            "</div>\n" +
            "</div>\n";
        // 如果blog中包含图片
        if (data.multimedia != null) {
            res += "<div class=\"mdui-card-media\">\n" +
                "<img class=\"blog-media\" src=\"" + data.multimedia + "\"/>\n" +
                "</div>\n";
        }
        // 如果blog中包含转发内容
        if (data.type == 1) {
            res += "<div class=\"mdui-card-content\" content=\"" + data.content + "\">" + data.content + //转发博客的主体内容
                "<!-- 被转发微博在下面， 相当于是在本身微博的最后加上一个新的微博卡片 -->"
            //先显示正在加载，然后在每次生成微博后绑定上真正的转发内容加载方法,待加载bid获取方法为$(".waitload").attr("bid")
            "<div class=\"mdui-spinner mdui-spinner-colorful waitload\" bid=\"" + data.commentOn + "\"></div>"
            "</div>\n"
        } else {
            res += "<div class=\"mdui-card-content\" content=\"" + data.content + "\">" + data.content + "</div>\n"
        }
        res += "<div class=\"mdui-card-actions\">\n" +
            "<button class=\"mdui-btn mdui-btn-dense mdui-ripple mdui-text-color-theme thumb_up\" likeNum=\"" + data.likeNum + "\"><i\n" +
            "class=\"mdui-icon material-icons\">thumb_up</i>赞(" + data.likeNum + ")\n" +
            "</button>\n" +
            "<button class=\"mdui-btn mdui-btn-dense mdui-ripple mdui-text-color-theme commit-toggle\" commentNum=\"" + data.commentNum + "\"><i\n" +
            "class=\"mdui-icon material-icons\">forum</i>(" + data.commentNum + ")\n" +
            "</button>\n" +
            "<button class=\"mdui-btn mdui-btn-dense mdui-ripple mdui-text-color-theme favorite\"><i\n" +
            "class=\"mdui-icon material-icons\">folder</i>收藏\n" +
            "</button>\n" +
            "<button class=\"mdui-btn mdui-btn-dense mdui-float-right mdui-color-red report \"><i\n" +
            "class=\"mdui-icon material-icons\">flag</i>举报\n" +
            "</button><!-- todo: 如果是鹳狸猿改成封禁 -->\n" +
            "</div>\n" +
            "</div>"
        $(".blogs").after(res);
    }


    //开发者信息按钮的代码绑定。因为该内容会动态生成很多次，所以写成方法
    function initCard() {
        $(".dev-info-btn").off("click");
        $(".dev-info-btn").on("click", devInfoBtn);
        $(".thumb_up").off("click");
        $(".thumb_up").on("click", thumb_up);
        $(".commit-send").off("click");
        $(".commit-send").on("click", commit);
        $(".favorite").off("click");
        $(".favorite").on("click", favorite);
        $(".blog-del-btn").off("click");
        $(".blog-del-btn").on("click", blogDel);
        $(".blog-edit-btn").off("click");
        $(".blog-edit-btn").on("click", blogEdit);
        $(".blog-edit-btn").off("click");
        $(".blog-edit-btn").on("click", blogEdit);
        $(".commit-toggle").off("click");
        $(".commit-toggle").on("click", commitToggle);
        $(".report").off("click");
        $(".report").on("click", report);

        function report(argument) {
            var inst = new mdui.Dialog(".report-dialog", overlay = true);
            inst.open();

            $(".report-cancel").off("click");
            $(".report-cancel").on("click", reportCancel);

            function reportCancel(argument) {
                inst.close();
            }
            $(".report-send").off("click");
            $(".report-send").on("click", reportSend);

            function reportSend(argument) {
                var bid = $(this).parents().find(".blog-card").attr("bid");
                var type = $(this).parents(".report-dialog").find(".report-type").find("option:selected").text();
                var details = $(this).parents(".report-dialog").find("textarea").val();
                param = {
                    bid: bid,
                    type: type,
                    details: details
                }
                $.ajax({
                    url: "/blog/reportBlog",
                    type: "POST",
                    data: param,
                    contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                    dataType: "json",
                    success: function(data) {
                        mdui.snackbar(data.msg);

                    },
                    error: function(data) {
                        mdui.snackbar("举报失败");
                    }
                })
                inst.close();
            }
        }

        function commitToggle(argument) {
            var commitPanel = $(this).parent().next();
            closePanel();
            var inst = new mdui.Collapse(commitPanel, accordion = true);
            inst.toggle(".commit")
        }

        function blogDel(argument) {
            var thisCard = $(this).parents(".blog-card");
            var bid = thisCard.attr("bid");
            param = {
                bid: bid
            }
            $.ajax({
                url: "/blog/delBlog",
                type: "POST",
                data: param,
                contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                dataType: "json",
                success: function(data) {
                    mdui.snackbar("删除成功");
                    thisCard.hide();
                }
            })
        }

        function blogEdit(argument) {
            var thisCard = $(this).parents(".blog-card");
            var bid = thisCard.attr("bid");
            var content = thisCard.children(".mdui-card-content").attr("content");
            var img = "";
            $(".blog-edit-delimg").hide();
            if (thisCard.children(".blog-media").length > 0) {
                img = thisCard.children(".blog-media").attr("src");
                $(".blog-edit-delimg").show();
                $(".blog-edit-image").attr("src", img)
            }
            $(".blog-edit-input").val(content);
            $(".blog-edit-content").attr("bid", bid);
            var beDialog = $(".blog-edit-dialog");
            var inst = new mdui.Dialog(beDialog, overlay = true);
            inst.open();

            $(".blog-edit-delimg").off("click");
            $(".blog-edit-delimg").click(function(argument) {
                $(".blog-edit-image").attr("src", "");
                $("#edit-image").show();
            })

            $(".blog-edit-cancel").off("click");
            $(".blog-edit-cancel").click(function(argument) {
                $(".blog-edit-image").attr("src", "");
                $(".blog-edit-input").val();
                $(".blog-edit-content").attr("bid", "");
                inst.close();
            })

            $(".blog-edit-send").off("click");
            $(".blog-edit-send").click(function(argument) {
                params = {
                    bid: $(".blog-edit-content").attr("bid"),
                    multimedia: $(".blog-edit-image").attr("src"),
                    content: $(".blog-edit-input").val(),
                }
                if (params.content == "") {
                    mdui.snackbar("不可修改为空");
                    inst.close();
                    return;
                }
                if (typeof(sessionStorage.img != "undefined")) {
                    params.multimedia = sessionStorage.img
                }
                $.ajax({
                    url: "/blog/setBlog",
                    type: "POST",
                    data: params,
                    contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                    dataType: "json",
                    success: function(data) {
                        if (data.code == 200) {
                            mdui.snackbar("编辑成功");
                            setTimeout("location.reload()", "500");
                        }
                    }
                })
            })
        }

        function thumb_up(argument) { //点赞博客
            var bid = $(this).parents(".blog-card").attr("bid");
            param = {
                bid: bid
            }
            $.ajax({
                url: "/blog/thumbUp",
                type: "POST",
                data: param,
                contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                dataType: "json",
                success: function(data) {
                    var num = $(this).parents(".blog-card").val()
                    $(this).parents(".blog-card").val(num + 1)
                }
            })
            $(this).toggleClass("mdui-text-color-theme");
            $(this).toggleClass("mdui-text-color-pink");

        }

        function commit(argument) {
            var bid = $(this).parents(".blog-card").attr("bid");
            var content = $(this).parents(".mdui-list-item-content").find("input").val();
            param = {
                bid: bid,
                content: content
            }
            $.ajax({
                url: "/blog/commitBlog",
                type: "POST",
                data: param,
                contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                dataType: "json",
                success: function(data) {
                    mdui.snackbar(data.msg);
                },
                error: function(data) {
                    mdui.snackbar(data.msg);
                }
            })
        }

        function favorite(argument) {
            var fImg = $(this).children("i");
            if (fImg.html() == "folder_open") {
                fImg.html("folder");
                var bid = $(this).parents(".blog-card").attr("bid");
                param = {
                    bid: bid
                }
                $.ajax({
                    url: "/blog/collectBlog",
                    type: "POST",
                    data: param,
                    contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                    dataType: "json",
                    success: function(data) {
                        mdui.snackbar("收藏");
                        mdui.snackbar(data.msg);
                    }
                })
            } else {
                fImg.html("folder_open");
                var bid = $(this).parents(".blog-card").attr("bid");
                param = {
                    bid: bid
                }
                $.ajax({
                    url: "/blog/collectBlog",
                    type: "POST",
                    data: param,
                    contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                    dataType: "json",
                    success: function(data) {
                        mdui.snackbar("取消收藏");
                        mdui.snackbar(data.msg);

                    },
                    error: function(data) {
                        mdui.snackbar("取消收藏失败");
                    }
                })

            }
        }

        function devInfoBtn() {
            var devInfo = $(this).parent().prev();
            if (devInfo.css("display") == 'none') {
                devInfo.show(speed = "normal");
            } else {
                devInfo.hide(speed = "normal");
            }
        }
    }

    //生成所有被转发的微博
    function insertForword() {
        $(".waitload").each(function() {
            var id = $(this).attr("bid");
            var thisDiv = $(this)
            $.ajax({
                url: "/blog/getBlogById",
                data: {
                    bid: id
                },
                type: "POST",
                contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                dataType: "json",
                success: function(data) {
                    if (data.code = 200 && data.code != null) {
                        var rtn = data.data;
                        thisDiv.addClass("origin-blog");
                        thisDiv.removeClass("mdui-spinner");
                        thisDiv.removeClass("mdui-spinner-colorful");
                        thisDiv.removeClass("waitload");
                        var html = "<div class=\"mdui-card mdui-m-t-1\">" +
                            "<div class=\"mdui-card-header\">" +
                            "<a href=\"./?method=userinfo&uid=" + rtn.userid + "\"<img class=\"mdui-card-header-avatar\" src=\"" + rtn.avatar + "\"/>\n" +
                            "<div class=\"mdui-card-header-title\">" + rtn.username + "</div>\n" +
                            "<div class=\"mdui-card-header-subtitle\">" + rtn.motto + "</div>\n" +
                            "</div>" +
                            "<div class=\"mdui-card-content\">" + rtn.content + "</div>" +
                            "</div>";
                    }
                },
            })
        })
    }

    $(".callat").on("click", function callat(argument) {
        var cDialog = $(".callat-dialog");
        var inst = new mdui.Dialog(cDialog, overlay = true);
        inst.open();
    })

    $(".discuss").on("click", function discussat(argument) {
        var dDialog = $(".discuss-dialog");
        var inst = new mdui.Dialog(dDialog, overlay = true);
        inst.open();
    })

    // 我的话题按钮点击时间
    $(".myDiscuss").on("click", function showMyDiscuss(argument) {
        var dDialog = $(".manageDiscuss-dialog");
        var inst = new mdui.Dialog(dDialog, overlay = true);
        inst.open();
    })

    // 创建话题按钮点击事件
    $(".creatDiscuss").on("click", function showAddDiscuss(argument) {
        var dDialog = $(".addDiscuss-dialog");
        var inst = new mdui.Dialog(dDialog, overlay = true);
        inst.open();
    })

    $(".send-fab").on("click", function sendFab(argument) {
        smoothscroll();
        $("#blog-content").focus();
    })

    function closePanel() { //用来收起多出来的框框
        var Panel = $('.mdui-collapse-item-open');
        var inst = new mdui.Collapse(Panel.parent(), accordion = true);
        inst.closeAll();
    }

    // 下面是上传文件代码

    $('.insert-img').click(function() {
        inst = upload()
        var box = document.getElementById("image-zone");
        box.ondragenter = function(e) {
            e.preventDefault();
        };
        box.ondragover = function(e) {
            e.preventDefault();
            box.innerHTML = "松开鼠标开始上传";
        };
        box.ondragleave = function(e) {
            e.preventDefault();
            box.innerHTML = "拖拽到这里上传";
        };
        box.ondrop = function(e) {
            e.preventDefault();
            box.innerHTML = "上传中...";
            var files = e.dataTransfer.files;
            var file = files[0];
            var fd = new FormData();
            fd.append("upload", file);
            fd.append("type", "upload")
            $.ajax({
                url: '/fileUpload',
                type: "post",
                processData: false,
                contentType: false,
                data: fd,
                success: function(data) {
                    if (data.code == 200) {
                        mdui.snackbar("上传成功");
                        sessionStorage.img = data.data;
                        inst.close()
                    }
                }
            })
        }

    })

    //文件上传框呼出
    function upload(argument) {
        var iDialog = $(".upload-dialog");
        var inst = new mdui.Dialog(iDialog, overlay = true);
        inst.open();
        return inst;
    }

    function GetRequest() {
        var url = location.search; //获取url中"?"符后的字串
        var theRequest = new Object();
        if (url.indexOf("?") != -1) {
            var str = url.substr(1);
            strs = str.split("&");
            for (var i = 0; i < strs.length; i++) {
                theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
            }
        }
        return theRequest;
    }

    var box = document.getElementById("edit-image");
    box.ondragenter = function(e) {
        e.preventDefault();
    };
    box.ondragover = function(e) {
        e.preventDefault();
        box.innerHTML = "松开鼠标开始上传";
    };
    box.ondragleave = function(e) {
        e.preventDefault();
        box.innerHTML = "拖拽到这里上传";
    };
    box.ondrop = function(e) {
        e.preventDefault();
        box.innerHTML = "上传中...";
        var files = e.dataTransfer.files;
        var file = files[0];
        var fd = new FormData();
        fd.append("upload", file);
        fd.append("type", "upload")
        $.ajax({
            url: '/fileUpload',
            type: "post",
            processData: false,
            contentType: false,
            data: fd,
            success: function(data) {
                if (data.code == 200) {
                    mdui.snackbar("上传成功");
                    sessionStorage.img = data.data;
                    $(".blog-edit-image").attr("src", data.data);
                    $(".blog-edit-delimg").show();
                    $("#edit-image").hide();
                }
            }
        })
    }
})