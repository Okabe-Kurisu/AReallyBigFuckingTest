$(function() {
	var baseUrl = "http://localhost:8080"
	$(".sign").click(function() {
		$("#SignFlowHomepage-content1").show();
		$("#SignFlowHomepage-content2").hide();
	});
	$(".login").click(function() {
		$("#SignFlowHomepage-content1").hide();
		$("#SignFlowHomepage-content2").show();

	});
	$("#signin-btn").click(function() {
		console.log('注册')
		var param = {
			username: $(".signin-username").val(),
			nickname: $(".signin-nickname").val(),
			password: $(".signin-password").val(),
			sex: $(".sex:checked").val(),
			is_ns: 0,
			age: $(".signin-age").val(),
		}
		console.log(param)
		if ($("#is_ns").is(':checked')) {
			param['is_ns'] = 1
		}
		$.ajax({
			url: "/user/signIn",
			data: param,
			type: "POST",
			contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
			dataType: "json",
			success: function(data) {
				if (data.code == 200) {
					mdui.snackbar("注册成功");
					sessionStorage.me = data.data.me
					setTimeout("self.location= '/'", 3000);
				}else{
					mdui.snackbar("注册失败,");
				}
			},
			error: function() {
				mdui.snackbar("注册失败");
			},
		})
	});

	$("#login-btn").click(function() {
		console.log('登陆')
		var param = {
			username: $(".login-username").val(),
			password: $(".login-password").val(),
		}
		console.log(param)
		$.ajax({
			url: "/user/login",
			data: param,
			type: "POST",
			contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
			dataType: "json",
			success: function(data) {
				if (data.code == 200) {
					mdui.snackbar("登陆成功");
					sessionStorage.me = data.data.me
					setTimeout("self.location= '/'", 3000);
				}else{
					mdui.snackbar("注册失败,");
				}
			},
			error: function() {
				mdui.snackbar("登陆失败");
			},
		})
	});
})