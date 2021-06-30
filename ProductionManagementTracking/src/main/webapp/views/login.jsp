<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
  <title>ĐĂNG NHẬP</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <style>
  .fakeimg {
    height: 200px;
    background: #aaa;
  }
  .header
  {
    height:60px;
    width:100%;
    background: #333399;
  }
  .title-display-view
  {
    padding-top: 10px;
    padding-bottom: 10px;
  }
  img
  {
    float: left;
  }
  .company-name
  {
    float: left; 
    line-height: 60px;
    padding-left: 10px;
    color: white;
  }
  .title-table
  {
    text-align: center;
    color: #333399;
  }
    .panel-menu
  {
    height: 100%;
    background: #333399;
    z-index: 999999;
    position: fixed;
    top:0;
    right: 0;
    width: 300px;
    transition: 2s;
    box-shadow: 0 2px 5px 0 rgba(0,0,0,0.16), 0 2px 10px 0 rgba(0,0,0,0.12);
  }
  .panel-menu .item-menu
  {
    color: white;
    display: block;
    width:300px;
    background-color: #ff6666;
    font-weight: 700;
    height: 45px;
    margin-top:5px;
    text-align: center;
    vertical-align: middle;
    line-height: 45px;
    text-decoration: none;
  }
  .panel-menu .item-menu:hover
  {
    background-color: #ffe6e6;
    color:#ff6666;
  }
  .pin-form
  {
    width: 700px;
    padding-left: 20px;
    padding-right: 20px;
    position: fixed;
    background-color: rgba(209, 209, 224,0.7);
    padding-top: 20px;
    height: 320px;
    margin:auto;
    top: 50%;
    left: 50%;
    margin-top: -140px; /* Negative half of height. */
    margin-left: -350px; /* Negative half of width. */

  }
  *{
     font-family: 'Inter', sans-serif;
     font-weight: bold !important;
 }

  </style>
</head>
<body>
<div class="header">
   <img src="./resources/images/logonm.jpg" style="height: 90%; margin-top: 3px; margin-left: 10px">
   <h1 class="company-name" id="company-name">CÔNG TY TNHH SẢN XUẤT - THƯƠNG MẠI NGỌC MINH</h1> 
    <div onclick="showMenu()" class="pagging-area" style="cursor:pointer; float: right; line-height: 80px; padding-right:10px; margin-top:10px;">
       <img src="./resources/images/menu-display-icon.png" style="height: 40px">
   </div>
</div>
<div style="padding:10px;">
<div class="title-display-view">
 <h1 class="title-table" id="title-table" >PRODUCTION MANAGEMENT TRACKING</h1>
 <img src="./resources/images/product2.png" style="height:1000px; width: 100%; margin-top:40px;">
 <div class="pin-form" id="pin-form">
  <form action="login" method="POST">
    <div class="form-group">
    <label for="pwd" style="font-size: 20px; font-weight: 700; text-align: center;">Tên đăng nhập</label>
    <input type="text" id="usn" name="usn" style="font-size: 25px; border-radius: 0px; height: 45px;" class="form-control" placeholder="Tên đăng nhập" id="usn">
  </div>
  <div class="form-group">
    <label for="pwd" style="font-size: 20px; font-weight: 700; text-align: center;">Mật khẩu</label>
    <input type="password" name="pass" style="font-size: 25px; border-radius: 0px; height: 45px;" class="form-control" placeholder="Mật khẩu" id="pwd">
  </div>
  <jsp:include page="message.jsp"></jsp:include>
  <button type="submit" class="btn btn-primary" style="width:150px; border-radius: 0px; margin: auto;">ĐĂNG NHẬP</button>
</form>
 </div>

</div>
 <div class="panel-menu" id="menu-right" style="transition: 0.5s; width:0%">
  <div style="width:100%; cursor: pointer; display: block;" onclick="hideMenu()">
  <img src="./resources/images/arrow-back.png" width="50px" style="margin: 5px;"><p style="font-weight: 700; font-size: 25px; color: white; line-height: 50px; padding-left:10px;"> TRỞ VỀ</p>
</div>
<div style="width:100%;; display: block;">
  <a href="ProductionDisplay" class="item-menu">BẢNG HIỂN THỊ</a>
</div>
</div>

<script type="text/javascript">
document.getElementById("usn").focus();
  function hideMenu()
  {
	document.getElementById("menu-right").style.width = "0%";
  }
  function showMenu()
  {
	  document.getElementById("menu-right").style.width = "300px";
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
		document.getElementById("title-table").style.fontSize = "4vw";
		document.getElementById("pin-form").style.left = "-1px";
		document.getElementById("pin-form").style.width = "100%";
		document.getElementById("pin-form").style.marginLeft = "auto";
		
	}
</script>

</body>
</html>
