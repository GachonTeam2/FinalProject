<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="com.lecture.finalproject.model.ModelFrontTravlePost" %>
<%@ page import="com.lecture.finalproject.model.ModelConcern" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>My page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css" rel="stylesheet">
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
        </style>
    </head>

    <body>
        <div class="container">
        
        <%@include file="commonPage/nav.jsp" %>
            <br>
            <div class="raw-fluid">
                <!-- profile -->
                <div class="span1 pull-left">
                    <img src="${pageContext.request.contextPath}/img/defaulUser.png" class="img-polaroid" id="my_img">

                </div>
                <div class="span7 pull-left">
                    <dl>
                        <dt id="my_name">로그인 해주세요  </dt>
                    </dl>
                </div>
                <!-- modal on/off -->
                <div class="span2 pull-right"><br>
                    <a href="#myModal" role="button" class="btn" data-toggle="modal" id="showFriendBtn"><i class="icon-user"></i> Add friends</a>
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
                        <%
                        	List<ModelConcern> concerns = (List<ModelConcern>)request.getAttribute("concerns");
                        
                        	for(int i=0; i<concerns.size(); i++){
                        		ModelConcern concern = concerns.get(i);
   		
                        %>
                         	<div class="span2">
                                <input type="button" name=concern value="<%=concern.getInterest()%>">
                            </div>

						<%
							}
						%>				
                        </div>
                    </div>
                </div>
            </div>
            <div class="row-fluid">
			<%
				List<ModelFrontTravlePost> posts = (List<ModelFrontTravlePost>) request.getAttribute("posts");

				for (int i = 0; i < posts.size(); i++) {
					ModelFrontTravlePost post = posts.get(i);
			%>
			<div class="span4">
				<h2><%=post.getTitle()%></h2>
				<img src="<%=post.getImage_url()%>" class="img-polaroid">
				<p><%=post.getAddress()%></p>
				<p>
					<a class="active pull-right" href="#"><%=post.getComment_count()%><i
						class="icon-comment"></i></a> <a class="active pull-right" href="#"><%=post.getLike_count()%><i
						class="icon-heart"></i></a>
				</p>
			</div>
			<%
				}
			%>
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
                <h3 id="myModalLabel">Add friends</h3>
            </div>
            <div class="modal-body" >
                <p>friends list</p>
                	<div id="friendListMenu"></div>
            </div>
            <div class="modal-footer">
                <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
                <button class="btn btn-primary">Save</button>
            </div>
        </div>
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/myPage.js"></script>
    <script src="${pageContext.request.contextPath}/js/paging.js"></script>
   
    <script type="text/javascript">
	 
			var user_img = '<%=(String)request.getAttribute("userImage")%>';
			var userName = '<%=(String)request.getAttribute("userName")%>';
			
		if(user_img !== "" && userName !== ""){
			$("#my_img").attr("src",user_img);
			$("#my_name").empty().text(userName);
		}
    
    </script>
    </body>
</html>