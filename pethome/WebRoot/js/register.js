$(function() {
	// 循环遍历得到所有错误信息，调用方法确定是否显示错误信息
	$(".errorClass").each(function() {
		showError($(this)); // 使每个元素调用showError方法
	});

	// 输入框得到焦点隐藏错误信息
	$(".inputClass").focus(function() {
		var labelId = $(this).attr("id") + "Error";// 通过输入框找到对应的label
		$("#" + labelId).text("");// 把label的内容清空！
		showError($("#" + labelId));
	});

	// 输入框失去焦点校验
	$(".inputClass").blur(
			function() {
				var id = $(this).attr("id"); // 获取当前输入框id
				var funName = "validate" + id.substring(0, 1).toUpperCase()
						+ id.substring(1) + "()";
				eval(funName);// 执行函数调用
			});

});

// 用户名校验
function validateUname() {
	var id = "uname";
	var value = $("#" + id).val();// 获取输入框的值
	// 非空校验
	if (!value) {
		$("#" + id + "Error").text("用户名不能为空");// 获取label
		// 添加错误信息
		showError($("#" + id + "Error"));// 显示label
		return false;
	}
	// 长度校验
	if (value.length > 30 || value.length < 3) {
		$("#" + id + "Error").text("用户名在3-30位");// 获取label
		// 添加错误信息
		showError($("#" + id + "Error"));// 显示label
		return false;
	}
	return true;
}

// 密码校验
function validateUpwd() {
	var id = "upwd";
	var value = $("#" + id).val();// 获取输入框的值
	// 非空校验
	if (!value) {
		$("#" + id + "Error").text("密码不能为空");// 获取label
		// 添加错误信息
		showError($("#" + id + "Error"));// 显示label
		return false;
	}
	// 长度校验
	if (value.length > 30 || value.length < 6) {
		$("#" + id + "Error").text("请输入6-30位密码");// 获取label
		// 添加错误信息
		showError($("#" + id + "Error"));// 显示label
		return false;
	}
	return true;
}

// 确认密码校验
function validateAffpwd() {
	var id = "affpwd";
	var value = $("#" + id).val();// 获取输入框的值
	// 非空校验
	if (!value) {
		$("#" + id + "Error").text("确认密码不能为空");// 获取label
		// 添加错误信息
		showError($("#" + id + "Error"));// 显示label
		return false;
	}
	// 校验两次输入是否一致
	if (value != $("#upwd").val()) {
		$("#" + id + "Error").text("两次密码不一致");// 获取label
		// 添加错误信息
		showError($("#" + id + "Error"));// 显示label
		false;
	}
	return true;
}

// 邮箱校验
function validateEmail() {
	var id = "email";
	var value = $("#" + id).val();// 获取输入框的值
	// 非空校验
	if (!value) {
		$("#" + id + "Error").text("邮箱错误");// 获取label
		// 添加错误信息
		showError($("#" + id + "Error"));// 显示label
		return false;
	}
	// 格式校验
	if (!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/
			.test(value)) {
		$("#" + id + "Error").text("错误的邮箱格式");// 获取label 添加错误信息
		showError($("#" + id + "Error"));// 显示label
		return false;
	}
	return true;
}

// 判断当前元素是否存在内容，存在显示，不存在不显示
function showError(now) {
	var text = now.text(); // 获取元素内容
	if (!text)// 没有内容
	{
		now.css("display", "none"); // 隐藏
	} else // 有内容
	{
		now.css("display", ""); // 显示内容
	}
}

function checkUname() {
	// 获得文本框的值
	var uname = document.getElementById("uname").value;
	// 创建异步交互的对象
	var xhr = createXmlHttp();
	// 设置监听
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4)
			if (xhr.state == 200)
				document.getElementById("span1").innerHTML = xhr.responseText;
	}
	// 打开连接
	xhr.open("GET",
			"${pageContext.request.contextPath}/user_findByUname.action?time="
					+ new Date().getTime() + "&uname=" + uname, true);//
	// 发送
	xhr.send(null);
}
function createXmlHttp() {
	var xmlHttp;
	try { // Firefox, Opera 8.0+, Safari
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		try {// Internet Explorer
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
			}
		}
	}

	return xmlHttp;
}