<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="com.lecture.finalproject.model.ModelComment"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	int totalRecord = 0; // 전체 레코드 수
	int numPerPage = 10; //페이지 당 레코드 수
	int pagePerBlock = 15; // 블럭 당 페이지 수

	int totalPage = 0; // 전체페이지 수
	int totalBlock = 0; //전체 블록 수

	int nowPage = 1;//현재 페이지
	int nowBlock = 1;//현제 블록
	int start = 0; //DB의 select 시작번호
	int end = 10; // 시작번호로 부터 가져올 select 개수
	int listSize = 0; // 현재 읽어온 게시물의 수
	start = (nowPage * numPerPage) - numPerPage;
	end = start + numPerPage;

	//totalRecord = bMgr.getTotalCount(keyField,keyWord);
	totalPage = (int) Math.ceil((double) totalRecord / numPerPage);
	nowBlock = (int) Math.ceil((double) nowPage / pagePerBlock);
	totalBlock = (int) Math.ceil((double) totalPage / pagePerBlock);

	Vector<ModelComment> vlist = null;
%>

<title>Detail Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="css/simple-sidebar.css" rel="stylesheet">
<script type="text/javascript">
	function list() {
		document.listFrm.action = "detailPage.jsp"
		document.listFrm.submit();
	}

	function pageing(page) {
		document.readFrm.nowPage.value = page;
		document.readFrm.submit();
	}

	function block(value) {
		document.readFrm.nowPage.value =
<%=pagePerBlock%>
	* (value - 1) + 1;
		;
		document.readFrm.submit();

	}
</script>
<style type="text/css">
body {
	width: 100%;
	height: 100%;
	padding-top: 20px;
	padding-bottom: 60px;
}

.container {
	margin: 0 auto;
	max-width: 1000px;
}

.container>hr {
	margin: 20px 0;
}

.picture {
	max-width: 64px;
	max-height: 64px;
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
	border-left: 1px solid rgba(255, 255, 255, .75);
	border-right: 1px solid rgba(0, 0, 0, .1);
}

.navbar .nav li:first-child a {
	border-left: 0;
	border-radius: 3px 0 0 3px;
}

.navbar .nav li:last-child a {
	border-right: 0;
	border-radius: 0 3px 3px 0;
}

.bpicture {
	margin: 0 auto;
	width: 640px;
}

.btnmargin {
	margin-left: 150px;
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
	<div class="container" id="wrapper">
		<div class="masthead">
			<div class="navbar">
				<div class="navbar-inner navbar-fixed-top">
					<div class="container" id="sb-site">
						<ul class="nav">
							<li class="sb-open-left"><i class="icon-search"></i>Search</a></li>
							<li><a href="mainpage.html"><i class="icon-home"></i></a></li>
							<li><a href="concernRecommendPage.html"><i
									class="icon-star"></i></a></li>
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
		<div class="raw-fluid">
			<div class="jumbotron">
				<h1>${travlePost.title}</h1>
			</div>
		</div>

		<div class="container">
			<div class="bpicture">
				<c:forEach items="${imageList}" var="imgEntry">
					<br>
					<img src="${imgEntry.image_url}" />
					<br>
				</c:forEach>
			</div>
			<div class="bpicture">

				<c:forEach items="${informationList}" var="informationEntry">
					<br>${informationEntry.travel_content}<br>
					<Br>
				</c:forEach>

				<br> <br> <br>
			</div>
		</div>

		<div class="container">
			<div class="raw-fluid">
				<div class="btnmargin span3">
					<button class="btn" type="button">
						<i class="icon-heart"></i> Like
					</button>
				</div>
				<div class="span2 pull-right">
					<dl>
						<dt>${wrtier.user_id}</dt>
						<dd>
							<img src="${writer.img_url}" />
						</dd>
					</dl>
				</div>
				<div class="span1 pull-right">
					<img src="img/ibdxkw9g3wkjklk5pftx.jpg" class="img-polaroid">
					<br> <br>
				</div>
			</div>
		</div>
		<hr>

		<form name="comment"
			action="com.lecture.finalproject.controller/Detailcontroller.java"
			method="post">
			<div class="container">
				<div class="raw-fluid">
					<div class="span1 pull-left">
						<img src="${writer.img_url}" class="img-polaroid"
							name="commentImage" />
					</div>
					<div class="span8">
						<h3 name="commentId">${writer.user_id}</h3>
						<div class="row">
							<div class="span8">
								<input class="input-block-level" type="text" name="commentInput"></input>
							</div>
						</div>
					</div>
					<div>
						<input type="submit" value="check">
					</div>
				</div>
			</div>
		</form>
		<hr>
		<div class="container">
			<div class="raw-fluid">
				<div class="span12 pull-left">
					Friend Articles<br> <br>
				</div>
				<div class="cpicture span1 pull-left">
					<img src="img/x8ahhkk1af66fvc9nniw.jpg" class="img-polaroid">
				</div>
				<div class="span8 pull-left">
					<dl>
						<dt>Friend ID</dt>
						<dd>Friend Comment</dd>
					</dl>
				</div>
			</div>
			<br> <br>
		</div>
		<hr>
		<div class="container">
			<div class="raw">
				<div class="span12 pull-left">
					Comment<br> <br>
				</div>

				<div class="cpicture span1 pull-left">
					<img src="${commentList.image_url}" class="img-polaroid">
				</div>
				<div class="span8 pull-left">
					<dl>
						<dt>
							<c:forEach items="${commentList}" var="userCommentEntry">
								<dt>${userCommentEntry.user_id}</dt>
							</c:forEach>
						</dt>
						<dd>
							<c:forEach items="${commentList}" var="commentEntry">
								<br>
								${commentEntry.content}
								<br>
							</c:forEach>
						</dd>
					</dl>
				</div>

			</div>
		</div>
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<li class="sidebar-brand"><a href="#"> Side Menu Test </a></li>
				<li><a href="#">Dashboard</a></li>
				<li><a href="#">Shortcuts</a></li>
				<li><a href="#">Overview</a></li>
				<li><a href="#">Events</a></li>
				<li><a href="#">About</a></li>
				<li><a href="#">Services</a></li>
				<li><a href="#">Contact</a></li>
			</ul>
		</div>

	</div>
	<!-- paging -->
	<%
		int pageStart = (nowBlock - 1) * pagePerBlock + 1;
		int pageEnd = ((pageStart + pagePerBlock) < totalPage) ? (pageStart + pagePerBlock) : totalPage + 1;
		if (totalPage != 0) {
			if (nowBlock > 1) {
	%>

	<div class="pagination pull-right">
		<ul>
			<li><a href="javascript:block('<%=nowBlock - 1%>')">Prev</a> <%
					}
				%></li>
			<%
				for (; pageStart <= pageEnd; pageStart++) {
			%>
			<li><a href="javascript:pageing('<%=pageStart%>')"><%=pageStart%></a></li>
			<%
				}
			%>
			<%
				if (totalBlock > nowBlock) {
			%>
			<li><a href="javascript:block('<%=nowBlock + 1%>')">Next</a> <%
					}
				%></li>
			<%
				}
			%>
		</ul>
	</div>
	<!-- pageing end -->

	<!-- modal -->
	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<h3 id="myModalLabel">Add friends</h3>
		</div>
		<div class="modal-body">
			<p>friends list</p>
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
			<button class="btn btn-primary">Save</button>
		</div>
	</div>
	<script src="http://code.jquery.com/jquery.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="js/slidebars.js"></script>
	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("toggled");
		});
	</script>
</body>
</html>