<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	boolean islogin = (String)request.getAttribute("isLogin") == null? false : true; %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>travel recommend</title>

    <!-- Bootstrap Core CSS -->
    <link href="http://ironsummitmedia.github.io/startbootstrap-landing-page/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="http://ironsummitmedia.github.io/startbootstrap-landing-page/css/landing-page.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="http://ironsummitmedia.github.io/startbootstrap-landing-page/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

   	<style type="text/css">
   		.debug {
			outline: 1px solid red;
		}
		
		.body{
			background-image: 
		
		}

   		
   	
   	
   	
   	</style>
   
   

</head>

<body>



    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation">
        <div class="container topnav">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand topnav" href="#">Real travel</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul id="loginNav" class="nav navbar-nav navbar-right">
                  <li>
                  	<a href="<%=request.getContextPath()%>/signin">로그인</a>
                  </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>


    <!-- Header -->
    <a name="about"></a>
    <div class="intro-header">
        <div class="container">

            <div class="row">
                <div class="col-lg-12">
                    <div class="intro-message">
                        <h1>Travel Recommend </h1>
                        <h3>여러분에게 딱 맞는 여행지를 찾아보세요</h3>
                        <hr class="intro-divider">
                        <ul  class="list-inline intro-social-buttons">      
                            <li id="loginBtn">
                                <a href="<%=request.getContextPath()%>/signin" class="btn btn-default btn-lg"><i class="fa fa-twitter fa-fw"></i> <span class="network-name">Twitter로 로그인</span></a>
                            </li>
                            
                        </ul>
                    </div>
                </div>
            </div>

        </div>
        <!-- /.container -->

    </div>
    <!-- /.intro-header -->

    <!-- Page Content -->

    <!-- /.content-section-a -->
    
    <!-- Footer -->

    <!-- jQuery -->
    <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="http://ironsummitmedia.github.io/startbootstrap-landing-page/js/jquery.js"></script>
  
    <!-- Bootstrap Core JavaScript -->
    <script src="http://ironsummitmedia.github.io/startbootstrap-landing-page/js/bootstrap.min.js"></script>
	<!-- login/logout -->
	<%if(islogin){ %>
	
	
		
		<script type="text/javascript">
		
		var userImg = '<%=(String)request.getAttribute("imageUrl")%>';
		var userName = '<%=(String)request.getAttribute("name")%>';
		var path = '<%=request.getContextPath()%>';
 
		jQuery( document ).ready(function( $ ) {
			
			$(function(){
				$('#loginBtn a').attr('href',path + "/synchronize_action");
				$('#loginBtn span').text('시작하기');
				
				
				var target =  $('#loginNav');
				
				target.map(function(index,element){
					console.log(element);
					$(element).empty();
				})	
			});
			
			$(function(){
				for(var i=0; i<2; i++){
					
					var anchor = document.createElement('a');
					$('<li>').append(anchor).appendTo('#loginNav');
								
				}
				
				$('#loginNav a').map(function(index,element){
					console.log(element);
					if(index === 0){
						$('<img>').attr({
							src : userImg,
							height : 25
						}).appendTo(element)
						
						$('<span>').css("margin-left","15px").text(userName).appendTo(element);
					}
					else if(index === 1){
						$('<span>').text('로그아웃').appendTo(element);
						$(this).attr('href', path + '/logout');
					}
				})
			});			
		});			
		</script>
	<%}%>


</body>

</html>
