$(function() {
	log = console.log
	delFlag = 0
	getAllChat()
	if (typeof(sessionStorage.uid) == "undefined")
		setTimeout(getAllChat, 500)

	$(".message-btn").click(function(argument) { //点击私信按钮
		$(".demo").css("z-index", 1)
		html = '<div class="contact" uid="' + sessionStorage.userid + '">' +
			'<img src="' + $(".user-cover-avatar").attr("src") + '" alt="" class="contact__photo" />' +
			'<span class="contact__name">' + $(".userinfo").attr("nickname") + '</span>' +
			'<span class="delete-chat">x</span></div>';
		$(".sidebar-content").prepend(html);
		animatePathD($path, finalD, animTime, false, function() {
			$sCont.addClass("active");
			setTimeout(function() {
				$(document).on("click", closeSidebar);
			}, sContTrans);
			$('.contact').first().trigger('click');

		});
	})

	function getAllChat() {
		//得到全部聊天信息
		if (typeof(sessionStorage.uid) == "undefined") return;
		params = {
			uid: sessionStorage.uid
		};
		$.ajax({
			url: "/message/getSendMessageUserId",
			type: "POST",
			data: params,
			contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
			dataType: "json",
			success: function(data) {
				if (data.code == 200 && data.data != null) {
					sessions = data.data
					for (x in sessions) {
						var s = sessions[x]
						html = '<div class="contact" uid="' + s.uid + '">' +
							'<img src="' + s.avatar + '" alt="" class="contact__photo" />' +
							'<span class="contact__name">' + s.nickname + '</span>' +
							'<span class="delete-chat">x</span></div>';
						$(".sidebar-content").append(html)
					}
				}
				//删除会话
				$(".delete-chat").off("click");
				$(".delete-chat").click(function(e) {
					delFlag = 1;
					var contact = $(this).parent()
					contact.hide(speed = "normal");
					params = {
						uid: sessionStorage.uid,
						aid: $(this).parent().attr('uid'),
					}
					$.ajax({
						url: "/message/delSession",
						type: "POST",
						data: params,
						contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
						dataType: "json",
					})
				})
			},
		})
	}

	function listen() {
		if (!$(".chat").hasClass("active")) return;
		//用户私信，对话
		params = {
			uid: sessionStorage.uid,
			sid: $(".chat__input").attr('aid'),
			is_showName: 0,
		};
		$.ajax({
			url: "/message/GetMassageUseridAndAccpeter",
			type: "POST",
			data: params,
			contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
			dataType: "json",
			success: function(data) {
				if (data.code == 200 && data.data != null) {
					chats = data.data
					for (x in chats) {
						var c = chats[x]
						if (parseInt(c.user_id) == parseInt(sessionStorage.uid)) {
							html = '<div class="chat__msgRow"><div class="chat__message mine">' + c.content + '</div></div>';
						} else {
							html = '<div class="chat__msgRow"><div class="chat__message notMine">' + c.content + '</div></div>';
						}
						$(".chat__messages").append(html);
					}
				}
				setTimeout(listen, 5000);
			},
			error: function() {
				setTimeout(listen, 5000);
			}
		})
	}
	//點擊會話后
	$(document).on("click", ".contact", function(e) {
		if (delFlag == 1) {
			delFlag = 0
			return;
		}
		if (animating) return;
		animating = true;

		$(".chat__messages").html(""); //加載新对话前先清空对话内容
		$(".chat__input").attr('aid', $(this).attr('uid'))

		$(document).off("click", closeSidebar);
		$(".chat__person").html($(this).find(".contact__name").html());
		var that = this,
			name = $(this).find(".contact__name").text(),
			online = $(this).find(".contact__status").hasClass("online");
		$(".chat__name").text(name);
		$(".chat__online").removeClass("active");
		if (online) $(".chat__online").addClass("active");
		ripple($(that), e);
		setTimeout(function() {
			$sCont.removeClass("active");
			moveImage(that);
			finalX = -80;
			setTimeout(function() {
				$(".ripple").remove();
				animatePathD($path, clickMidD, animTime / 3, false, function() {
					curX = -80;
					finalX = 0;
					animatePathD($path, clickD, animTime * 2 / 3, true, function() {
						$chat.show();
						$chat.css("top");
						$chat.addClass("active");
						listen();
						animating = false;
					});
				}, "inCubic");
			}, sContTrans);
		}, sContTrans);
	});
	
	$(".chat__input").keypress(function(e) {//回车发送私信
		if (e.which == 13) {
			content = $(".chat__input").val();//先出字，再发送
			html = '<div class="chat__msgRow"><div class="chat__message mine">' + content + '</div></div>'
			$(".chat__messages").append(html);
			//jq發送事件
			params = {
				content: content,
				uid: sessionStorage.uid,
				aid: $(this).attr('aid'),
				is_showName: 0,
			}
			$.ajax({
				url: "/message/sendMassage",
				type: "POST",
				data: params,
				contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
				dataType: "json",
				success: function(data) {
					if (data.code == 200) {
						$(".chat__input").val("");
						$(".chat__input").focus();
					}
				},
			})
		}
	})
})