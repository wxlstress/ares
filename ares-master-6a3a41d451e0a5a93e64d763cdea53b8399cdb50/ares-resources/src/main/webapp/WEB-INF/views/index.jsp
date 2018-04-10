<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" scope="application" />
<!DOCTYPE html>
<html>
<head>
<title>渤海信托-报表推送</title>
<script src="${basePath}/static/js/jquery-2.1.4.min.js"></script>
<script src="${basePath}/static/js/bootstrap.min.js"></script>
<script src="${basePath}/static/js/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
<script src="${basePath}/static/js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script src="${basePath}/static/js/jquery-confirm.min.js" charset="UTF-8"></script>
<link href="${basePath}/static/css/bootstrap.min.css" rel="stylesheet" />
<link href="${basePath}/static/css/jquery-confirm.min.css" rel="stylesheet" />
<link href="${basePath}/static/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
<style type="text/css">
.vertical-center {
	position: absolute;
	top: 30%;
	left: 50%;
	transform: translate(-50%, -50%);
}
</style>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-3 column vertical-center">
				<div class="row clearfix">
					<div class="col-md-12 column">
						<h4 class="text-center text-warning">推送报表</h4>
					</div>
				</div>
				<div class="form-group" style="margin-top: 60px;">
					<label for="date">选择日期</label>
					<input type="text" id="date" name="date" readonly class="form-control form_datetime">
				</div>
				<button type="button" onclick="javascript:submit();" class="btn btn-block btn-large btn-info">推送</button>
			</div>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
	$(function() {
		$(".form_datetime").datetimepicker({
			format : 'yyyy-mm-dd',
			weekStart : 1,
			autoclose : true,
			startView : 2,
			minView : 2,
			forceParse : false,
			language : 'zh-CN'
		});
	});

	function submit() {
		var today = $("#date").val();
		$.post("${basePath}/manual/isExecuted", {"date" : today}, function(result) {
			if (result.success) {
				if (result.isExecuted) {
					$.confirm({
						title : '请您确认',
						content : today + "日已推送过报表，是否确认重新推送?",
						buttons : {
							cancel : {
								text : '退出',
								keys : [ 'esc' ],
								action : function() {
									$.alert('请重新选择日期吧!');
								}
							},somethingElse : {
								text : '确定推送',
								btnClass : 'btn-primary',
								keys : [ 'enter' ],
								action : function() {
									supplement(today);
								}
							}
						}
					});
				} else {
					supplement(today);
				}
			} else {
				$.alert("执行失败," + result.msg);
			}
		});
	}
	
	function supplement(today) {
		$.post("${basePath}/manual/supplement", {"date" : today}, function(result) {
			$.alert(result.msg);
		});
	}
</script>
