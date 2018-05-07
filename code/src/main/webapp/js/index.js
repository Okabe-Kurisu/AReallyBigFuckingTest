$("document").ready(function (){
	mdui.mutation();
})
$(".mdui-fab").click(function smoothscroll(argument) {
	var currentScroll = document.documentElement.scrollTop || document.body.scrollTop;
	if (currentScroll > 0) {
		window.requestAnimationFrame(smoothscroll);
		window.scrollTo(0, currentScroll - (currentScroll / 5));
	}
})

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
	if(fImg.html() == "folder_open"){
		fImg.html("folder");
		mdui.snackbar("收藏成功");
	}else{
		fImg.html("folder_open");
		mdui.snackbar("取消收藏");
	}
	
})

$(".send").click(function send(argument) {
	mdui.snackbar("发送成功");
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

$(".commit-toggle").click(function commitToggle(argument){
	var commitPanel = $(this).parent().next();
	var inst = new mdui.Collapse(commitPanel, accordion = true);
	inst.toggle(".commit")
})

function addBlog(blog) {
}
function addCommit(Commit) {
}