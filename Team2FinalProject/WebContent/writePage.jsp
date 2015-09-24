<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Write page : porject name or web title</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- Le styles -->
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
            margin: 60px 0;
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
    .textwidth{
    width:500px;
    }

    .textheight{
    height:50px;
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
                    <div class="span10 offset2">
                        <select class="span2">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                        <br>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="raw-fluid">
                    <div class="span10 offset2">
                        <input class="textwidth textheight" type="text" placeholder="Title">
                    <br>
                    </div>
                </div>
            </div>

            <br>

            <div class="container-fluid">
                <div class="row-fluid">
                    <div class="span2">
                        <div class="accordion" id="accordion2">
                            <div class="accordion-group">
                                <div class="accordion-heading">
                                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
                                    <h2>+</h2></a>
                                </div>
                                <div id="collapseOne" class="accordion-body collapse">
                                    <div class="accordion-inner raw-fluid">     
                                        <a class="btn btn-large" href="#"><i class="icon-picture"></i></a><br><br>
                                        <a class="btn btn-large" href="#"><i class="icon-map-marker"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="span7">
                        <textarea class="textwidth" rows="10"></textarea>
                    </div>
                    <div class="span1">
                        <button class="btn" type="button"><i class="icon-trash"></i></button>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="raw-fluid">
                    <div class="span10 offset5">                    
                        <button class="btn btn-large align-center" type="button">+</button>
                    </div>
                </div>
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