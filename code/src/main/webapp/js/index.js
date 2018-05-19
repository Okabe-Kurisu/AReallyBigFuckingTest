$("document").ready(function() {
	mdui.mutation();
	initBlog();
	initUser();
})

// 得到一堆博客，并存储起来
function initBlog(argument) {
	// body...
}

// 得到用户信息
function initUser(argument) {
	// body...
	if (sessionStorage.me) {//已登录
		var me = sessionStorage.me
		$(".login-btn").hide();
		$(".userinfo-avatar").attr("src", me.avatar);
		$(".userinfo-nickname").attr("src", me.nickname);
		$(".userinfo-motto").attr("src", me.motto);		
	}else{//检测到未登录
		$(".userinfo").hide();
		$(".me").hide();
	}
}

$(".back-up").on("click",smoothscroll);
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

$(".insert-img").on("click",function insertImg(argument){
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
	var inst = new mdui.Collapse(commitPanel, accordion = true);
	inst.toggle(".commit")
})

$(".me").on("click", function me(argument) {
	var commitPanel = $(".userinfo");
	var inst = new mdui.Collapse(commitPanel, accordion = true);
	inst.toggle("#userinfo");
})

function addBlog(blog) {}

function addCommit(Commit) {}