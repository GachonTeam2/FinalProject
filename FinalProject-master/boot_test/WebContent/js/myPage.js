$(document).ready(function(){
	$('#showFriendBtn').on('click', function(){		
		var parameter = "?method=getFrindAndFollowerList";
		console.log(parameter);
		loadXMLDoc(parameter)	
		
	})
})



function loadXMLDoc(parameter)
{
    var xmlhttp = new XMLHttpRequest();
  
    xmlhttp.onreadystatechange=function(){
      if (xmlhttp.readyState==4 && xmlhttp.status==200){
    	  var obj = JSON.parse(xmlhttp.responseText);
    	  friendsListParse(obj);
      }
    }   
    console.log(parameter);
 
    xmlhttp.open("GET", "/boot_test/RestGetPeople" + parameter,true);
    xmlhttp.send();
}

function friendsListParse(obj)
{
	var size = 0;
	
	for(var i in obj.friendList)
		size++;
	$('#friendListMenu').empty();
	for(var i=0; i<size; i++){
		$img = $('<img/>').attr('src',obj.friendList[i].img_url);
		$name = $('<p></p>').text(obj.friendList[i].name);
		$btn = $('<button></button>').text('추가');
		$friend = $('<div></div>').append($img, $name,$btn);
		$('#friendListMenu').append($friend);
	}
}

