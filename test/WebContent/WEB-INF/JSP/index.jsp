<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*" %>
    <%@page session="true" %>
    <%@page buffer="16kb" %>
    <%@page autoFlush="true" %>
    <%@page isThreadSafe="true" %>
        <%@ page import="java.io.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>Main page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-responsive.min.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 20px;
        padding-bottom: 60px;
      }
      /* Custom container */
      .container {
        margin: 0 auto;
        max-width: 1000px;
      }
      .container > hr {
       margin: 60px 0;
      }

      /* Main marketing message and sign up button */
/* Carousel */
.carousel {
      margin-bottom: 60px;
    }
    .carousel .container {
      position: relative;
      z-index: 9;
    }
    .carousel-control {
      height: 80px;
      margin-top: 0;
      font-size: 120px;
      text-shadow: 0 1px 1px rgba(0,0,0,.4);
      background-color: transparent;
      border: 0;
      z-index: 10;
    }
    .carousel .item {
      height: 500px;
    }
    .carousel img {
      position: absolute;
      top: 0;
      left: 0;
      min-width: 100%;
      height: 500px;
    }
    .carousel-caption {
      background-color: transparent;
      position: static;
      max-width: 550px;
      padding: 0 20px;
      margin-top: 200px;
    }
    .carousel-caption h1,
    .carousel-caption .lead {
      margin: 0;
      line-height: 1.25;
      color: #fff;
      text-shadow: 0 1px 1px rgba(0,0,0,.4);
    }
    .carousel-caption .btn {
      margin-top: 10px;
    }
/* Carousel End */
      .jumbotron .lead {
        font-size: 24px;
        line-height: 1.25;
      }
      .jumbotron .btn {
        font-size: 21px;
        padding: 14px 24px;
      }
      /* Supporting marketing content */
      .marketing {
        margin: 60px 0;
      }
      .marketing p + h4 {
        margin-top: 28px;
     }
      /* Customize the navbar links to be fill the entire space of the .navbar */
      .navbar .navbar-inner {
       padding: 0;
      }
      .navbar .nav {
        margin: 0;
        display: table;
        width: 100%;
    
      }
      .navbar .nav li {
        display: table-cell;
        width: 1%;
        float: none;
      }
      .navbar .nav li a {
        font-weight: bold;
        text-align: center;
        border-left: 1px solid rgba(255,255,255,.75);
        border-right: 1px solid rgba(0,0,0,.1);
      }
     .navbar .nav li:first-child a {
        border-left: 0;
        border-radius: 3px 0 0 3px;
      }
      .navbar .nav li:last-child a {
        border-right: 0;
        border-radius: 0 3px 3px 0;
      }
    </style>
  </head>


  <body>
  <jsp:useBean id="index" scope="page" class="boot.index" />
<jsp:setProperty property="*" name="index"/>
    <div class="container">
      <div class="masthead">
        <div class="navbar">
    <div class="navbar-inner navbar-fixed-top">
            <div class="container">              
        <ul class="nav">
                            <li><a href="#"><i class="icon-search"></i>Search</a></li>
                            <li><a href="mainpage.html"><i class="icon-home"></i></a></li>
                            <li><a href="concernRecommendPage.html"><i class="icon-star"></i></a></li>
                            <li><a href="mainpage.html">SCABTRS</a></li>
                            <li><a href="mypage.html"><i class="icon-user"></i></a></li>
                            <li><a href="writepage.html"><i class="icon-pencil"></i></a></li>
                            <li><a href="#"><i class="icon-gift"></i></a></li>
                            <li><a href="#"><i class="icon-align-justify"></i></a></li>
              </ul>
            </div>
          </div>
</div>
<!-- /.navbar -->
<!-- /Carousel area -->
      </div>
      <div id="myCarousel" class="carousel slide">
      <div class="carousel-inner">

        <div class="item active">
          <img src="http://postfiles9.naver.net/20150705_40/kyg91kr_1436087630847ASvHG_JPEG/2015_07_05_-_%C8%AB%B8%AA%BC%F6%B8%F1%BF%F8017.jpg?type=w1" alt="">
          <div class="container">
            <div class="carousel-caption">
              <h1>test Picture1</h1>
              <p class="lead">test picture</p>
            </div>
          </div>
        </div>

        <div class="item">
          <img src="http://postfiles12.naver.net/20141224_75/kyg91kr_1419407677824VXD1f_JPEG/20141223-IMG_0106.jpg?type=w1" alt="">
          <div class="container">
            <div class="carousel-caption">
              <h1>Example picture2</h1>
              <p class="lead">test picture</p>
            </div>
          </div>
        </div>

        <div class="item">
          <img src="http://postfiles7.naver.net/20150106_262/kyg91kr_1420552730089rgoFA_JPEG/20150101-IMG_0082.jpg?type=w1" alt="">
          <div class="container">
            <div class="carousel-caption">
              <h1>Example picture3</h1>
              <p class="lead">test picture</p>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
      <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
    </div>

<!-- Category -->
<div class="accordion" id="accordion2">
  <div class="accordion-group">
    <div class="accordion-heading">
      <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
        Locaton Category
      </a>
    </div>
    <div id="collapseOne" class="accordion-body collapse">
      <div class="accordion-inner raw-fluid">     
    <div class="span2">
    <input type="checkbox" name=location value="seoul"> Seoul
    </div>
    <div class="span2">
    <input type="checkbox" name=location value="seoul"> Kyonggi
    </div>
<div class="span2">
    <input type="checkbox" name=location value="seoul"> Chungcheong
    </div>
<div class="span2">
    <input type="checkbox" name=location value="seoul"> Gyeongsang
    </div>
<div class="span2">
    <input type="checkbox" name=location value="seoul"> Gangwon
    </div>
<div class="span2">
    <input type="checkbox" name=location value="seoul"> Jeolla
    </div>
      </div>
    </div>
  </div>
</div>

<!-- category -->

<div class="row-fluid">
<div class="span12">
<div class="btn-group pull-right" data-toggle="buttons-radio">
  <button type="button" class="btn">New</button>
  <button type="button" class="btn">Like</button>
  <button type="button" class="btn">Comment</button>
</div>
</div>
</div>

      <!-- Example row of columns -->
      <div class="row-fluid">
        <div class="span4">
        <a href="../examples/boardpage.html">
          <h2>Title1</h2>
<img src="http://postfiles4.naver.net/20150826_83/kyg91kr_1440566079199QOczh_JPEG/IMG_0157-1-1.jpg?type=w1" class="img-polaroid" >
          <p>text</p>
          <p><a class="active pull-right" href="#"><i class="icon-comment"></i></a>
             <a class="active pull-right" href="#"><i class="icon-heart"></i></a>
      </p> 
    </a>
        </div>

        <div class="span4">
          <h2>Title2</h2>
<img src="http://postfiles13.naver.net/20140706_268/kyg91kr_1404646724295B8yOE_JPEG/20140706-IMG_9454%28%BF%F6%29.jpg?type=w1" class="img-polaroid">
          <p>text</p>
          <p><a class="active pull-right" href="#"><i class="icon-comment"></i></a>
             <a class="active pull-right" href="#"><i class="icon-heart"></i></a>
      </p>
       </div>

        <div class="span4">
          <h2>Title3</h2>
<img src="http://postfiles12.naver.net/20140520_283/kyg91kr_1400558240969EagLv_JPEG/20140518-IMG_8651%28%BF%F6%C5%CD%B8%B6%C5%A9%29.jpg?type=w1" class="img-polaroid">
          <p>text</p>
          <p><a class="active pull-right" href="#"><i class="icon-comment"></i></a>
             <a class="active pull-right" href="#"><i class="icon-heart"></i></a>
      </p>
        </div>

      </div>
<div class="pagination pull-right">
  <ul>
    <li><a href="#">Prev</a></li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li><a href="#">Next</a></li>
  </ul>
</div>
<br>
      <hr>
      <div class="footer">
        <p>Social Context Awareness Based Travel Recommendation System</p>
      </div>
    </div> 

    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
