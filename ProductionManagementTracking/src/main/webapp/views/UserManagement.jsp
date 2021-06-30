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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
.fakeimg {
	height: 200px;
	background: #aaa;
}

.title-sub {
	height: 40px;
	width: 100%;
	background: #333399;
}

.title-sub p {
	text-align: center;
	font-weight: 700;
	color: white;
	line-height: 40px;
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
select {
	border-radius: 0px;
	border: 1px solid black;
	padding: 2px;
	width:100%
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

.header-sub p {
	display: table;
	vertical-align: -webkit-baseline-middle;
	line-height: initial;
}

.header-sub p {
	text-align: center;
	width: 100%
}
*{
     font-family: 'Inter', sans-serif;
     font-weight: bold !important;
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
	background-color: orange;
	border-radius: 10px;
	font-weight: 700;
	text-align: center;
	font-size: 16px;
	line-height: 30px;
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
</style>
</head>
<body>
	<div class="title-sub">
		<p>MÀN HÌNH QUẢN LÝ NGƯỜI DÙNG</p>
	</div>
	<div style="padding: 10px;">
		<form action="UserManagement" method="post">
			<div class="title-display-view">
				<div class="table-area">
					<table class="table-display table table-bordered table-search">
						<thead>
							<tr>
								<th style="width: 150px">TÊN ĐẦY ĐỦ</th>
								<td><input type="text" name="fullName" value="${fullName}"
									style="width: 100%"></td>
								<th style="width: 182px">TÊN ĐĂNG NHẬP</th>
								<td><input type="text" name="username"
									value="${username}" style="width: 100%"></td>
								<th style="width: 150px">MẬT KHẨU</th>
								<td><input type="text" name="password" value="${password}"
									style="width: 100%"></td>
							</tr>
							<tr>
								
								<th style="width: 100px">QUYỀN</th>
								<td>
									<select name="role">
									<c:if test="${role =='admin'}">
									<option value="manager">QUẢN LÝ</option>
									<option value="admin" selected="selected">ADMIN</option>
									</c:if>
									
									<c:if test="${role =='manager'}">
									<option value="manager" selected="selected">QUẢN LÝ</option>
									<option value="admin">ADMIN</option>
									</c:if>
									
									</select>
								</td>

							</tr>
						</thead>
					</table>
				</div>
					<jsp:include page="message.jsp"></jsp:include>
				<div class="header-sub" style="height: 45px;">
					<div class="text-right">
						<button type="submit" name="register" class="btn btn-control">ĐĂNG
							KÝ</button>
					</div>
				</div>
					<div class="table-area" style="margin-top: 10px;">
				<table id="table.data" class="table-display table table-bordered"">
					<thead>
						<tr>
							<th  style="width: 60px">STT</th>
							<th >HỌ VÀ TÊN</th>
							<th >TÊN ĐĂNG NHẬP</th>
							<th >MẬT KHẨU</th>
							<th >QUYỀN</th>
							<th style="width:60px">XÓA</th>
						</tr>
					</thead>
					<tbody>
						<%
							int stt = 1;
						%>
						<c:forEach var="p" items="${lst}">
							<tr>
								<td style="text-align: right;"><%=stt%></td>
								<td>${p.getFullName()}</td>
								<td>${p.getUserName()}</td>
								<td style="text-align: center;">${p.getPassword()}</td>
								<td style="text-align: center;">${p.getRole()}</td>
								<td style="text-align: center;">
								<form action="UserManagement" method="post">
										<input type="text" style="display: none;" name="userCd"
											value="${p.getUserCd()}">
										<button type="submit" name="delete" class="btn-view">XÓA</button>
									</form>
								</td>
							</tr>
							<%
								stt = stt + 1;
							%>
							</c:forEach>

					</tbody>
				</table>
				</div>
			</div>
		</form>
	</div>


</body>
</html>
