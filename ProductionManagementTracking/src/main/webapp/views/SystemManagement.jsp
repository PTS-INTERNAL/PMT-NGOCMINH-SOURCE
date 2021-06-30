<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="utf-8">
<head>
<title>QUẢN TRỊ HỆ THỐNG</title>
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
*{
     font-family: 'Inter', sans-serif;
     font-weight: bold !important;
 }
.header-sub {
	height: 35px;
	width: 100%;
	background: #6495f5;
	font-weight: 700;
	line-height: 35px;
}

.header-sub p {
	display: table;
	vertical-align: -webkit-baseline-middle;
	line-height: initial;
}

.header-sub p {
	text-align: center;
	width: 100%
}

button.btn-control {
	background-color: #333399;
	color: white;
	border-radius: 0px;
	height: 45px;
	border: 0px;
	font-weight: 700;
	width: 100%;
	margin-bottom: 3px;
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
</style>
</head>
<body onload="Pagination();">
	<div class="header">
		<img src="./resources/images/logonm.jpg" style="height:90%; margin-top: 3px; margin-left: 10px;">
		<h1 class="company-name">CÔNG TY TNHH SẢN XUẤT - THƯƠNG MẠI NGỌC MINH</h1>
		<div onclick="showMenu()" class="pagging-area"
			style="cursor: pointer; float: right; line-height: 80px; padding-right: 10px; margin-top: 10px;">
			<img src="./resources/images/menu-display-icon.png"
				style="height: 40px">
		</div>
	</div>
	<div class="header-sub">
		<p>MÀN HÌNH QUẢN TRỊ HỆ THỐNG</p>
	</div>
	<div style="padding: 10px;">
		<form action="SystemManagement" method="post">
			<div class="row">
				<div class="col-sm-2" style="text-align: center;">
					<button type="button" onclick="ChangeSource('ChangePin')" class="btn btn-control">ĐỔI PIN</button>
					<br>
					<button type="button" onclick="ChangeSource('UserManagement')" class="btn btn-control">TẠO NGƯỜI
						DÙNG</button>
					<br>
					<button type="button" onclick="ChangeSource('ChangeInterval')" class="btn btn-control">ĐỔI THỜI GIAN</button>
<!-- 					<button type="button" class="btn btn-control"> -->
<!-- 						NGÀY CẢNH BÁO</button> -->
					<br>
				</div>
				<div class="col-sm-10">

					<iframe id="sourceFrame" style="width:100%; height:700px" src="http://45.77.254.67:8080/ngocminh.tracking/login"
						title="W3Schools Free Online Web Tutorials">
					</iframe>
				</div>
			</div>
		</form>

	</div>

	<div class="panel-menu" id="menu-right"
		style="transition: 0.5s; width: 0%">
		<div style="width: 100%; cursor: pointer; display: block;"
			onclick="hideMenu()">
			<img src="./resources/images/arrow-back.png" width="50px"
				style="margin: 5px;">
			<p
				style="font-weight: 700; font-size: 25px; color: white; line-height: 50px; padding-left: 10px;">
				TRỞ VỀ</p>
		</div>
		<div style="width: 100%; display: block;">
			<a href="Clock" class="item-menu">KHÓA MÀN HÌNH</a> <a href="login"
				class="item-menu">ĐĂNG NHẬP</a> <a href="ProductionDisplay"
				class="item-menu">MÀN HÌNH HIỂN THỊ</a> <a
				href="ProductionManagement" class="item-menu">QUẢN LÝ SẢN XUẤT</a>
		</div>
	</div>


</body>
<script type="text/javascript">
	function hideMenu() {
		document.getElementById("menu-right").style.width = "0%";
	}
	function showMenu() {
		document.getElementById("menu-right").style.width = "300px";
	}
	function ChangeSource(url) {
		
		var ifr = document.getElementById("sourceFrame");
		ifr.src = window.location.protocol + "//" + window.location.host + "/" +  "ngocminh.tracking" + "/" +  url
		
	}
	
</script>
</html>
