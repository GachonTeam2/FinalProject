<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.io.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.http.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>ConcernRecommend Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-responsive.min.css" rel="stylesheet">
    <style type="text/css">
        body {
        width:100%;
        height:100%;
        padding-top: 20px;
        padding-bottom: 60px;
        }
        
        .container {
        margin: 0 auto;
        max-width: 1000px;
        }

        .container > hr {
        margin: 20px 0;
        }
            .picture{
        max-width:64px;
        max-height:64px;
        }

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

        .bpicture{
        margin: 0 auto;
        width:640px;
        }

        .btnmargin{
        margin-left:150px;
        }
        
        .jumbotron {
        margin: 40px 0;
        text-align: center;
        }
                
        .jumbotron h1 {
        font-size: 100px;
        line-height: 1;
        }
        
        </style>
  </head>
    <body>
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
            </div>
            <br>

 
            <div class="container">
                <div class="raw-fluid">
                    <div class="category span2">
                        <img src="img/a.jpg" class="img-rounded">
                        Drive
                    </div>
    
                        <div class="category span2">
                        <img src="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcREg7HWY4UlCUhhhahcXjHadjJoyOqI4pmq-Rtf__qdXfIz-5BVHEZ5kBM" class="img-rounded">
                        Camping
                    </div>
        
                    <div class="category span2">
                        <img src="img/c.jpg" class="img-rounded">
                        Leisure sports
                    </div>
    
                    <div class="category span2">
                        <img src="img/d.jpg" class="img-rounded">
                        History
                    </div>
        
                    <div class="category span2">
                        <img src="img/e.jpg" class="img-rounded">
                        Backpacking
                    </div>
                    <div class="span2"></div>
                </div>
            </div>
            <hr>
            <div class="row-fluid">
                    <div class="span4">
                    <h2>Title1</h2>
                    <img src="http://postfiles8.naver.net/20150826_151/kyg91kr_1440597935807lI0WG_JPEG/IMG_0181-1-1.jpg?type=w1" class="img-polaroid">
                        <p>text</p>
                        <p><a class="active pull-right" href="#"><i class="icon-comment"></i></a>
                    <a class="active pull-right" href="#"><i class="icon-heart"></i></a></p> 
                    </div>
                    <div class="span4">
                        <h2>Title2</h2>
                    <img src="http://postfiles16.naver.net/20150827_47/kyg91kr_144068657394377TuD_JPEG/IMG_0167-1-1.jpg?type=w1" class="img-polaroid">
                        <p>text</p>
                    <p><a class="active pull-right" href="#"><i class="icon-comment"></i></a>
                       <a class="active pull-right" href="#"><i class="icon-heart"></i></a></p>
                </div>
                    <div class="span4">
                    <h2>Title3</h2>
                    <img src="http://postfiles6.naver.net/20150826_133/kyg91kr_1440564337490jpvF6_JPEG/IMG_0094-1-1.jpg?type=w1" class="img-polaroid">
                        <p>text</p>
                    <p><a class="active pull-right" href="#"><i class="icon-comment"></i></a>
                           <a class="active pull-right" href="#"><i class="icon-heart"></i></a></p>
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
                <br>
            </div>
        </div>
            <div class="container">
            <hr>
            <div class="footer">
                    <p>Social Context Awareness Based Travel Recommendation System</p>
            </div>
        </div> 
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    </body>
</html>