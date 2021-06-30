<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="utf-8">
<head>
<title>THEO DÕI SẢN XUẤT</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
	width: 150px;
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
	font-size: 20px;
	font-weight: 700;
	margin-right: 10px;
}

label {
	margin: 0px;
}

.out-date {
	background-color: #f37021;
	border-radius: 10px;
	font-weight: 700;
	text-align: center;
	font-size: 16px;
	line-height: 30px;
	color:white;
	text-transform: uppercase;
	height: 30px;
}

.ok-date {
	background-color: green;
	border-radius: 10px;
	font-weight: 700;
	text-align: center;
	font-size: 16px;
	line-height: 30px;
	text-transform: uppercase;
	height: 30px;
	color: white;
}

.warning-ok-date {
	background-color: #ccffcc;
	border-radius: 10px;
	font-weight: 700;
	text-align: center;
	font-size: 16px;
	line-height: 30px;
	text-transform: uppercase;
	height: 30px;
	color: black;
}

.warning-date {
	background-color: yellow;
	border-radius: 10px;
	font-weight: 700;
	text-align: center;
	font-size: 16px;
	text-transform: uppercase;
	line-height: 30px;
	color:red;
	height: 30px;
}

input[type="radio"] {
	width: 25px;
	height: 25px;
	vertical-align: sub;
}

.btn-paging {
	padding: 0px;
	line-height: 30px;
	background-color: #bdc6e2;
	border-radius: 0;
	width: 30px;
	height: 30px
}

.item-display {
	background-color: white;
	border-radius: 5px 5px 0px 0px;
	padding: 5px;
	border: 2px solid gray;
	margin-top: 10px;
	background-color: lightgray;
}

.item-display p {
	margin: 0px;
}

.item-display .head {
	margin: -6px;
	border-radius: 5px 5px 0px 0px;
	color: white;
}

.tableMobile {
	width: 100%;
	background-color: white;
}

.tableMobile th {
	background-color: #333399;
	color: white;
	font-weight: 700;
	text-transform: uppercase;
	padding-left: 5px;
	padding-right: 5px;
	border: 2px solid black;
	width: 70px;
	color: yellow;
}

.tableMobile td {
	font-weight: 700;
	border: 2px solid black;
	padding-left: 10px;
}
input[type="text"]:focus {
	outline: none;
	
}
</style>


</head>
<body id="bodyContent" onload="Pagination();">
	<div class="header">
		<img src="./resources/images/logonm.jpg" style="height:90%; margin-top: 3px; margin-left: 10px;">
		<h1 class="company-name" id="company-name">CÔNG TY TNHH SẢN XUẤT - THƯƠNG MẠI NGỌC MINH</h1>
		<div onclick="showMenu()" class="pagging-area"
			style="cursor: pointer; float: right; line-height: 80px; padding-right: 10px; margin-top: 10px;">
			<img src="./resources/images/menu-display-icon.png"
				style="height: 40px">
		</div>
	</div>
	<div class="header-sub">
		<p>MÀN HÌNH QUẢN LÝ THEO DÕI SẢN XUẤT</p>
	</div>
	<div style="padding: 10px;">
		<form action="ProductionManagement" method="post">
			<div class="title-display-view">
				<div class="table-area">
					<table class="table-display table table-bordered table-search">
						<thead>
							<tr id="row1hide">
								<th style="width: 150px">KHÁCH HÀNG</th>
								<td><input type="text" name="customer" value="${customer}"
									style="width: 100%"></td>
								<th style="width: 150px">SẢN PHẨM</th>
								<td><input type="text" name="production"
									value="${production}" style="width: 100%"></td>
								<th style="width: 150px">HĐ,PO</th>
								<td><input type="text" name="hdpo" value="${hdpo}"
									style="width: 100%"></td>
								<th style="width: 100px">PSX</th>
								<td><input type="text" name="psx" value="${psx}"
									style="width: 100%"></td>
							</tr>
							<tr>
								<th id="row2hide">NGÀY NHẬN</th>
								<td id="row3hide"><input type="text" name="recieveStart"
									value="${recieveStart}"
									style="width: 47%; vertical-align: text-top;">~<input
									name="recieveEnd" value="${recieveEnd}" type="text"
									style="width: 48%; vertical-align: text-top;"></td>
								<th id="row4hide">NGÀY GIAO</th>
								<td id="row5hide"><input type="text" name="realseKHStart"
									value="${realseKHStart}"
									style="width: 47%; vertical-align: text-top;">~<input
									name="realseKHEnd" value="${realseKHEnd}" type="text"
									style="width: 48%; vertical-align: text-top;"></td>
								<th>TRẠNG THÁI</th>
								<td colspan="3"><c:if test="${status == '-1'}">
										<label> <input type="radio" name="status"
											checked="checked" value="-1"> <span>Tất cả</span>
										</label>
										<label> <input type="radio" name="status" value="0">
											<span>Chưa giao</span>
										</label>
										<label> <input type="radio" name="status" value="5">
											<span>Đã giao</span>
										</label>
									</c:if> <c:if test="${status == '0'}">
										<label> <input type="radio" name="status" value="-1">
											<span>Tất cả</span>
										</label>
										<label> <input type="radio" name="status"
											checked="checked" value="0"> <span>Chưa giao</span>
										</label>
										<label> <input type="radio" name="status" value="5">
											<span>Đã giao</span>
										</label>
									</c:if> <c:if test="${status == '5'}">
										<label> <input type="radio" name="status" value="-1">
											<span>Tất cả</span>
										</label>
										<label> <input type="radio" name="status" value="0">
											<span>Chưa giao</span>
										</label>
										<label> <input type="radio" name="status"
											checked="checked" value="5"> <span>Đã giao</span>
										</label>
									</c:if></td>
							</tr>
						</thead>
					</table>
				</div>

				<div class="header-sub" style="height: 45px;">
					<div class="text-right">
						<button type="submit" name="sync" class="btn btn-control">ĐỒNG
							BỘ</button>
						<button type="submit" name="excel" class="btn btn-control">XUẤT EXCEL</button>
						<button type="submit" name="search" class="btn btn-control">TÌM
							KIẾM</button>
						<button type="submit" name="register" class="btn btn-control">ĐĂNG
							KÝ</button>
						<!-- 						<button type="submit" name="exportPDF" class="btn btn-control">XUẤT -->
						<!-- 							CSV</button> -->
					</div>
				</div>
			</div>
		</form>
		<jsp:include page="message.jsp"></jsp:include>
		<c:if test="${lst.size() > 0}">

			<div class="table-area" id="tableComputer" style="margin-top: 10px;">
				<table id="table.data" class="table-display table table-bordered"">
					<thead>
						<tr>
							<th rowspan="2" style="width: 60px">STT</th>
							<th rowspan="2">KHÁCH HÀNG</th>
							<th rowspan="2">SẢN PHẨM ĐẠI DIỆN</th>
							<th colspan="2" style="width: 300px">ĐƠN HÀNG</th>
							<th colspan="3" style="width: 450px">NGÀY</th>
							<th rowspan="2">GHI CHÚ</th>
							<th rowspan="2" style="width: 140px">TRẠNG THÁI</th>
							<th rowspan="2" style="width: 80px">XEM</th>
						</tr>
						<tr>
							<th style="width: 150px">HĐ,PO</th>
							<th style="width: 100px">PSX</th>
							<th style="width: 100px">NHẬN</th>
							<th style="width: 100px">GIAO KH</th>
							<th style="width: 100px">GIAO TT</th>
						</tr>
					</thead>
					<tbody>
						<%
							int stt = 1;
						%>
						<c:forEach var="p" items="${lst}">
							<tr>
								<td style="text-align: center;"><%=stt%></td>
								<td style=" overflow: hidden;"><input type="text" style="width:100%; border: 0px;" readonly="readonly" value="${p.getCustomerName()}"></td>
								<td style=" overflow: hidden;"><input type="text" style="width:100%; border: 0px;" readonly="readonly" value="${p.getProduction()}"></td>
								<td style="text-align: center;">${p.getHD_PO()}</td>
								<td style="text-align: center;">${p.getPSX()}</td>
								<td style="text-align: center;">${p.getRecieveDt()}</td>
								<td style="text-align: center;">${p.getReleaseScheDt()}</td>
								<td style="text-align: center;">${p.getReleaseRelDt()}</td>
								<td>${p.getNote()}</td>
								<td><c:if test="${p.getStatus() == '0'}">
									</c:if> <c:if test="${p.getStatus() == '1'}">
										<div class="ok-date">ĐÃ GIAO</div>
									</c:if> <c:if test="${p.getStatus() == '2'}">
										<div class="warning-date">ĐẾN HẠN</div>
									</c:if> <c:if test="${p.getStatus() == '3'}">
										<div class="warning-ok-date">GIAO TRỄ</div>
									</c:if> <c:if test="${p.getStatus() == '4'}">
										<div class="out-date">Trễ hạn</div>
									</c:if></td>
								<td><form action="ProductionView" method="post">
										<input type="text" style="display: none;" name="orderCd"
											value="${p.getOrderCd()}">
										<button type="submit" name="view" class="btn-view">XEM</button>
									</form></td>
							</tr>
							<%
								stt = stt + 1;
							%>
						</c:forEach>

					</tbody>
				</table>
				<div class="text-right" style="margin-top: 10px;">
					<%
						if (stt > 13) {
								double countPage = stt / 13;
								if (stt % 13 > 0) {
									countPage += 1;
								}
								int j = 1;
								while (j <= countPage) {
									int startIndex = j * 13 - 12;
									int endIndex = startIndex + 12;
					%>
					<a class="btn btn-default btn-paging" id='pagging.btn<%=j%>'
						onclick="movePage('<%=startIndex%>','<%=endIndex%>', '<%=j%>', '<%=countPage%>')"><%=j%></a>
					<%
						j++;
								}
							}
					%>


				</div>
			</div>

			<div class="container" id="tableMobile" style="padding: 0px;">

				<div class="row" style="margin: auto; width: 100%">
					<c:forEach var="p" items="${lst}">
						<div class="col-sm-12 col-lg-12 col-md-12"
							style="text-align: center;">
							<div class="item-display">
								<div class="head" style="background-color: #333399">
									<p style="font-weight: 700; font-size: 25px;">HĐPO:
										${p.getHD_PO()}</p>
								</div>
								<table class="tableMobile" style="margin-top: 10px">
									<tr>
										<th>KH</th>
										<td>${p.getCustomerName()}</td>
									</tr>
									<tr>
										<th>PSX</th>
										<td>${p.getPSX()}</td>
									</tr>
									<tr>
										<th>SPĐD</th>
										<td>${p.getProduction()}</td>
									</tr>
								</table>
								<table class="tableMobile" style="margin-top: 10px">
									<tr style="text-align: center;">
										<th>Ngày nhận</th>
										<th>Ngày giao KH</th>
									</tr>
									<tr style="text-align: center;">
										<td>${p.getRecieveDt()}</td>
										<td>${p.getReleaseScheDt()}</td>
									</tr>
								</table>
								<table class="tableMobile" style="margin-top: 10px">
									<tr style="text-align: center;">
										<th>Ngày giao hàng thực tế</th>

									</tr>
									<tr style="text-align: center;">
										<td>${p.getReleaseRelDt()}</td>

									</tr>
								</table>
								<div class="head" style="border-radius: 0px; margin-top: 5px;">
									<c:if test="${p.getStatus() == '0'}">
									</c:if>
									<c:if test="${p.getStatus() == '1'}">
										<div style="border-radius: 0px" class="ok-date">ĐÃ GIAO</div>
									</c:if>
									<c:if test="${p.getStatus() == '2'}">
										<div style="border-radius: 0px; color: red"
											class="warning-date">ĐƠN HÀNG SẮP GIAO</div>
									</c:if>
									<c:if test="${p.getStatus() == '3'}">
										<div style="border-radius: 0px" class="warning-ok-date">GIAO
											TRỄ</div>
									</c:if>
									<c:if test="${p.getStatus() == '4'}">
										<div style="border-radius: 0px" class="out-date">ĐƠN
											HÀNG ĐÃ BỊ TRỄ</div>
									</c:if>
								</div>
								<div class="head">
									<form action="ProductionView" method="post">
										<input type="text" style="display: none;" name="orderCd"
											value="${p.getOrderCd()}">
										<button type="submit" name="view"
											style="width: 100%; margin-top: 10px" class="btn-view">
											<i class="fa fa-eye"
												style="font-size: 20px; margin-right: 5px;"
												aria-hidden="true"></i>XEM
										</button>
									</form>

								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>

		</c:if>
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
				class="item-menu">MÀN HÌNH HIỂN THỊ</a>
			<c:if test="${role == 'admin'}">
				<a href="SytsemManagement" id="system" class="item-menu">QUẢN
					TRỊ HỆ THỐNG</a>
			</c:if>
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

	//Hàm click button chuyển trang
	function movePage(start, end, indexCurrent, countPage) {
		var x = document.getElementById("table.data").rows.length;
		for (var i = 2; i < x; i++) {
			var index = i + 1;
			if (i >= start && i <= end) {
				document.getElementById("table.data").rows[i].style.display = '';
			} else {
				document.getElementById("table.data").rows[i].style.display = 'none';
			}

		}
		for (var i = 1; i <= countPage; i++) {
			x = document.getElementById("pagging.btn" + i);
			x.style.backgroundColor = "";
			x.style.color = "black";
		}
		x = document.getElementById("pagging.btn" + indexCurrent);
		x.style.backgroundColor = "red";
		x.style.color = "white";

	}
	//Hàm phân trang cho dữ liệu
	function Pagination() {
		var x = document.getElementById("pagging.btn1");
		x.style.backgroundColor = "red";
		x.style.color = "white";
		x = document.getElementById("table.data").rows.length;
		if (x > 10) {
			for (var i = 13; i < x; i++) {
				document.getElementById("table.data").rows[i + 1].style.display = 'none';
			}

		}
	}

	function getBrowserSize() {
		var w, h;

		if (typeof window.innerWidth != 'undefined') {
			w = window.innerWidth; //other browsers
			h = window.innerHeight;
		} else if (typeof document.documentElement != 'undefined'
				&& typeof document.documentElement.clientWidth != 'undefined'
				&& document.documentElement.clientWidth != 0) {
			w = document.documentElement.clientWidth; //IE
			h = document.documentElement.clientHeight;
		} else {
			w = document.body.clientWidth; //IE
			h = document.body.clientHeight;
		}
		return {
			'width' : w,
			'height' : h
		};
	}

	if (parseInt(getBrowserSize().width) < 1500) {

// 		document.getElementById("company-name").style.fontSize = "2vw";
// 		document.getElementById("tableComputer").style.display = "none";

// 		document.getElementById("row1hide").style.display = "none";
// 		document.getElementById("row2hide").style.display = "none";
// 		document.getElementById("row3hide").style.display = "none";
// 		document.getElementById("row4hide").style.display = "none";
// 		document.getElementById("row5hide").style.display = "none";
// 		document.getElementById("system").style.display = "none";
		
		document.getElementById("bodyContent").style.width="2040px";
		document.getElementById("tableMobile").style.display = "none";
	} else {
		document.getElementById("tableMobile").style.display = "none";

	}
</script>

</html>
