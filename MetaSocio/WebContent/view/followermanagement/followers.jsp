
<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.metasocio.model.usermanagement.User"%>
<%@page import="com.metasocio.model.groupmanagement.Group"%>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>:: META-SOCIO ::</title>
    <!-- Bootstrap Core CSS -->
    <link href="assets/css/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css">
    <!-- Retina.js - Load first for faster HQ mobile images. -->
    <script src="assets/js/plugins/retina/retina.min.js"></script>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <!-- Default Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,100,200,300,600,500,700,800,900' rel='stylesheet' type='text/css'>
    <!-- Modern Style Fonts (Include these is you are using body.modern!) -->
    <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Cardo:400,400italic,700' rel='stylesheet' type='text/css'>
    <!-- Vintage Style Fonts (Include these if you are using body.vintage!) -->
    <link href='http://fonts.googleapis.com/css?family=Sanchez:400italic,400' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Cardo:400,400italic,700' rel='stylesheet' type='text/css'>
    <!-- Plugin CSS -->
    <link href="assets/css/plugins/owl-carousel/owl.carousel.css" rel="stylesheet" type="text/css">
    <link href="assets/css/plugins/owl-carousel/owl.theme.css" rel="stylesheet" type="text/css">
    <link href="assets/css/plugins/owl-carousel/owl.transitions.css" rel="stylesheet" type="text/css">
    <link href="assets/css/plugins/magnific-popup.css" rel="stylesheet" type="text/css">
    <link href="assets/css/plugins/background.css" rel="stylesheet" type="text/css">
    <link href="assets/css/plugins/animate.css" rel="stylesheet" type="text/css">
    <link id="changeable-colors" rel="stylesheet" href="assets/css/vitality-red.css">
    <link href="assets/demo/style-switcher.css" rel="stylesheet">
    <!-- IE8 support for HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>


<body id="page-top">
     <%@ page session="false"%>
     <%@ page errorPage="../../exception/error.jsp"%>
   
    <!-- Navigation -->
    <!-- Note: navbar-default and navbar-inverse are both supported with this theme. -->
    <nav class="navbar navbar-inverse navbar-fixed-top navbar-expanded" style="background-color: black">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header ">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
               
                <%
               /*  List<User> followerList = res */
                     HttpSession session = request.getSession(false);
            		
            		if(session==null){
            		%>
            			<a class="navbar-brand page-scroll hidden-sm"  href="index.jsp">
                    <img src="assets/img/logo.png" class="img-responsive hidden-sm" alt="">
                </a>
            		<%	
            		}
            		else{
            			%>
            			<a class="navbar-brand page-scroll hidden-sm"  href="HomePage">
                    <img src="assets/img/logo.png" class="img-responsive hidden-sm" alt="">
                </a>
            			<%
            		}
                %>
                <% String title = (String) request.getAttribute("listTitle"); %>
               
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse " id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a class="page-scroll" href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="AboutMetaSocio">What is Meta-Socio</a>
                    </li>
                   <% 
                   if(title.equalsIgnoreCase("followers")){
                   
                  %>
                     <li>
                        <a class="page-scroll" href="Followings">Followings</a>
                      </li>
                      <%}else{
                    	  
                    %>
                    
                      <li>
                        <a class="page-scroll" href="Followers">Followers</a>
                    </li>
                    <% } %>           
                           
                   <li>
                        <a class="page-scroll" href="HomePage">Home</a>
                    </li>
                    
                   
                   <li>
                        <a class="page-scroll" href="LogOut">Log out</a>
                    </li>
                    
                    
                   <!--  <li>
                        <a class="page-scroll" href="https://accounts.google.com/o/oauth2/auth?scope=email&amp;redirect_uri=http://localhost:8080/MetaSocio/OAuth&amp;response_type=code&amp;client_id=881126743057-0u1nhaqo1uk2dl0h0e9mpe3f9ptvmsa6.apps.googleusercontent.com&amp;approval_prompt=force&hd=metacube.com">Log-in</a>
                    </li> -->
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
   
    <section id="services" class="bg-gray">
        <div class="container-fluid">
            <div class="row text-center">
                <div class="col-lg-12 wow fadeIn">
               
                   <%--  <h1><%=title %></h1> --%>
                    <hr class="colored">
                    <h1>${listTitle}</h1>
                </div>
            </div>
            
            <div class="row text-center content-row">
           <% 
           if(title.equalsIgnoreCase("My Group List")){
			
				List<Group> groupsList = new ArrayList<Group>();
				
				groupsList = (List<Group>) request.getAttribute("groupList");
				
				 if(groupsList.isEmpty()){
	            	  %> 
	         	   <center><h3>No <%=title %></h3></center>
	          <%   }else{
				for (Group group : groupsList) {
;
		%>
		  <div class="col-md-2 col-sm-3 wow fadeIn" data-wow-delay=".2s">
                    <div class="about-content">
                        <img src = "assets/img/groupPhoto.png" class="img-responsive">
				<h3><%=group.getGroupName()%></h3>

			
				<a
					href="GroupPage?groupId=<%=group.getGroupId()%>"
					class="btn btn-outline-dark">Open</a></div></div>
					
				<% 		}
					}}
           else	if (title.equalsIgnoreCase("Groups List")) {

				List<Group> remainingGroupList = new ArrayList<Group>();
			
					
				remainingGroupList = (List<Group>) request.getAttribute("groupList");

				 if(remainingGroupList.isEmpty()){
	            	  %> 
	         	   <center><h3>No <%=title %></h3></center>
	          <%   }
				 else{
				for (Group group : remainingGroupList) {
		%>
	  <div class="col-md-2 col-sm-3 wow fadeIn" data-wow-delay=".2s">
                    <div class="about-content">
                        <img src = "assets/img/groupPhoto.png" class="img-responsive">
				<h3><%=group.getGroupName()%></h3>

				
				<a
					href="JoinGroup?groupId=<%=group.getGroupId()%>&title=<%=title%>"
					class="btn btn-outline-dark">Join</a></div></div>
					
				
				<%
				
			
					}
						

				 }	
					}else {
       
	
            List<User> userList = new ArrayList<User>();
           
            	userList = (List<User>) request.getAttribute("usersList");
            List<User> usersWhomYoAreNotFollowing = (List<User>) request.getAttribute("followersWhomYouAreNotFollowing");
          
          
            if(userList.isEmpty()){
            	  %> 
         	   <center><h3>No <%=title %></h3></center>
          <%   }
             
            for(User user : userList){
            	
            	%>          	
                <div class="col-md-2 col-sm-3 wow fadeIn" data-wow-delay=".2s">
                    <div class="about-content">
                        <img src = <%=user.getImageURL() %> class="img-responsive">
                        <h3><%=user.getName() %></h3>
                      
                      <%
                      if(title.equalsIgnoreCase("followers")){
                    	 
                      for(User userWhoIsNotFollowing : usersWhomYoAreNotFollowing){
                    	  if(userWhoIsNotFollowing.getUserId() == user.getUserId()){                  	                    	
                      		%>
                      		
                      		 <a href="FollowPeople?followingId=<%=user.getUserId()%>&title=<%=title %>"><button class="btn btn-outline-dark">Follow</button></a>
                      		<%-- <a href="AddFriend?friendId=<%=user.getUserId()%>" class="btn btn-outline-dark" >Follow</a> --%>                     		                     			
                      		<%
                      	}
                           
                      }}
                      	else if(title.equalsIgnoreCase("followings")){
                      		%>
                      		
                      		
                      		<a href="Unfollow?followingId=<%=user.getUserId() %>" class="btn btn-outline-dark">Unfollow</a>
                      		<%
                      		}
                      %>                    
                    </div>
                    
                </div>              
             	<%          	
            } }          
            %>                                   
        </div>
        </div>
    </section>
    <!-- End Style Switcher -->
    <!-- Core Scripts -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap/bootstrap.min.js"></script>
    <!-- Plugin Scripts -->
    <script src="assets/js/plugins/jquery.easing.min.js"></script>
    <script src="assets/js/plugins/classie.js"></script>
    <script src="assets/js/plugins/cbpAnimatedHeader.js"></script>
    <script src="assets/js/plugins/owl-carousel/owl.carousel.js"></script>
    <script src="assets/js/plugins/jquery.magnific-popup/jquery.magnific-popup.min.js"></script>
    <script src="assets/js/plugins/background/core.js"></script>
    <script src="assets/js/plugins/background/transition.js"></script>
    <script src="assets/js/plugins/background/background.js"></script>
    <script src="assets/js/plugins/jquery.mixitup.js"></script>
    <script src="assets/js/plugins/wow/wow.min.js"></script>
    <script src="assets/js/contact_me.js"></script>
    <script src="assets/js/plugins/jqBootstrapValidation.js"></script>
    <script src="assets/js/vitality.js"></script>
    <script src="assets/demo/style.switcher.js"></script>
</body>

</html>
