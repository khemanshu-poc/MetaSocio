
<!DOCTYPE html>
<%-- <%@page import="sun.misc.FpUtils"%> --%>
<%@page import="com.metasocio.model.postmanagement.Post"%>
<%@page import="com.metasocio.model.commentmanagement.Comment"%>
<%@page import="java.util.ArrayList"%>
<%-- <%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%> --%>
<%@page import="com.metasocio.model.usermanagement.User"%>
<%@page import="com.metasocio.model.groupmanagement.Group"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Iterator"%>

<html lang="en">

<head>

<style>

</style>
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
    
    <link href="assets/css/custom.css" rel="stylesheet">
       <script src="assets/js/search.js"></script>
       <script type="text/javascript" src="assets/js/jquery-1.11.3.js"></script>
        <script src="assets/js/custom.js"></script>
        <script src="assets/js/like.js"></script>
    <!-- IE8 support for HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>


<body id="page-top">
<%@ page session="false"%>
     
    <!-- Navigation -->
    <!-- Note: navbar-default and navbar-inverse are both supported with this theme. -->
         <nav class="navbar navbar-inverse navbar-fixed-top navbar-expanded" style="background-color: black">
        <div class="container"> 
        <%User userObject=new User();
                        userObject=(User)request.getAttribute("userObject");
                       
                      //  int id = (int)request.getAttribute("id"); 
                     HttpSession session=request.getSession(false);
                     session.setAttribute("userObject", userObject);
                     
                     Group groupObject = (Group)request.getAttribute("groupObject");
                     session.setAttribute("groupObject", groupObject);
                      %>s
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand page-scroll hidden-sm"  href="HomePage">
                    <img src="assets/img/logo.png" class="img-responsive hidden-sm" alt="">
                </a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a class="page-scroll" href="#page-top"></a>
                    </li>
                    
                    <li>
                        <a class="page-scroll" href="AboutMetaSocio">What is Meta-Socio</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="Followers">Followers</a>
                    </li>
                    
                     <li>
                        <a class="page-scroll" href="Followings">Followings</a>
                    </li>
                    <%if(groupObject.getUser().getUserId() != userObject.getUserId()){ %>
                    <li>
                        <a class="page-scroll" href="LeftGroup?groupId=<%=groupObject.getGroupId()%>">Left Group</a>
                    </li>
                    <%}else{ %>
                    <li>
                        <a class="page-scroll" href="DeleteGroup?groupId=<%=groupObject.getGroupId()%>">Delete Group</a>
                    </li>
                    <%} %>
                    <li>
                        <a class="page-scroll" href="LogOut">Logout</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    <section id="about" style="background-color: #E9EAED;margin-top: 20px;">
        <div class="container-fluid">
        
        
        <div class="row rounded-corner" style="background-color:ghostwhite;border-bottom:1px solid orange">
        
        
        
        
          <div  class="col-lg-2">
            	<img src="assets/img/groupPhoto.png" class="img-responsive rounded-corners" id="profilePhoto" width="200px;">
            	<br>
            	<label><%=groupObject.getGroupName() %>&nbsp;&nbsp;&nbsp;<!-- <a href=" EditProfile" data-toggle="tooltip" title="Edit Profile"><span class="fa fa-pencil-square "></span></a> --></label>
          </div>
        
        
        <form action="AddPost?groupId=<%=groupObject.getGroupId()%>&pageTitle=groupPage" method="post">
          <div class="col-lg-7 wow fadeIn">
          <h1 class="text-center"><%=groupObject.getGroupName() %> &nbsp;&nbsp;&nbsp;<a href="#"><!-- <span class="fa fa-pencil"></span></a> --></h1>
          <div class="form-group col-xs-12 col-lg-12 floating-label-form-group controls" style="border:1px solid orange;">
                          <label>What's on your mind ? </label> 
                               <textarea  class="form-control"  placeholder="What's on your mind ? " name="post" style="background-color: transparent;resize:none" required="required"></textarea>
                    </div>
                    <div class="col-md-12 form-group text-center" style="margin-top: 10px;">
                           <button type="submit" class="btn btn-outline-dark "><i class="fa fa-share"></i>&nbsp;Share It On the Group </button>
                    </div>
           
          </div>
          </form>
          
          
          <div class="col-md-2 col-sm-6 col-lg-3 wow fadeIn" data-wow-delay=".8s" id="result" style="background-color: whitesmoke;border-radius:10px;" >
                    <div class="about-content text-center" >
                        <i class="fa fa-user-plus fa-2x"></i>
                        <h3>Suggested People</h3>
   
                        <%
                       
                        User suggestedUser = (User) request.getAttribute("suggestedUser");
                        if(suggestedUser!=null){
                        %>
                      	 <div class="row">
                        	<div class="col-md-3">
                        		<img src="<%=suggestedUser.getImageURL()%>" class="img-responsive">
                        	</div>
                        	<div class="col-md-9"><%=suggestedUser.getName()%></div>
                        	<a class="btn btn-sm btn-outline-dark" href="JoinGroup?userId=<%=suggestedUser.getUserId()%>&pageTitle=groupPage">Add</a>
                        </div>
                        
                        
                        <% }else{
                        	
                        	%>
                        	
                        	 <div class="row">
                        	<div class="col-md-12">
                        		No Suggestions Available
                        	</div>
                        	
                        </div>
                 	
                        	<% 
                 	
                        } %>
    
                       
                    </div>
                </div>

          </div>
          
          <div class="row">
                <div class="col-md-6 col-sm-6 col-lg-2 wow fadeIn" data-wow-delay=".2s">
                    <div class="about-content">
                       
                    </div>
                </div>
                
                <div class="col-md-8 col-sm-8 col-lg-7 wow fadeIn" data-wow-delay=".4s" >
					<div id="postLoader">	
					
					<% 	
					Map<Post, List<Comment>> postMap  = (Map)request.getAttribute("postMap"); 
					
					
				 Map<Post, Boolean> likeMap  = (Map)request.getAttribute("likeMap");  
				 String postAvailabilityIndicator = null;
					//Map<Integer,String> imageMapForPostedUsers = (Map)request.getAttribute("imageMapForPostedUsers"); 
					//Map<Integer,String> imageMapForCommentedUsers = (Map)request.getAttribute("imageMapForCommentedUsers"); 
					if(!postMap.isEmpty())
					{
						 Iterator iterator = postMap.keySet().iterator();

					   while (iterator.hasNext()) {
					      Post post = (Post) iterator.next();
					      Boolean isLikedByUser = likeMap.get(post);
					      List<Comment> commentList = null;
					      commentList = postMap.get(post);
					     %>
           
                    <form  id="editForm" method="post" hidden="hidden">
					  <div class="row text-center" >
            <input type="hidden" id="postId" value="">
            <input type="hidden" id="commentId" value="">
                <div class="col-lg-8 wow fadeIn">
                    <div class="form-group col-xs-12 col-lg-12 floating-label-form-group controls" style="border-color: orange;">
                         <label>Edit</label> 
                               <textarea  class="form-control"  placeholder="Edit" id="editContent" value="hi" style="background-color: transparent" required="required"></textarea>
                    </div>
            	</div>
            	<div class="col-lg-7 wow fadeIn">
                    <div class="form-group col-xs-12">
                           <input type="submit" class="btn btn-outline-dark " value="Edit"/>
                    </div>
                    </div>
            </div>
            
            </form>

					<div class="row  padding-small rounded-corner" style="background-color:ghostwhite;margin-top: 10px;">
						<div class="col-md-2">
							
							<img src="<%=post.getUser().getImageURL() %>" height="100px" width="100px">
						</div>
						<div class="col-md-10">
							<p>
								<strong> <%=post.getCreatedBy()%></strong> <span style=" color: orange">Posted on </span><strong> <%=post.getDatePosted() %></strong>
																
							</p>
							<h3>
								
								<p style="word-break: break-all;" id="post<%=post.getPostId()%>"><%=post.getPostDetails() %></p>
								<%if(userObject.getUserId()==post.getUser().getUserId()){ %>
								
							
                                    <input type="hidden" id="<%=post.getPostId()%>" value="<%=post.getPostDetails()%>">
											
											<a href="#"><i
									class="fa fa-pencil-square-o" id="editPostButton<%=post.getPostId()%>" onclick="buttonPress(<%=post.getPostId()%>)"></i></a>
									<span class="editPost<%=post.getPostId() %>" style="display: none">
									<a class="btn-sm btn-outline-dark" href='javascript:editPost(<%=post.getPostId()%>)'>Edit Post</a>
									<a class="btn-sm btn-outline-dark" href='DeletePost?&pageTitle=groupPage&postId=<%=post.getPostId()%>'>Delete Post</a>
									</span>
									
									
									
	
								<%
									}
								%>
							</h3>
							<div id="editDiv<%=post.getPostId()%>" style="display:none">
							<textarea id="editContent<%=post.getPostId()%>" class="form-control" value="hi"  required="required" style="resize:none"></textarea>
							<input type="hidden" id="postId<%=post.getPostId()%>"  value="">
							<button class="btn-sm btn-outline-dark" id="updateButton<%=post.getPostId()%>"  onclick="updatePost(<%=post.getPostId()%>)">Update</button>
							</div>
		
							<%
														
							
								if(isLikedByUser){
								%>
																
							<div id= "demo<%=post.getPostId()%>">
							<a href="#">
							<i class="fa fa-thumbs-up" id ="like<%=post.getPostId()%>" onClick="loadInfo(<%=post.getPostId()%>)" value="<%=post.getPostId()%>" style="color:grey"></i></a>
							
							
							
							
							<%=post.getLikes()%>
							
							
							
							
							
							</div>
							
							
							<%}else{
								%>
								
								
								
							<div id= "demo<%=post.getPostId()%>">
							
							<a href="#">
							<i class="fa fa-thumbs-up" id ="like<%=post.getPostId()%>" onClick="loadInfo(<%=post.getPostId()%>)" value="<%=post.getPostId()%>" style="color:orange"></i></a>
							
							<%=post.getLikes()%>
							
							
							
							
							</div>
							
						
							<%-- <a href="LikeController?postID=<%out.println(post.getPostId()); %>" class="button"> --%>
							
							<% } 
							for(Comment comment : commentList){  %>
							
							<div class="col-md-12" >
								<div class="row rounded-corner padding-smallComment" id="comment" background-color: #F6F7F8;">
									<div class="col-md-2">
										<img src="<%=comment.getUser().getImageURL()%>" height="50px" width="50px">
									</div>
									<div class="col-md-10">
										<p>
								<b> <i><%=comment.getCreatedBy()%></i></b><span Style="color:blue;">Commented on </span><b> <i><%=comment.getDateCommented()%></i></b>
															
								<input type="hidden" id="commentId<%=comment.getCommentId()%>" value="<%=comment.getComments()%>">
							
								
								






										<pre style="word-break: break-all;"
												id="comment<%=comment.getCommentId() %>"><%=comment.getComments() %></pre><%if(userObject.getUserId()==comment.getUser().getUserId()){ %>
							<a href="#"><i
													class="fa fa-pencil-square-o fa-2x editCommentButton<%=comment.getCommentId()%>"
													onclick="commentButtonPress(<%=comment.getCommentId()%>)"></i></a>
												<span class="editComment<%=comment.getCommentId() %>"
													style="display: none"> <a
													class="btn-sm btn-outline-dark"
													href='javascript:editComment(<%=comment.getCommentId()%>)'>Edit
														Comment</a> <a class="btn-sm btn-outline-dark"
													href='DeleteComment?pageTitle=groupPage&commentId=<%=comment.getCommentId()%>'>Delete
														Comment</a>
												</span>

                                       <%} %>
											<div id="editCommentDiv<%=comment.getCommentId() %>"
												style="display: none">
												<textarea
													id="editCommentContent<%=comment.getCommentId() %>"
													class="form-control" value="hi" style="resize: none" required="required"></textarea>
												<input type="hidden"
													id="commentId<%=comment.getCommentId() %>" value="">
												<button class="btn-sm btn-outline-dark"
													id="updateCommentButton<%=comment.getCommentId()%>"
													onclick="updateComment(<%=comment.getCommentId()%>)">Update</button>
											</div>

										
										
									</div>
								</div>

							</div>
						<%} %>
						<form action="AddComment?postID=<%out.println(post.getPostId());%>&pageTitle=groupPage" method="post">
										<textarea name="comment" placeholder="Add your comments here" class="form-control" required="required" style="resize:none"></textarea>
										<button type="submit" class="btn btn-outline-dark btn-small" style>comment</button>
											</form>
						</div>
						<div class="col-md-12">
							
						</div>
						</div>
						<%} %>
							
						<%postAvailabilityIndicator = "Posts available";
						}
					else{
						%>
							<div class="row text-center">
								<div class="col-md-12">
									<p>There are no post to show.</p>
								</div>
							</div>
					<%
					}
					%>
						
					</div>	
					<%if(postAvailabilityIndicator!=null){ %>
					<div class="row">
							<div class="col-md-12 text-center">
									<a href="javascript:loadPosts(<%=groupObject.getGroupId() %>)" class="btn btn-outline-dark text-center" id="loadMore">loadMore</a>		
							</div>
						</div>
						<%} %>
					
				</div>
				
    <div class="col-md-3 col-sm-6 col-lg-3 wow fadeIn" data-wow-delay=".8s" id="result">
                    <div class="about-content text-center">
                        <i class="fa fa-users fa-2x"></i>
                        <h3>group members</h3>
                        			    
                        		    <%
                        			    Set<User> groupMemberList = groupObject.getUsersSet();
                        			    if(!groupMemberList.isEmpty()){
                        			   
                        			    for(User groupMember : groupMemberList){
                                     		
                                    			   %>	
                                    			   <div class="col-md-12">
                                    			    <div class="col-md-3">
                        		<img src="<%=groupMember.getImageURL()%>" class="img-responsive">
                        	</div>
                        	<div class="col-md-5">
                        	<%if(groupMember.getUserId() == userObject.getUserId())
                        	{%>
                        		You
                            <%}
                        	else
                        	{ %>
                        		<small><%=groupMember.getName()%></small>
                        	<%}
                        	
                        			    %>
                        			    
                        			    </div>
                        			    
                        			    	<div class="col-md-4">
                        			    
                        			    <%
                        			    if(groupMember.getUserId() == groupObject.getUser().getUserId()){
                        			    	
                        			    	%>                       			    	
                        			    	<img src="assets/img/Admin.png" class="img-responsive hidden-sm" alt="Admin">
	
                        			    	<% 
                        			    	
                        			    }
                        			    
                        			    %>
                        			    </div>
                        			    
                        			    </div><br><br><br>
                        			<%}} %>
                   </div>
                    </div>
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
    <script src="assets/js/Loader.js"></script>
    <!-- Vitality Theme Scripts -->
    <script src="assets/js/vitality.js"></script>
    <!-- Style Switcher Scripts - Demo Purposes Only! -->
    <script src="assets/demo/style.switcher.js"></script>
    <script>
    $(document).ready(function(){
        $("#search").keypress(function(){
            $("#searchBlock").css("display", "list-item");
        });
        $("#search").focusout(function(){
            $("#searchBlock").css("display", "none");
        });
    });
    </script>
    
    <script type="text/javascript">
										
								
								$("[data-toggle=popover]")
								.popover({html:true})
								
								
								
								</script>
    
    
</body>

</html>
