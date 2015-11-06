function goPage(page){

	var parameter = "?method=listPost&startPage=" + page +  "&pageNum=10";
	loadXMLDoc(parameter);

}	


function loadXMLDoc(parameter)
{
	console.log(parameter);
	var xmlhttp = new XMLHttpRequest();

	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			var obj = JSON.parse(xmlhttp.responseText);

			jsonObjectParse(obj);
		}
	}   
	console.log(parameter);
	 
	xmlhttp.open("GET", "/boot_test/RestGetPost" + parameter,true);
	xmlhttp.send();
}

function jsonObjectParse(obj){

	var size = 0;

	for(var i in obj.posts)
		size++;

	$('#post_list').empty();
	for(var i=0; i<size; i++){
		$divWrapper = $('<div></div>').addClass('span4');
		$divWrapper.append($('<h2></h2>').text(obj.posts[i].title));
		$divWrapper.append($('<img/>').addClass('img-polaroid').attr('src',obj.posts[i].image_url));
		$divWrapper.append($('<p></p>').text(obj.posts[i].address));
		$pWrapper = $('<p></p>');
		$pWrapper.append($('<a></a>').addClass('active pull-right').text(obj.posts[i].comment_count).append($('<i></i>').addClass('icon-comment')));
		$pWrapper.append($('<a></a>').addClass('active pull-right').text(obj.posts[i].like_count).append($('<i></i>').addClass('icon-heart')));
		$divWrapper.append($pWrapper);

		$('#post_list').append($divWrapper);

	}
}



