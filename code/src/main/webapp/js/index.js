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
	var method = request["method"];
	// 如果是特殊类型的访问
	if (typeof(method) ！= "undefined") {
		if (method == "index") {
			// 主页

		}
		if (method == "userinfo") {
			//他人用户页面
		}
		if (method == "search") {
			// 搜索页面
		}
		if (method == "callat") {
			// at人页面
		}
	}
	console.log(request)
}

// 得到一堆博客，并存储起来
function initBlog(argument) {
	// body...
}

// 得到用户信息
function initUser(argument) {
	//初始化用户信息弹框
	$(".me").on("click", function(argument) {
		var userPanel = $(".userinfo");
		closePanel();
		var inst = new mdui.Collapse(userPanel, accordion = true);
		inst.toggle("#userinfo");
	})
	// 得到用户信息
	if (sessionStorage.me == "null" || typeof(sessionStorage.me) == "undefined") { //已登录
		$(".userinfo").hide();
		$(".me").hide();
		mdui.mutation();
	} else { //检测到未登录
		var me = JSON.parse(sessionStorage.me);
		$(".login-btn").hide();
		$(".send").hide();
		$(".userinfo-avatar").attr("src", me.avatar);
		$(".userinfo-nickname").html(me.nickname);
		$(".userinfo-motto").html(me.motto);
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
			sessionStorage.me = null;
			setTimeout("self.location= '/'", 3000);
		},
		error: function() {
			mdui.snackbar("退出失败");
		},
	})
})

$(".back-up").on("click", smoothscroll);

function smoothscroll(argument) {
	var currentScroll = document.documentElement.scrollTop || document.body.scrollTop;
	if (currentScroll > 0) {
		window.requestAnimationFrame(smoothscroll);
		window.scrollTo(0, currentScroll - (currentScroll / 5));
	}
}
$(".thumb_up").click(function thumb_up(argument) {
	$(this).toggleClass("mdui-text-color-theme");
	$(this).toggleClass("mdui-text-color-pink");
})

$(".commit-send").click(function commit(argument) {
	mdui.snackbar("评论成功");
})

$(".insert-img").on("click", function insertImg(argument) {
	var iDialog = $(".image-dialog");
	var inst = new mdui.Dialog(iDialog, overlay = true);
	inst.open();
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

$(".send").click(function send(argument) {
	mdui.snackbar("发送成功");
})

$(".callat").on("click", function callat(argument) {
	var cDialog = $(".callat-dialog");
	var inst = new mdui.Dialog(cDialog, overlay = true);
	inst.open();
})

$(".discuss").on("click", function discuss(argument) {
	var dDialog = $(".discuss-dialog");
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