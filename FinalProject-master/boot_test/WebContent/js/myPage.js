$(document).ready(function(){

	var user_img = '${request.userImage}'
	var userName = '${request.userName}'
	
	console.log(user_img);
	console.log(userName);
	
	if(user_img !== "" && userName !== ""){
		$("#my_img").attr("src",user_img);
		$("#my_name").empty().text(userName);
	}
})

