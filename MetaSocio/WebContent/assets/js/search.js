var req;
	function searchUsersByKey() {
		var search = document.getElementById("search").value;
		if (window.XMLHttpRequest) {
			req = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			
			req = new ActiveXObject("Microsoft.XMLHTTP");
		}

		var url = "searchByName?search=" + search;
		req.open("GET", url, true);
		req.send();
		
		req.onreadystatechange = function() {

			if (req.readyState == 4 && req.status == 200) {
				
				var searchedResult = JSON.parse(req.responseText);
			
				var usersNameArray = [];
				var usersImageArray=[];
				var users_array = [];
				var usersIdArray=[];
				for(var i in searchedResult) {
				  if(searchedResult.hasOwnProperty(i) && !isNaN(+i)) {
				    	
					  usersNameArray.push(searchedResult[i].name);
				    	
					  usersImageArray.push(searchedResult[i].imageURL);
					  usersIdArray.push(searchedResult[i].userId);
				    }
				}
				
				var text="";
				for (i = 0; i < searchedResult.length; i++) { 
				    text += "<div class='row'>" +
				    		"<div class='col-md-2'>" +
				    		"<img src='"+usersImageArray[i]+"' width='50px'>" +
				    		"</div>" +
				    		"<div class='col-md-8'><label>"+usersNameArray[i]+"</label></div>"+
				    		"<div class='col-md-2'>" +
				    		"<a class='btn-outline-dark' href='FollowPeople?followingId="+usersIdArray[i]+"'>Follow</a>" +
				    		"</div>" +
				    		"</div>" +
				    		"<hr >" ;
				}
				
				
				
				
				
				
				
				if(text==""){
					document.getElementById("searchBlock").innerHTML ="<center>No results Found</center>";
				}
				else{
					document.getElementById("searchBlock").innerHTML =text;
				}
				
				
				
			}
			}
	}

		/* req.send(null); */
	