$(function() {
	//全局变量

	//reason是生成博客列表的时候标注的理由
	var reason = ["是你发送的", "他很热门", "你关注了博主", "你关注了该话题", "包含了搜索词"]

	$("document").ready(function() {
		initPage();
		initBlog();
		initUser();
		initSearch();
		initPanel();
	})

	// 初始化页面类型
	function initPage(argument) {
		var request = GetRequest(); //取得url参数
		var method = request.method;
		// 如果是特殊类型的访问
		if (typeof(method) != "undefined") {
			if (method == "userinfo") {
				//用户页面
				var uid = request.uid;
				setUsercard(uid);
				setFanCard(uid);

				var meid = 0;
				if (typeof(sessionStorage.me) != "undefined") {
					var me = JSON.parse(sessionStorage.me);
					meid = me.uid
				}
				//如果这不是用户的主页，则显示关注按钮
				if (uid == meid) {
					$(".usercard-action").hide()
				}

			}
			if (method == "search") {
				// 搜索页面
				var keyword = request.keyword
			}
			if (method == "callat") {
				// at人页面
			}
		} else {
			// 主页
			$(".userinfo").hide()
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

	// 得到一堆博客，并存储起来
	function initBlog(argument) {
		getBlog();

		// 得到博客并存储到websql中
		function getBlog() {
			params = {
				time: Math.round(new Date().getTime() / 1000),
			}
			$.ajax({
				url: "/blog/selectBlogByTime",
				type: "POST",
				data: params,
				contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
				dataType: "json",
				success: function(data) {
					console.log("加载博客数据")
					if (data.code == 200 && data.data != null) {
						var blogs = data.data
						var db = openDatabase('weibo', '1.0', 'Test DB', 2 * 1024 * 1024)
						db.transaction(function(tx) {
							tx.executeSql('CREATE TABLE IF NOT EXISTS blog (bid unique, userid, content, multimedia, type, release_time, is_edit, commentNum, likeNum)');
							console.log("执行sql")
							for (x in blogs) {
								var blog = blogs[x];
								tx.executeSql('INSERT INTO blog (bid, userid, content, multimedia, type, release_time, is_edit, commentNum, likeNum) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)', [blog.bid, blog.user_id, blog.content, blog.multimedia, blog.type, blog.release_time, blog.is_edit, blog.commentNum, blog.likeNum]);
							}
						})
					}
					console.log("博客数据加载完成")
					//todo: 获得用户的关注信息
				},
				error: function() {
					mdui.snackbar("注册失败");
				},
			})
		};
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

			mdui.mutation();
		} else { //已登录
			var me = JSON.parse(sessionStorage.me);
			$(".login-btn").hide();
			$(".userpanel-avatar").attr("src", me.avatar);
			$(".userpanel-nickname").html(me.nickname);
			$(".userpanel-motto").html(me.motto);
			mdui.mutation();
		}
	}

	//得到热搜列表，点击热搜词填充，以及进行搜索
	function initSearch(argument) {
		//初始化热搜框
		$(".search-bar").on("click", function(argument) {
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
		})

		//todo: 等到微博生成写完后再写搜索
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
				setTimeout("self.location= '/'", 3000);
			},
			error: function() {
				mdui.snackbar("退出失败");
			},
		})
	})

	$(".back-up").on("click", smoothscroll);

	$(".thumb_up").click(function thumb_up(argument) {
		$(this).toggleClass("mdui-text-color-theme");
		$(this).toggleClass("mdui-text-color-pink");
	})

	$(".commit-send").click(function commit(argument) {
		mdui.snackbar("评论成功");
	})


	$(".forward-send").click(function forwardSend(argument) {
		mdui.snackbar("转发成功");
	})

	$(".favorite").click(function favorite(argument) {
		var fImg = $(this).children("i");
		if (fImg.html() == "folder_open") {
			fImg.html("folder");
			mdui.snackbar("收藏成功");
		} else {
			fImg.html("folder_open");
			mdui.snackbar("取消收藏");
		}

	})

	// 发布微博数据
	$(".send").click(function(argument) {
		param = {
			content: $("#blog-content").val(),
			multimedia: sessionStorage.img
		}
		$.ajax({
			url: "/blog/submitBlog",
			data: param,
			type: "POST",
			contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
			dataType: "json",
			success: function(data) {
				var rtn = data.data;
				var user = rtn.user;
				var blog = rtn.blog;
				console.log("正在发布微博...")

				insertBlog(user, blog, reason[0]);
				$("#blog-content").val("")
				mdui.snackbar("发送成功");
				console.log("发布成功(●ˇ∀ˇ●)")
				//todo: 获得用户的关注信息
			},
			error: function() {
				mdui.snackbar("微博发送失败");
			},
		})

	})

	function insertBlog(user, blog, reason) {
		var res = "<div class=\"mdui-card mdui-m-t-1 blog-card\" bid=" + blog.bid + ">\n" +
			"                <p class=\"mdui-typo-caption mdui-text-color-pink-400 mdui-m-a-1 weibo-reason\">这条微博出现在这里，因为" + reason + "</p>\n" +
			"                <div class=\"mdui-card-header\">\n" +
			"                    <img class=\"mdui-card-header-avatar\" src=\"" + user.avatar + "\"/>\n" +
			"                    <div class=\"mdui-card-header-title\">" + user.username + "</div>\n" +
			"                    <div class=\"mdui-card-header-subtitle\">" + user.motto + "</div>\n" +
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
			res += "                <div class=\"mdui-card-content\">" + param.content + "</div>\n"
		}

		res += "                <div class=\"mdui-card-actions\">\n" +
			"                    <button class=\"mdui-btn mdui-btn-dense mdui-ripple mdui-text-color-theme thumb_up\"><i\n" +
			"                            class=\"mdui-icon material-icons\">thumb_up</i>赞(" + blog.likeNum +  ")\n" +
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
			"            </div>"
		$(".send-card").after(res)
	}

	$(".callat").on("click", function callat(argument) {
		var cDialog = $(".callat-dialog");
		var inst = new mdui.Dialog(cDialog, overlay = true);
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


	$(".report").click(function report(argument) {
		var inst = new mdui.Dialog(".report-dialog", overlay = true);
		inst.open();
		$(".report-cancel").click(function reportCancel(argument) {
			inst.close();
		})
		$(".report-send").click(function reportSend(argument) {
			inst.close();
		})
	})

	$(".commit-toggle").click(function commitToggle(argument) {
		var commitPanel = $(this).parent().next();
		closePanel();
		var inst = new mdui.Collapse(commitPanel, accordion = true);
		inst.toggle(".commit")
	})

	function closePanel() { //用来收起多出来的框框
		var Panel = $('.mdui-collapse-item-open');
		var inst = new mdui.Collapse(Panel.parent(), accordion = true);
		inst.closeAll();
	}


	function addBlog(blog) {}

	function addCommit(Commit) {}

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

	// 如果没登录，就让用户登陆
	function gotoLogin(argument) {
		mdui.snackbar("请登录");
		setTimeout("self.location= '/auth.html'", 1000);
	}

	//滚动会最上方
	function smoothscroll(argument) {
		var currentScroll = document.documentElement.scrollTop || document.body.scrollTop;
		if (currentScroll > 0) {
			window.requestAnimationFrame(smoothscroll);
			window.scrollTo(0, currentScroll - (currentScroll / 5));
		}
	}

	// 下面是上传文件代码

	$('.insert-img').click(function() {
		inst = upload()
		var box = document.getElementById("image-zone");
		/*由于浏览器默认的对拖拽进的文件是打开或提示打开或保存
		所以在投放区域使用preventDefault()阻止该事件，但投放区外还是默认事件
		并且阻止默认事件的代码要放到第一行，即首先阻止默认行为*/
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
			/**e.dataTransfer.files可以获取所投放的文件数组的信息
			 也就是说可以一次性拖入多个文件，该数组每个元素代表每个文件的详细信息*/
			var files = e.dataTransfer.files;
			//alert(files.length);  //获取拖入文件的个数
			//获取投放的第一个文件的名称，size获取大小，type获取文件类型，...
			//alert(files[0].name);
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
						inst.toggle();
					}
				}
			});
		};
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
})