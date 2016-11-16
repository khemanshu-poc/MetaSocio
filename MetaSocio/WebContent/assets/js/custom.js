

function followPeople(followingId,email){
	
	/*var followerId=Integer.parseInt(followerId);*/
	var followingId=followingId;
	var email=email;
	if (window.XMLHttpRequest) {
		
		req = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}

	var url = "FollowPeople?followingId="+followingId;
	req.open("GET", url, true);
	req.send();
	
	req.onreadystatechange = function() {

		if (req.readyState == 4 && req.status == 200) {
			
			var usersOfSameDepartment = JSON.parse(req.responseText);
		  
			var usersNameArray = [];
			var usersImageArray=[];
			var users_array = [];
			
			
			
			for(var i in usersOfSameDepartment) {
				
				
				if(usersOfSameDepartment.hasOwnProperty(i) && !isNaN(+i)) {
				  usersNameArray.push(usersOfSameDepartment[i].name);
			    	
				  usersImageArray.push(usersOfSameDepartment[i].imageURL);
			    }
			}
			
			var text="";
			 text+="<div class='about-content'>" +
 			   "<i class='fa fa-users fa-4x'></i>"+
 			   "<h3>Suggested People</h3>";
 			   
 			if(usersOfSameDepartment.length==1){
 			   text+="<div class='col-md-12 col-lg-2 col-sm-12 col-xs-12'>No Suggestions</div>";
 			 }
            else{
            	for (var i in usersOfSameDepartment) { 
            		if( usersOfSameDepartment[i].emailId!=email){
            			
       			  text+="<div class='row' style='margin-bottom: 20px'>" +

     			   	"<div class='col-md-8'>"+usersOfSameDepartment[i].name+"</div>" +
     				"<div class='col-md-4'>"+
           			  
           				
     				
       				"<button class='btn btn-sm btn-outline-dark' onclick='followPeople("+usersOfSameDepartment[i].userId,email+")'>Follow</button>"+
       				
       				"</div>"+
       				"</div>";
        		}
				
        	}
            }	
           		
            text+="</div>";			
           	
        
				document.getElementById("result").innerHTML =text;
			
		}
}

}
	
	


function buttonPress(postId){
	$(".editPost"+postId).show();
}




function editPost(postId){
	
	$("#post"+postId).hide();
	
	$("#editDiv"+postId).show();
	var postContent=$("#post"+postId).text();
		
		document.getElementById(postId).value;
	$("#editContent"+postId).val(postContent);
	document.getElementById("postId"+postId).value=postId;
	
	/*document.getElementById("updateButton"+postId).click(updatePost);*/
	
}


function updatePost(postId){

	//var postId = document.getElementById("postId"+postId).value;
	var postContent=$("#editContent"+postId).val();
	
	
	
	if (window.XMLHttpRequest) {
		
		req = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}

	var url = "EditPost?postId=" + postId+"&postContent="+postContent;
	req.open("GET", url, true);
	req.send();
	
	req.onreadystatechange = function() {

		if (req.readyState == 4 && req.status == 200) {
			
			var postDetails=req.responseText;
			document.getElementById("post"+postId).innerHTML=postDetails;
			}
		}	
	
	$("#editDiv"+postId).hide();
	$("#post"+postId).show();
}




function commentButtonPress(commentId){
	$(".editComment"+commentId).show();
}


function editComment(commentId){
	
	$("#comment"+commentId).hide();
	
	$("#editCommentDiv"+commentId).show();
	
	var commentContent=$("#comment"+commentId).text();
		
		/*document.getElementById("commentId"+commentId).value;*/
	
	$("#editCommentContent"+commentId).val(commentContent);
	//document.getElementById("commentId").value=commentId;
	
	
	
	
	/*var commentContent=document.getElementById("commentId"+commentId).value;
	$("#editContent").val(commentContent);
	document.getElementById("commentId").value=commentId;
	
	$("#editForm").attr("hidden",false);
	
	alert("comment"+document.getElementById("commentId").value);
	
	$("#editForm").submit(updateComment);*/
}



function updateComment(commentId){
	
	
	//var commentId = document.getElementById("commentId").value;
	var commentContent=$("#editCommentContent"+commentId).val();
	
	
	
	
	if (window.XMLHttpRequest) {
		
		req = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}
	var url = "EditComment?commentId=" + commentId+"&commentContent="+commentContent;
	
	req.open("GET", url, true);
	req.send();
	
	req.onreadystatechange = function() {

		if (req.readyState == 4 && req.status == 200) {
			
			var commentDetails=req.responseText;
			document.getElementById("comment"+commentId).innerHTML=commentDetails;
			}
		}	

	$("#editCommentDiv"+commentId).hide();
	$("#comment"+commentId).show();
	
	

	/*alert("edit")
	alert("rrrrr"+document.getElementById("commentId").value);
	alert($("#editContent").val());
	var commentId = document.getElementById("commentId").value;
	var commentContent=$("#editContent").val();
	
	
	
	if (window.XMLHttpRequest) {
		
		req = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}

	var url = "EditComment?commentId=" + commentId+"&commentContent="+commentContent;
	req.open("GET", url, true);
	req.send();
	
	req.onreadystatechange = function() {

		if (req.readyState == 4 && req.status == 200) {
			
			var commentDetails=req.req.responseText;
			document.getElementById("comment"+commentId).innerHTML=commentDetails;
			}
		}	
	
	$("#editForm").attr("hidden",true);*/
}

/*function uploadFile(){
	
	alert("upload file")
	if (window.XMLHttpRequest) {
		alert("hi2")
		req = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		alert("hi3")
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}
	var imagePath=document.getElementById("imagePathId").value;
	alert(imagePath)
	
	var url = "PhotoUploader?imagePath="+imagePath;
	req.open("GET", url, true);
	req.send();
	req.onreadystatechange = function() {
		if (req.readyState == 4 && req.status == 200) {
			alert("hi uploaded")
			document.getElementById("pictureId").src=req.responseText;
			
			alert("hi uploaded1")
			document.getElementById("valueOfPictureId").value=req.responseText;
			alert("hi uploaded155")
			

		}

	}

	
}*/










