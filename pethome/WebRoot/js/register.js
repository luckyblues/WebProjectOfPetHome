$(function() {
	// ѭ�������õ����д�����Ϣ�����÷���ȷ���Ƿ���ʾ������Ϣ
	$(".errorClass").each(function() {
		showError($(this)); // ʹÿ��Ԫ�ص���showError����
	});

	// �����õ��������ش�����Ϣ
	$(".inputClass").focus(function() {
		var labelId = $(this).attr("id") + "Error";// ͨ��������ҵ���Ӧ��label
		$("#" + labelId).text("");// ��label��������գ�
		showError($("#" + labelId));
	});

	// �����ʧȥ����У��
	$(".inputClass").blur(
			function() {
				var id = $(this).attr("id"); // ��ȡ��ǰ�����id
				var funName = "validate" + id.substring(0, 1).toUpperCase()
						+ id.substring(1) + "()";
				eval(funName);// ִ�к�������
			});

});

// �û���У��
function validateUname() {
	var id = "uname";
	var value = $("#" + id).val();// ��ȡ������ֵ
	// �ǿ�У��
	if (!value) {
		$("#" + id + "Error").text("�û�������Ϊ��");// ��ȡlabel
		// ��Ӵ�����Ϣ
		showError($("#" + id + "Error"));// ��ʾlabel
		return false;
	}
	// ����У��
	if (value.length > 30 || value.length < 3) {
		$("#" + id + "Error").text("�û�����3-30λ");// ��ȡlabel
		// ��Ӵ�����Ϣ
		showError($("#" + id + "Error"));// ��ʾlabel
		return false;
	}
	return true;
}

// ����У��
function validateUpwd() {
	var id = "upwd";
	var value = $("#" + id).val();// ��ȡ������ֵ
	// �ǿ�У��
	if (!value) {
		$("#" + id + "Error").text("���벻��Ϊ��");// ��ȡlabel
		// ��Ӵ�����Ϣ
		showError($("#" + id + "Error"));// ��ʾlabel
		return false;
	}
	// ����У��
	if (value.length > 30 || value.length < 6) {
		$("#" + id + "Error").text("������6-30λ����");// ��ȡlabel
		// ��Ӵ�����Ϣ
		showError($("#" + id + "Error"));// ��ʾlabel
		return false;
	}
	return true;
}

// ȷ������У��
function validateAffpwd() {
	var id = "affpwd";
	var value = $("#" + id).val();// ��ȡ������ֵ
	// �ǿ�У��
	if (!value) {
		$("#" + id + "Error").text("ȷ�����벻��Ϊ��");// ��ȡlabel
		// ��Ӵ�����Ϣ
		showError($("#" + id + "Error"));// ��ʾlabel
		return false;
	}
	// У�����������Ƿ�һ��
	if (value != $("#upwd").val()) {
		$("#" + id + "Error").text("�������벻һ��");// ��ȡlabel
		// ��Ӵ�����Ϣ
		showError($("#" + id + "Error"));// ��ʾlabel
		false;
	}
	return true;
}

// ����У��
function validateEmail() {
	var id = "email";
	var value = $("#" + id).val();// ��ȡ������ֵ
	// �ǿ�У��
	if (!value) {
		$("#" + id + "Error").text("�������");// ��ȡlabel
		// ��Ӵ�����Ϣ
		showError($("#" + id + "Error"));// ��ʾlabel
		return false;
	}
	// ��ʽУ��
	if (!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/
			.test(value)) {
		$("#" + id + "Error").text("����������ʽ");// ��ȡlabel ��Ӵ�����Ϣ
		showError($("#" + id + "Error"));// ��ʾlabel
		return false;
	}
	return true;
}

// �жϵ�ǰԪ���Ƿ�������ݣ�������ʾ�������ڲ���ʾ
function showError(now) {
	var text = now.text(); // ��ȡԪ������
	if (!text)// û������
	{
		now.css("display", "none"); // ����
	} else // ������
	{
		now.css("display", ""); // ��ʾ����
	}
}

function checkUname() {
	// ����ı����ֵ
	var uname = document.getElementById("uname").value;
	// �����첽�����Ķ���
	var xhr = createXmlHttp();
	// ���ü���
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4)
			if (xhr.state == 200)
				document.getElementById("span1").innerHTML = xhr.responseText;
	}
	// ������
	xhr.open("GET",
			"${pageContext.request.contextPath}/user_findByUname.action?time="
					+ new Date().getTime() + "&uname=" + uname, true);//
	// ����
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