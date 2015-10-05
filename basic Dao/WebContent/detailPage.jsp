<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail page : porject name or web title</title>
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
            margin: 20px 0;
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

            .jumbotron {
                margin: 40px 0;
                text-align: center;
                }
                
            .jumbotron h1 {
                font-size: 100px;
                line-height: 1;
            }
            
            .bpicture{
            margin: 0 auto;
            width:640px;
            }

            .btnmargin{
            margin-left:150px;
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
                <div class="jumbotron">
                    <h1>Title</h1>
                </div>
            </div>
            <!-- category -->
            <div class="container">
                <div class="bpicture">
                    <img src="../assets/img/examples/20140314-IMG_7974.jpg" class="img-polaroid">           
                </div>
                <div class="bpicture">
                    <br>Eungbongsan (Seoul) is a mountain of South Korea. It has an elevation of 81 metres<br><br>
                </div>
            </div>

            <div class="container">
                <div class="raw-fluid">
                    <div class="btnmargin span3">
                        <button class="btn" type="button"><i class="icon-heart"></i> Like</button>
                    </div>
                    <div class="span2 pull-right">
                        <dl>
                            <dt>User ID</dt>
                            <dd>User Introduction</dd>
                        </dl>
                    </div>
                    <div class="span1 pull-right">
                        <img src="../assets/img/examples/ibdxkw9g3wkjklk5pftx.jpg" class="img-polaroid">
                        <br><br>
                    </div>
                </div>
            </div>
            <hr>
            <div class="container">
                <div class="raw-fluid">
                    <div class="span12 pull-left">
                        Friend Articles<br><br>
                    </div>
                    <div class="cpicture span1 pull-left">
                        <img src="../assets/img/examples/x8ahhkk1af66fvc9nniw.jpg" class="img-polaroid">
                    </div>
                    <div class="span8 pull-left">
                        <dl>
                            <dt>Friend ID</dt>
                            <dd>Friend Comment</dd>
                        </dl>
                    </div>
                </div>
                <br><br>
            </div>
            <hr>
            <div class="container">
                <div class="raw">
                    <div class="span12 pull-left">
                        Comment<br><br>
                    </div>
                    <div class="cpicture span1 pull-left">
                        <img src="../assets/img/examples/gugygdnmsnlchbgednxk.jpg" class="img-polaroid">
                    </div>
                    <div class="span8 pull-left">
                        <dl>
                            <dt>User ID</dt>
                            <dd>User Comment</dd>
                        </dl>
                    </div>
                </div>
            </div>
            
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
</body>
</html>