<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>write</title>
<style>
html, body {
    width: 100%;
    height: 700px;
}

.debug {
    border: 1px solid red;
}

#title_box {
    width: 100%;
    height: 10%;
}



#title {
    float: right;
    width: 80%;
    height: 100%;
}

#contents_box {
    width: 100%;
    height: 90%;
}

#option {
    float: left;
    width: 10%;
    height: 30%;
    margin-left: 9%;
    margin-top: 10%;
}

#content {
    width: 60%;
    height: 60%;
    margin-left: 20%;
    margin-right: 20%;
    margin-top: 2%;
}

#add {
    width: 60%;
    height: 10%;
    margin-left: 20%;
    margin-right: 20%;
    maring-bottom: 50%;
}
</style>
</head>
<body>


    <div id="title_box">
        <div id="title">
            <h2>title name</h2>
        </div>
        <div id="cate_list">
            <select style="margin-left: 15%; margin-top: 10px;">
                <option>list 1</option>
                <option>list 2</option>
                <option>list 3</option>
            </select>
        </div>

    </div>

    <div id="contents_box" align="center">
        <div id="option" align="center" class="debug">
            <h3>option</h3>
        </div>
        <div id="content" align="center" class="debug"></div>


        <div id="add" align="center" class="debug">
            <h2>contents add</h2>
        </div>
    </div>


</body>
</html>