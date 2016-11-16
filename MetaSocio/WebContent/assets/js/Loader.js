var startIndex = 2;
function loadPosts(groupId) {
	
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}
	var url = "PostLoader?startIndex="+startIndex+"&groupId="+groupId;
	req.open("GET", url, true);
	req.send();
	req.onreadystatechange = function() {
		if (req.readyState == 4 && req.status == 200) {
			var postContentDiv = document.createElement('div');
			if( req.responseText==""){
				postContentDiv.innerHTML="There are no post to show";
				$("#loadMore").hide();
				
			}else{
				postContentDiv.innerHTML = req.responseText;
			}
			
			document.getElementById("postLoader").appendChild(postContentDiv);
			startIndex += 2;
		}
	}
}