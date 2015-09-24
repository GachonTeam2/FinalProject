<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My page : project name or web title</title>
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
            margin: 60px 0;
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
            <div class="raw-fluid">
                <!-- profile -->
                <div class="span1 pull-left">
                    <img src="../assets/img/examples/ibdxkw9g3wkjklk5pftx.jpg" class="img-polaroid">

                </div>
                <div class="span7 pull-left">
                    <dl>
                        <dt>User ID</dt>
                        <dd>User Introduction</dd>
                    </dl>
                </div>
                <!-- modal on/off -->
                <div class="span2 pull-right"><br>
                    <a href="#myModal" role="button" class="btn" data-toggle="modal"><i class="icon-user"></i> Add frieds</a>
                </div>
            
            </div>
            <hr>
            <!-- category -->
            <div class="accordion" id="accordion2">
                <div class="accordion-group">
                    <div class="accordion-heading">
                        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
                        My Category</a>
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
            <div class="row-fluid">
                <div class="span4">
                    <h2>Title1</h2>
                    <img src="http://postfiles10.naver.net/20140601_233/kyg91kr_1401549997150z6tAI_JPEG/20140226-IMG_7413%28%BF%F6%29.jpg?type=w1" class="img-polaroid">
                    <p>text</p>
                    <p><a class="active pull-right" href="#"><i class="icon-comment"></i></a>
                    <a class="active pull-right" href="#"><i class="icon-heart"></i></a></p> 
                </div>
                <div class="span4">
                    <h2>Title2</h2>
                    <img src="http://postfiles9.naver.net/20140806_120/kyg91kr_1407255098613DtUCQ_JPEG/IMG_0090%28%BF%F6%29.jpg?type=w1" class="img-polaroid">
                    <p>text</p>
                    <p><a class="active pull-right" href="#"><i class="icon-comment"></i></a>
                    <a class="active pull-right" href="#"><i class="icon-heart"></i></a></p>
                </div>
                <div class="span4">
                    <h2>Title3</h2>
                    <img src="http://postfiles2.naver.net/20140602_193/kyg91kr_1401638420461SSi9L_JPEG/20140601-IMG_8913%28%BF%F6%29.jpg?type=w1" class="img-polaroid">
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
            </div>
            <br>
            <hr>
            
        </div>
        <!-- modal -->
        <div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-header">
                <h3 id="myModalLabel">Add frieds</h3>
            </div>
            <div class="modal-body">
                <p>friends list</p>
            </div>
            <div class="modal-footer">
                <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
                <button class="btn btn-primary">Save</button>
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