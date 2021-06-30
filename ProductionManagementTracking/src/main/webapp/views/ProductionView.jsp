<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="UTF-8">
<head>
<title>XEM ĐƠN HÀNG</title>
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
	border: 1px inset;
}

textarea[readonly="readonly"], textarea[readOnly] {
	background-color: #e9ecef;
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
		<img src="./resources/images/logonm.jpg" id="logoImage" style="height:90%; margin-top: 3px; margin-left: 10px;">
		<h1 class="company-name" id="company-name">CÔNG TY TNHH SẢN XUẤT - THƯƠNG MẠI NGỌC MINH</h1>
		<div onclick="ToLink('ProductionManagement')" class="pagging-area"
			style="cursor: pointer; float: right; line-height: 80px; padding-right: 10px; margin-top: 10px;">
			<img src="./resources/images/arrow-back.png"  style="height: 40px">
		</div>
	</div>
	<div class="header-sub" id="header-sub-name"><p>MÀN HÌNH ĐĂNG KÝ ĐƠN HÀNG SẢN XUẤT</p></div>
	<div style="padding: 10px;">
		<div class="title-display-view">

			<form action="ProductionView" method="POST">
				<div class="header-sub" id="header-sub" style="height: 45px;">
					<div class="text-right">
						<button type="button" onclick="clickUpdate()" name="update"
							id="update" style="width: 210px;" class="btn btn-control">CHỈNH
							SỬA THÔNG TIN</button>
						<button type="submit" onclick="clickDisUpdate()" name="view"
							id="disUpdate" style="display: none;" class="btn btn-control">BỎ
							CHỈNH SỬA</button>
						<button type="submit" name="saveUpdate" id="saveUpdate"
							style="display: none; width: 180px;" class="btn btn-control">LƯU
							CHỈNH SỬA</button>
						<button type="button" name="Showstatus" data-toggle="modal"
							data-target="#ModalConfirm" data-backdrop="static"
							data-keyboard="false" id="status" style="width: 210px;"
							class="btn btn-control">CẬP NHẬT GIAO HÀNG</button>
						<button type="submit" name="delete" id="delete"
							onclick="return checkDelete();" style="width: 180px;"
							class="btn btn-control">XÓA ĐƠN HÀNG</button>

					</div>
				</div>
				<jsp:include page="message.jsp"></jsp:include>
				<div class="container-fluid" style="margin-top: 10px;">
					<div class="row">
						<input type="text" class="form-control" readonly="readonly"
							style="display: none;" value="${orderCd}" name="orderCd">
						<div class="col-lg-4">
							<div class="form-group">
								<label class="title-input">KHÁCH HÀNG:</label> <input
									type="text" class="form-control" readonly="readonly"
									value="${customer}" id="customer" name="customer">
							</div>
						</div>
						<div class="col-lg-4">
							<div class="form-group">
								<label class="title-input">SẢN PHẨM ĐẠI DIỆN:</label> <input
									type="text" class="form-control" readonly="readonly"
									value="${production}" id="production" name="production">
							</div>
						</div>
						<div class="col-sm-12 col-md-6 col-lg-4">
							<div class="form-group">
								<label class="title-input">HĐ - PO:</label> <input type="text"
									class="form-control" readonly="readonly" value="${hdpo}"
									id="hdpo" name="hdpo">
							</div>
						</div>
						<div class="col-sm-3 col-md-6 col-lg-4">
							<div class="form-group">
								<label class="title-input">PSX:</label> <input type="text"
									class="form-control" readonly="readonly" value="${psx}"
									name="psx" id="psx">
							</div>
						</div>
						<div class="col-sm-3 col-md-6 col-lg-4">
							<div class="form-group">
								<label class="title-input">NGÀY NHẬN:</label> <input
									readonly="readonly" id="recieveDt" value="${recieveDt}"
									type="text" class="form-control" name="recieveDt">
							</div>
						</div>
						<div class="col-sm-3 col-md-6 col-lg-4">
							<div class="form-group">
								<label class="title-input">NGÀY GIAO KẾ HOẠCH:</label> <input
									type="text" class="form-control" readonly="readonly"
									value="${releaseScheDt}" id="releaseScheDt"
									name="releaseScheDt">
							</div>
						</div>
						<div class="col-sm-3 col-md-6 col-lg-4">
							<div class="form-group">
								<label class="title-input">NGÀY GIAO THỰC TẾ:</label> <input
									type="text" class="form-control" readonly="readonly"
									value="${releaseRealDt}" id="releaseRealDt"
									name="releaseRealDt">
							</div>
						</div>
						<div class="col-sm-12 col-md-12 col-lg-12">
							<div class="form-group">
								<label class="title-input">GHI CHÚ:</label>
								<textarea readonly="readonly"
									style="resize: none; height: 100px; width: 100%" id="note"
									name="note">${note}</textarea>
							</div>
						</div>
						<input type="text" style="display:none;" class="form-control" name="isMode" id="isMode">
						
					</div>
				</div>
		</div>
		<div class="modal fade" id="ModalConfirm" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-sm modal-dialog-centered"
				role="document">
				<div class="modal-content iset3d"
					style="border-radius: 0px; border: 1px solid gray">

					<!-- Modal Header -->
					<div class="modal-header"
						style="height: 40px; background-color: #333399">
						<p class="modal-title"
							style="height: 30px; margin-top: -9px; color: white; font-weight: 700">CHẤP
							NHẬN TRẢ TÀI SẢN</p>
					</div>

					<!-- Modal body -->
					<div class="modal-body">



						<label for="email"
							style="font-weight: 700; text-transform: uppercase;">NGÀY
							GAO HÀNG:</label> <br> <input type="date" id="datePicker"
							class="form-control" name="releaseRealDtPicker"> <br>

						<button type="submit" onsubmit="return checkValud()" name="status"
							style="margin-top: 10px; background-color: #333399"
							"
							class="btn btn-danger">GIAO HÀNG</button>
						<button type="button"
							style="margin-top: 10px; background-color: #333399"
							class="btn btn-danger" data-dismiss="modal">ĐÓNG</button>

					</div>
				</div>
			</div>
		</div>
		</form>
	</div>
	<script type="text/javascript">
		document.getElementById('datePicker').valueAsDate = new Date();
		if ('${isUpdateError}' == '1') {
			document.getElementById("update").style.display = "none";
			document.getElementById("status").style.display = "none";
			document.getElementById("status").style.display = "none";
			document.getElementById("delete").style.display = "none";
			document.getElementById("disUpdate").style.display = "initial";
			document.getElementById("saveUpdate").style.display = "initial";

			document.getElementById("note").readOnly = false;
			document.getElementById("releaseScheDt").readOnly = false;
			document.getElementById("recieveDt").readOnly = false;
			document.getElementById("psx").readOnly = false;
			document.getElementById("hdpo").readOnly = false;
			document.getElementById("production").readOnly = false;
			document.getElementById("customer").readOnly = false;
		}

		function clickUpdate() {
			document.getElementById("update").style.display = "none";
			document.getElementById("status").style.display = "none";
			document.getElementById("status").style.display = "none";
			document.getElementById("delete").style.display = "none";
			document.getElementById("disUpdate").style.display = "initial";
			document.getElementById("saveUpdate").style.display = "initial";

			document.getElementById("note").readOnly = false;
			document.getElementById("releaseScheDt").readOnly = false;
			document.getElementById("recieveDt").readOnly = false;
			document.getElementById("psx").readOnly = false;
			document.getElementById("hdpo").readOnly = false;
			document.getElementById("production").readOnly = false;
			document.getElementById("customer").readOnly = false;

		}
		function clickDisUpdate() {
			document.getElementById("update").style.display = "initial";
			document.getElementById("status").style.display = "initial";
			document.getElementById("status").style.display = "initial";
			document.getElementById("delete").style.display = "initial";
			document.getElementById("disUpdate").style.display = "none";
			document.getElementById("saveUpdate").style.display = "none";

			document.getElementById("note").value = document
					.getElementById("note").defaultValue;
			document.getElementById("releaseScheDt").value = document
					.getElementById("releaseScheDt").defaultValue;
			document.getElementById("recieveDt").value = document
					.getElementById("recieveDt").defaultValue;
			document.getElementById("psx").value = document
					.getElementById("psx").defaultValue;
			document.getElementById("hdpo").value = document
					.getElementById("hdpo").defaultValue;
			document.getElementById("production").value = document
					.getElementById("production").defaultValue;
			document.getElementById("customer").value = document
					.getElementById("customer").defaultValue;

			document.getElementById("note").readOnly = true;
			document.getElementById("releaseScheDt").readOnly = true;
			document.getElementById("recieveDt").readOnly = true;
			document.getElementById("psx").readOnly = true;
			document.getElementById("hdpo").readOnly = true;
			document.getElementById("production").readOnly = true;
			document.getElementById("customer").readOnly = true;

		}
		function checkDelete() {
			if (confirm("BẠN CÓ CHẮC MUỐN XÓA ĐƠN HÀNG ?"))
				return true;
			else
				return false;
		}
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
			document.getElementById("header-sub").style.height = "auto";	
			document.getElementById("update").style.margin = "2px";	
			document.getElementById("status").style.margin = "2px";	
			
			document.getElementById("disUpdate").style.margin = "2px";	
			document.getElementById("saveUpdate").style.margin = "2px";	
			
			document.getElementById("delete").style.margin = "2px";	
			document.getElementById("logoImage").style.height = "68%";	
			document.getElementById("logoImage").style.marginTop = "10px";	
			document.getElementById("header-sub-name").style.fontSize = "2vw";
			
			document.getElementById("isMode").value = "isMobile";
		}
		else
		{
			document.getElementById("isMode").value = "isPC";
		}
		
		</script>	
	
</body>
</html>
