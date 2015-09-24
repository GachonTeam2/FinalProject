<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>concern recommend page : porject name or web title</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <link href="../assets/css/bootstrap.css" rel="stylesheet">
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
            margin: 30px 0;
            }

            .picture{
            max-width:64px;
            max-height:64px;
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
            
            .category{
            height: 120px;
            text-align:center;
            ]

            .categoryhead{
            align:center;
            }

            <script src="../assets/js/html5shiv.js"></script>
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
                            <li><a href="../examples/mainpage.html"><i class="icon-home"></i></a></li>
                            <li><a href="../examples/concernRecommendPage.html"><i class="icon-star"></i></a></li>
                            <li><a href="../examples/mainpage.html">SCABTRS</a></li>
                            <li><a href="../examples/mypage.html"><i class="icon-user"></i></a></li>
                            <li><a href="../examples/writepage.html"><i class="icon-pencil"></i></a></li>
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
                        <img src="../assets/img/examples/a.jpg" class="img-rounded">
                        Drive
                    </div>
    
                        <div class="category span2">
                        <img src="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcREg7HWY4UlCUhhhahcXjHadjJoyOqI4pmq-Rtf__qdXfIz-5BVHEZ5kBM" class="img-rounded">
                        Camping
                    </div>
        
                    <div class="category span2">
                        <img src="../assets/img/examples/c.jpg" class="img-rounded">
                        Leisure sports
                    </div>
    
                    <div class="category span2">
                        <img src="../assets/img/examples/d.jpg" class="img-rounded">
                        History
                    </div>
        
                    <div class="category span2">
                        <img src="../assets/img/examples/e.jpg" class="img-rounded">
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
    <script src="../assets/js/jquery.js"></script>
    <script src="../assets/js/bootstrap-transition.js"></script>
    <script src="../assets/js/bootstrap-alert.js"></script>
    <script src="../assets/js/bootstrap-modal.js"></script>
    <script src="../assets/js/bootstrap-dropdown.js"></script>
    <script src="../assets/js/bootstrap-scrollspy.js"></script>
    <script src="../assets/js/bootstrap-tab.js"></script>
    <script src="../assets/js/bootstrap-tooltip.js"></script>
    <script src="../assets/js/bootstrap-popover.js"></script>
    <script src="../assets/js/bootstrap-button.js"></script>
    <script src="../assets/js/bootstrap-collapse.js"></script>
    <script src="../assets/js/bootstrap-carousel.js"></script>
    <script src="../assets/js/bootstrap-typeahead.js"></script>
    </body>
</html>