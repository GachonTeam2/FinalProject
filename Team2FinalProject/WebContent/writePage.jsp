<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>write</title>
 <style>
            html, body{
            width:100%;
            height:100%;
            padding: 0;
            margin: 0;
            }
            
            .debug {outline: 1px solid red;}
            
            #root{margin:auto; width:100%;}
            #spinner{width:100%;}
            #option{float:left; width:20%; height:90%;}
            #delete{float:left; width:80%;}
            #content{float:left; width:80%;}
            #add{float:left; width:80%;}
        </style>
</head>
<body>
        <div id="root" class="debug">
        <div id="spinner"class="debug" >spinner</div>
        <div id="option"class="debug">option</div>
        <div id="delete" align="right"class="debug">delete</div>
        <div id="content"align="center"class="debug">content</div>
        <div id="add" align="center"class="debug">+</div>
        </div>
    </body>
</html>