<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="UTF-8">
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
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.fakeimg {
	height: 200px;
	background: #aaa;
}

.header {
	height: 120px;
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
	line-height: 120px;
	padding-left: 10px;
	color: white;
	font-size:50px
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
	font-size:30px;
	background: #333399;
	color: white;
	border: 4px solid black;
}

.table-display tbody tr td {
	font-size: 25px;
	font-weight: bold !important;
	padding: 5px;
	font-size:30px;
	border: 2px solid black;
}
.table-display thead
{
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

.btn-paging {
	padding: 0px;
	line-height: 30px;
	background-color: #bdc6e2;
	border-radius: 0;
	width: 30px;
	height: 30px
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

.out-date {
	background-color: #AB0A24;
	border-radius: 10px;
	font-weight: 700;
	text-align: center;
	font-size: 23px;
	line-height: 37px;
	color: white;
	text-transform: uppercase;
	height: 37px;
}

.ok-date {
	background-color: green;
	border-radius: 10px;
	font-weight: 700;
	text-align: center;
	font-size: 23px;
	line-height: 37px;
	text-transform: uppercase;
	height: 37px;
	color: white;
}

.warning-ok-date {
	background-color: orange;
	border-radius: 10px;
	font-weight: 700;
	text-align: center;
	font-size: 23px;
	line-height: 37px;
	text-transform: uppercase;
	height: 37px;
	color: black;
}
*{
     font-family: 'Inter', sans-serif;
     font-weight: bold !important;
 }
.warning-date {
	background-color: yellow;
	border-radius: 10px;
	font-weight: 700;
	text-align: center;
	font-size: 20px;
	text-transform: uppercase;
	line-height: 37px;
	color:red;
	height: 37px;
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
<body id="bodyContent" onload="startTime();Pagination();">
	<div class="header" id="header">
	<div style="width:fit-content; margin:auto">
		<img id="image-logo" src="./resources/images/logonm.jpg" style="height: 100px; margin:auto; margin-top:10px">
		<h1 class="company-name" id="company-name">CÔNG TY TNHH SẢN XUẤT - THƯƠNG MẠI NGỌC MINH</h1>
		
		</div>
		<div onclick="showMenu()" class="pagging-area"
			style="cursor: pointer; float: right; line-height: 80px; padding-right: 10px; margin-top: 10px;">
			<img id="image-menu" src="./resources/images/menu-display-icon.png"
				style="height: 80px">
		</div>
			
	
	</div>
	<div style="padding: 10px;">
		<form action="ProductionDisplay" id="ProductionDisplay" method="POST" style="display: none;">
			<input name="pageCurrent" id="pageCurrent"/>
		</form>
		<div class="title-display-view" style="padding-top:0px;">
			<h1 class="title-table" id="tableName" style="font-size: 55px; width: 100%; display: table;">BẢNG THEO DÕI SẢN XUẤT</h1>
			<table style="width: 100%" id="tableTimeComputer">
				<tbody style="width: 100%">
					<tr>
						<td class="item" style="width: 20%;">
							<div id="txt"
								style="width: 310px; height: 100%; padding-top:3px; font-size:45px;  padding-left: 10px; padding-right: 10px; background-color: #AB0A24; color:white; border-radius: 10px; text-align: center;">
								THỜI GIAN: 20:03</div>
						</td>
						<td class="item" style="width: 60%; text-align: center;">
							<div id="ngay"
								style="width: 700px; height: 100%; font-size:45px;  background-color: #AB0A24; color:white; border-radius: 10px; margin: auto;">
								NGÀY 03 THÁNG 12 NĂM 2020</div>
						</td>
						<td style="width: 20%">
							<!-- 							<div class="pagging-area" style="float: right;"> -->
							<!-- 								<img style="width: 50px; float: left; padding: 5px;" -->
							<!-- 									src="images/pre.png"> --> <!-- 								<div --> <!-- 									style="float: left; font-weight: 700; font-size: 25px; line-height: 35px">20/30</div> -->
							<!-- 								<img style="width: 50px; float: left; padding: 5px;" -->
							<!-- 									src="images/next.png"> --> <!-- 							</div> -->
						</td>
					</tr>
				</tbody>
			</table>
			
			<table style="width: 100%" id="tableTimeMobile">
				<tbody style="width: 100%">
					<tr>
						<td class="item" style="width: 20%;">
							<div id="txtMobile"
								style="width: 280px; margin:auto; height:62px; padding-top:5px; padding-left: 10px; padding-right: 10px; background-color: orange; border-radius: 10px; text-align: center;">
								THỜI GIAN: 20:03</div>
						</td>
						</tr>
						<tr>
						<td class="item" style="width: 60%; text-align: center;">
							<div id="ngayMobile"
								style="width:100%;  height: 100%; background-color: orange; border-radius: 10px; margin: auto;">
								NGÀY 03 THÁNG 12 NĂM 2020</div>
						</td>
						
					</tr>
				</tbody>
			</table>
		</div>

		<%-- 		<jsp:include page="message.jsp"></jsp:include> --%>
		<c:if test="${lst.size() > 0}">
			<div class="table-area" id="table-computer" style="padding-bottom:5px;">
				<table id="table.data" class="table-display table table-bordered" style="margin-bottom:5px;">
					<thead>
						<tr>
							<th rowspan="2" style="border-top: 4px solid black; width: 80px; border-right:4px solid white;">STT</th>
							<th rowspan="2" style="border-top: 4px solid black; border-right:4px solid white; border-left: 4px solid white;">KHÁCH HÀNG</th>
							<th rowspan="2" style="border-top: 4px solid black; border-right:4px solid white; border-left: 4px solid white;">SẢN PHẨM ĐẠI DIỆN</th>
							<th colspan="2" style="border-top: 4px solid black; border-right:4px solid white; border-left: 4px solid white; border-bottom:4px solid white;">ĐƠN HÀNG</th>
							<th colspan="2" style="border-top: 4px solid black; border-right:4px solid white; border-left: 4px solid white; border-bottom:4px solid white;">NGÀY</th>
							<th rowspan="2" style="border-top: 4px solid black; border-right:4px solid black;">GHI CHÚ</th>
						</tr>
						<tr>
							<th style="border-top:4px solid white; border-right:4px solid white; border-left: 4px solid white;">HĐ,PO</th>
							<th style="border-top:4px solid white;border-right:4px solid white; border-left: 4px solid white;">PSX</th>
							<th style="border-top:4px solid white;border-right:4px solid white; border-left: 4px solid white;">NHẬN</th>
							<th style="border-top:4px solid white;border-right:4px solid white; border-left: 4px solid white;">GIAO</th>
						</tr>
					</thead>
					<tbody>
						<%
							int stt = 1;
						%>
						<c:forEach var="p" items="${lst}">
							<tr style="color:#333399">
								<td style="text-align: center;"><%=stt%></td>
								<td style=" overflow: hidden;"><input type="text" style="width:100%; height:40px; border: 0px;" readonly="readonly" value="${p.getCustomerName()}"></td>
								<td style=" overflow: hidden;"><input type="text"  style="width:100%; height:40px; border: 0px;" readonly="readonly" value="${p.getProduction()}"></td>
								<td style="text-align: center; width:250px;">${p.getHD_PO()}</td>
								<td style="text-align: center; width:120px">${p.getPSX()}</td>
								<td style="text-align: center;">${p.getRecieveDt()}</td>
								<td style="text-align: center;">${p.getReleaseScheDt()}</td>
								<td style="width: 350px"><c:if
										test="${p.getStatus() == '0'}">
									</c:if> <c:if test="${p.getStatus() == '1'}">
										<div class="ok-date">ĐÃ GIAO</div>
									</c:if> <c:if test="${p.getStatus() == '2'}">
										<div class="warning-date" style="width: 336px; height: 40px;line-height: 40px; font-size: 25px;">ĐƠN HÀNG ĐẾN HẠN GIAO</div>
									</c:if> <c:if test="${p.getStatus() == '3'}">
										<div class="warning-ok-date">GIAO TRỄ</div>
									</c:if> <c:if test="${p.getStatus() == '4'}">
										<div class="out-date" style="width: 336px; height:40px;line-height: 40px; font-size: 25px;">ĐƠN HÀNG ĐÃ BỊ TRỄ</div>
									</c:if></td>
							</tr>
							<%
								stt++;
							%>
						</c:forEach>


					</tbody>
				</table>
				<div class="text-right" style="margin-top: 10px;">
					<%
						if (stt > 10) {
								double countPage = stt / 10;
								if (stt % 10 > 0) {
									countPage += 1;
								}
								int j = 1;
								while (j <= countPage) {
									int startIndex = j * 10 - 8;
									int endIndex = startIndex + 10;
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
			<td class="item" style="width: 60%; text-align: center;">
				<div id="noteUser"
					style="margin-top:5px; width: fit-content; height: 100%; background-color: yellow; margin:auto; font-size:40px; border-radius: 10px; padding-left: 10px; padding-right: 10px;">
					<span style=" font-weight: 700">GHI CHÚ: </span><span
						style=" font-weight: 700; color: red">PHÒNG SẢN XUẤT - KINH DOANH
						THEO DÕI ĐỂ THỰC HIỆN ĐÚNG TIẾN ĐỘ</span>
				</div>
			</td>
		</c:if>


		
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
							<div class="head"
								style=" border-radius: 0px; margin-top: 5px;">
								<c:if test="${p.getStatus() == '0'}">
								</c:if>
								<c:if test="${p.getStatus() == '1'}">
									<div style="border-radius:0px" class="ok-date">ĐÃ GIAO</div>
								</c:if>
								<c:if test="${p.getStatus() == '2'}">
									<div style="border-radius:0px" class="warning-date">ĐƠN HÀNG ĐẾN HẠN</div>
								</c:if>
								<c:if test="${p.getStatus() == '3'}">
									<div style="border-radius:0px" class="warning-ok-date">GIAO TRỄ</div>
								</c:if>
								<c:if test="${p.getStatus() == '4'}">
									<div style="border-radius:0px" class="out-date">ĐƠN HÀNG ĐÃ BỊ TRỄ</div>
								</c:if>
							</div>
						</div>
					</div>
					</c:forEach>
				</div>
			</div>
	</div>

	<div class="panel-menu" id="menu-right"
		style="transition: 0.5s; width: 0%;">
		<div style="width: 300px; cursor: pointer; display: block;"
			onclick="hideMenu()">
			<img src="./resources/images/arrow-back.png" width="50px"
				style="margin: 5px;">
			<p
				style="font-weight: 700; font-size: 25px; color: white; line-height: 50px; padding-left: 10px;">
				TRỞ VỀ</p>
		</div>
		<div style="width: 300px; display: block;">
			<a href="Clock" class="item-menu">KHÓA MÀN HÌNH</a> <a href="login"
				class="item-menu">ĐĂNG NHẬP</a>
		</div>
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
//			document.getElementById("table-computer").style.display = "none";
//			document.getElementById("company-name").style.fontSize = "2vw";
//			document.getElementById("noteUser").style.fontSize = "3vw";
//			document.getElementById("noteUser").style.textAlign = "center";
//			document.getElementById("tableName").style.fontSize = "6vw";
//			document.getElementById("tableTimeComputer").style.display = "none";
//			document.getElementById("header").style.height = "70px";
//			document.getElementById("image-logo").style.height = "70px";
//			document.getElementById("company-name").style.lineHeight = "70px";
//			document.getElementById("image-menu").style.height = "40px";
		
		document.body.style.width = "2040px";
		document.getElementById("tableMobile").style.display = "none";
		document.getElementById("tableTimeMobile").style.display = "none";
	}
	else
	{
		document.getElementById("tableMobile").style.display = "none";
		document.getElementById("tableTimeMobile").style.display = "none";
	}
		function hideMenu() {
			document.getElementById("menu-right").style.width = "0%";
		}
		function showMenu() {
			document.getElementById("menu-right").style.width = "300px";
		}
		function startTime() {
			var today = new Date();
			var h = today.getHours();
			var m = today.getMinutes();
			var s = today.getSeconds();
			m = checkTime(m);
			s = checkTime(s);
			
			h = h+ "";
			
			var ns = h.length;
			if(ns ==1 )
			{
			   h = "0"+h;
			}
			
			document.getElementById('txt').innerHTML = "<i class='fa fa-clock-o' style='font-size: 50px; margin-right:5px; color:white' aria-hidden='true'></i>" +"  "+ h + ":"
					+ m + ":" + s;
			document.getElementById('txtMobile').innerHTML = "" + h + ":"
			+ m + ":" + s;
			var t = setTimeout(startTime, 500);

			var day = today.getDate();
			var month = today.getMonth() + 1;
			var year = today.getFullYear();
			document.getElementById('ngay').innerHTML = "NGÀY " + day
					+ " THÁNG " + month + " NĂM " + year;
			document.getElementById('ngayMobile').innerHTML = "NGÀY " + day
			+ " THÁNG " + month + " NĂM " + year;

		}
		function checkTime(i) {
			if (i < 10) {
				i = "0" + i
			}
			; // add zero in front of numbers < 10
			return i;
		}
		//Hàm click button chuyển trang
		function movePage(start, end, indexCurrent, countPage) {
			var x = document.getElementById("table.data").rows.length;
			for (var i = 2; i < x; i++) {
				var index = i;
				if (i >= start && i < end) {
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
			x.click();
// 			x = document.getElementById("table.data").rows.length;
// 			if (x > 10) {
// 				for (var i = 11; i < x; i++) {
// 					document.getElementById("table.data").rows[i + 1].style.display = 'none';
// 				}

// 			}
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

		if(parseInt(getBrowserSize().width) < 1500){
// 			document.getElementById("table-computer").style.display = "none";
// 			document.getElementById("company-name").style.fontSize = "2vw";
// 			document.getElementById("noteUser").style.fontSize = "3vw";
// 			document.getElementById("noteUser").style.textAlign = "center";
// 			document.getElementById("tableName").style.fontSize = "6vw";
// 			document.getElementById("tableTimeComputer").style.display = "none";
// 			document.getElementById("header").style.height = "70px";
// 			document.getElementById("image-logo").style.height = "70px";
// 			document.getElementById("company-name").style.lineHeight = "70px";
// 			document.getElementById("image-menu").style.height = "40px";
			
			document.getElementById("bodyContent").style.width = "2040px";
			document.getElementById("tableMobile").style.display = "none";
			document.getElementById("tableTimeMobile").style.display = "none";
		}
		else
		{
			document.getElementById("tableMobile").style.display = "none";
			document.getElementById("tableTimeMobile").style.display = "none";
		}
		var loadPage = setInterval(
			
			function() {
              var newCount=0;
                $
                    .ajax({
                        type: 'GET',
                        url: 'http://'+window.location.hostname+':8080/ngocminh.tracking/getCount',
                        success: function(
                            result) {
                        	newCount = result;
                        	if(newCount == "1")
                            {
                          		document.getElementById("pageCurrent").value=indexButton;
                				document.getElementById("ProductionDisplay").submit();
                            }	
                        },
                        error: function(
                            request,
                            status, error) {
                        }

                    });
              
			}, ${load});
		var indexButton = ${pageCurrent};
		var x = setInterval(function() {
				var idButton = 'pagging.btn' + indexButton;
				if(document.getElementById(idButton) !== null)
				{
					document.getElementById(idButton).click();
					indexButton = indexButton+1;
				}
				else
				{
					indexButton = 1;
					idButton = pagging.btn + indexButton + '';
					if(document.getElementById(idButton) !== null)
					{				
						document.getElementById(idButton).click();	
					}
					
				}
			}, ${interval});
	
		
		
		
	</script>
</body>
</html>
