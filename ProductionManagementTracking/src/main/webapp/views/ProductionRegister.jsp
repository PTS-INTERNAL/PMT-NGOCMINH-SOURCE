<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
<title>ĐĂNG KÝ ĐƠN HÀNG</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="./resources/javascript/common.js"></script>
<style>
.fakeimg {
	height: 200px;
	background: #aaa;
}

.header {
	height: 60px;
	width: 100%;
	background: #333399;
}

.title-display-view {
	padding-top: 10px;
	padding-bottom: 10px;
}

img {
	float: left;
}

.company-name {
	float: left;
	line-height: 60px;
	padding-left: 10px;
	color: white;
}

.title-table {
	text-align: center;
	color: #333399;
}

.title-display-view .item {
	font-size: 25px;
	font-weight: 700;
}

.table-display {
	border: 1px solid;
	width: 100%
}

.table-display thead tr th {
	font-size: 20px;
	font-weight: 700;
	vertical-align: middle;
	text-align: center;
	padding: 2px;
	background: #333399;
	color: white;
	border: 2px solid black;
}

.table-display tbody tr td {
	font-size: 18px;
	font-weight: bold !important;
	padding: 5px;
	border: 2px solid black;
}

.panel-menu {
	height: 100%;
	background: #333399;
	z-index: 999999;
	position: fixed;
	top: 0;
	right: 0;
	width: 300px;
	transition: 2s;
	box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.16), 0 2px 10px 0
		rgba(0, 0, 0, 0.12);
}

.panel-menu .item-menu {
	color: white;
	display: block;
	width: 300px;
	background-color: #ff6666;
	font-weight: 700;
	height: 45px;
	margin-top: 5px;
	text-align: center;
	vertical-align: middle;
	line-height: 45px;
	text-decoration: none;
}

.panel-menu .item-menu:hover {
	background-color: #ffe6e6;
	color: #ff6666;
}

input[type="text"] {
	border-radius: 0px;
	border: 1px solid black;
	padding: 2px;
}

.table-search thead tr td, .table-search thead tr th {
	padding: 2px;
	border: 2px solid black;
}

.header-sub {
	height: 35px;
	width: 100%;
	background: #6495f5;
	font-weight: 700;
	line-height: 35px;
}
*{
     font-family: 'Inter', sans-serif;
     font-weight: bold !important;
 }
.header-sub p {
	display: table;
	vertical-align: -webkit-baseline-middle;
	line-height: initial;
	text-align: center;
	width: 100%;
}

button.btn-control {
	background-color: #333399;
	color: white;
	border-radius: 0px;
	height: 45px;
	border: 0px;
	font-weight: 700;
	width: 160px;
}

button.btn-view {
	background-color: #333399;
	color: white;
	border-radius: 0px;
	height: 30px;
	border: 0px;
	font-weight: 700;
	width: 75px;
}

label span {
	font-size: 15px;
	font-weight: 700;
	margin-right: 10px;
}

.out-date {
	background-color: orange;
	border-radius: 10px;
	font-weight: 700;
	text-align: center;
	font-size: 20px;
	line-height: 35px;
	text-transform: uppercase;
	height: 35px;
}

.ok-date {
	background-color: green;
	border-radius: 10px;
	font-weight: 700;
	text-align: center;
	font-size: 20px;
	line-height: 35px;
	text-transform: uppercase;
	height: 35px;
	color: white;
}

.warning-ok-date {
	background-color: #ccffcc;
	border-radius: 10px;
	font-weight: 700;
	text-align: center;
	font-size: 20px;
	line-height: 35px;
	text-transform: uppercase;
	height: 35px;
	color: black;
}

.warning-date {
	background-color: yellow;
	border-radius: 10px;
	font-weight: 700;
	text-align: center;
	font-size: 20px;
	text-transform: uppercase;
	line-height: 35px;
	height: 35px;
}

.title-input {
	font-weight: 700;
	margin-bottom: 0px;
}
</style>
</head>
<body>
	<div class="header">
		<img src="./resources/images/logonm.jpg" style="height:90%; margin-top: 3px; margin-left: 10px;">
		<h1 class="company-name" id="company-name">CÔNG TY TNHH SẢN XUẤT - THƯƠNG MẠI NGỌC MINH</h1>
		<div onclick="ToLink('ProductionManagement')" class="pagging-area"
			style="cursor: pointer; float: right; line-height: 80px; padding-right: 10px; margin-top: 10px;">
			<img src="./resources/images/arrow-back.png" style="height: 40px">
		</div>
	</div>
	<div class="header-sub">
		<p>MÀN HÌNH ĐĂNG KÝ ĐƠN HÀNG SẢN XUẤT</p>
	</div>
	<div style="padding: 10px;">
		<div class="title-display-view">

			<form action="ProductionRegister" method="POST">
				<div class="header-sub" style="height: 45px;">
					<div class="text-right">
						<button type="submit" name="save" class="btn btn-control">LƯU
							THÔNG TIN</button>
					</div>
				</div>
				<jsp:include page="message.jsp"></jsp:include>
				<div class="container-fluid" style="margin-top: 10px;">
					<div class="row">
						<div class="col-lg-4">
							<div class="form-group">
								<label class="title-input">KHÁCH HÀNG:</label> <input
									type="text" class="form-control" value="${customer}"
									name="customer">
							</div>
						</div>
						<div class="col-lg-4">
							<div class="form-group">
								<label class="title-input">SẢN PHẨM ĐẠI DIỆN:</label> <input
									type="text" class="form-control" value="${production}"
									name="production">
							</div>
						</div>
						<div class="col-sm-12 col-md-6 col-lg-4">
							<div class="form-group">
								<label class="title-input">HĐ - PO:</label> <input type="text"
									class="form-control" value="${hdpo}" name="hdpo">
							</div>
						</div>
						<div class="col-sm-3 col-md-6 col-lg-4">
							<div class="form-group">
								<label class="title-input">PSX:</label> <input type="text"
									class="form-control" value="${psx}" name="psx">
							</div>
						</div>
						<div class="col-sm-3 col-md-6 col-lg-4">
							<div class="form-group">
								<label class="title-input">NGÀY NHẬN:</label> <input
									value="${recieveDt}" type="text" class="form-control"
									name="recieveDt">
							</div>
						</div>
						<div class="col-sm-3 col-md-6 col-lg-4">
							<div class="form-group">
								<label class="title-input">NGÀY GIAO KẾ HOẠCH:</label> <input
									type="text" class="form-control" value="${releaseScheDt}"
									name="releaseScheDt">
							</div>
						</div>
						<div class="col-sm-12 col-md-12 col-lg-12">
							<div class="form-group">
								<label class="title-input">GHI CHÚ:</label>
								<textarea style="resize: none; height: 100px; width: 100%"
									name="note">${note}</textarea>
							</div>
						</div>
					</div>
				</div>
				<input type="text" style="display:none;" class="form-control" name="isMode" id="isMode">
		</div>
		</form>
	</div>
	
	<script type="text/javascript">
	function getBrowserSize(){
	    var w, h;

	      if(typeof window.innerWidth != 'undefined')
	      {
	       w = window.innerWidth; //other browsers
	       h = window.innerHeight;
	      } 
	      else if(typeof document.documentElement != 'undefined' && typeof      document.documentElement.clientWidth != 'undefined' && document.documentElement.clientWidth != 0) 
	      {
	       w =  document.documentElement.clientWidth; //IE
	       h = document.documentElement.clientHeight;
	      }
	      else{
	       w = document.body.clientWidth; //IE
	       h = document.body.clientHeight;
	      }
	    return {'width':w, 'height': h};
	}

	if(parseInt(getBrowserSize().width) < 900){ 
		document.getElementById("company-name").style.fontSize = "2vw";  
		document.getElementById("isMode").value = "isMobile";
	}
	else
	{
		document.getElementById("isMode").value = "isPC";
	}
	
	</script>
</body>
</html>
