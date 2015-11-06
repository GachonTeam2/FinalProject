<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%request.setCharacterEncoding("EUC_KR"); %>
<jsp:useBean id="bMgr" class="com.lecture.finalproject.controller.Detail_action"/>
<jsp:useBean id="reBean" class="com.lecture.finalproject.model.ModelComment"/>
<jsp:setProperty property="*" name="reBean"/>
<%
bMgr.replyUpBoard(reBean.getRef(), reBean.getPos());
bMgr.replyBoard(reBean);
String nowPage = request.getParameter("nowPage");
response.sendRedirect("detailPage.jsp?nowPage="+nowPage);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>