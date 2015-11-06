$(document).ready(function(){
	$('input:checkbox').change(function(){
		var parameter = "";
	
		parameter = getCheckedLocationParameter("listByLocation&startPage=1&pageNum=10");
		loadXMLDoc(parameter);
	})
	
	$(':button').on('click', function(event){
		console.log("value =" + this.innerText);
		var clickBtn = this.innerText;
		var parameter = "";
		
		if(clickBtn == 'Like'){
			console.log("good1");
			parameter = getCheckedLocationParameter('listBySortedLocation&standard=like');
		}else if(clickBtn == 'New'){
			parameter = getCheckedLocationParameter('listBySortedLocation&standard=new');
		}else if(clickBtn =="Comment"){
			parameter = getCheckedLocationParameter('listBySortedLocation&standard=comment');
		}
	
		console.log("parameter = " + parameter);
		
		loadXMLDoc(parameter);
	})
});

function goPage(page)
{
	//checkbox 확인, like sorting확인
	
	var parameter ='';
	
	$('input:checkbox').map(function(index,element){
		if($(element).is(':checked')){
			parameter = getCheckedLocationParameter("listByLocation&startPage=" + page + "&pageNum=10");
		}
		
	})
	
	
	if($('input:checkbox'))
}

function checkIsLocationChecked(){
	$('input:checkbox').map(function(index,element){
		if($(element).is(':checked')){
			return true;
		}
	})
	
	return false;
}

function checkIsSortdBtnClicked(){
	$(':button').
	
}



function getCheckedLocationParameter(method)
{
	var parameter="";

	if($('input:checked').length == 0)
		parameter = "?method=" + method;
		
	$('input:checked').map(function(index,element){
		console.log("element value = " + element.value )
		if(index == 0)
			parameter = "?method=" + method + "&location=" + escape(encodeURIComponent(element.value));
		else
			parameter = parameter + "&location=" + escape(encodeURIComponent(element.value));
	})
	
	return parameter;
}

function loadXMLDoc(parameter)
{
    var xmlhttp = new XMLHttpRequest();
  
    xmlhttp.onreadystatechange=function(){
      if (xmlhttp.readyState==4 && xmlhttp.status==200) {
    	  var obj = JSON.parse(xmlhttp.responseText);
    	  console.log(obj);
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



