<!DOCTYPE html>
<%@page import="com.metasocio.model.groupmanagement.Group"%>
<html lang="en">
<%@page import="sun.misc.FpUtils"%>
<%@page import="com.metasocio.model.postmanagement.Post"%>
<%@page import="com.metasocio.model.commentmanagement.Comment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.metasocio.model.usermanagement.User"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<head>
<style>
</style>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no">
<meta name="description" content="">
<meta name="author" content="">
<title>:: META-SOCIO ::</title>
<!-- Bootstrap Core CSS -->
<link href="assets/css/bootstrap/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<!-- Retina.js - Load first for faster HQ mobile images. -->
<script src="assets/js/plugins/retina/retina.min.js"></script>
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Default Fonts -->
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Raleway:400,100,200,300,600,500,700,800,900'
	rel='stylesheet' type='text/css'>
<!-- Modern Style Fonts (Include these is you are using body.modern!) -->
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Cardo:400,400italic,700'
	rel='stylesheet' type='text/css'>
<!-- Vintage Style Fonts (Include these if you are using body.vintage!) -->
<link
	href='http://fonts.googleapis.com/css?family=Sanchez:400italic,400'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Cardo:400,400italic,700'
	rel='stylesheet' type='text/css'>
<!-- Plugin CSS -->
<link href="assets/css/plugins/owl-carousel/owl.carousel.css"
	rel="stylesheet" type="text/css">
<link href="assets/css/plugins/owl-carousel/owl.theme.css"
	rel="stylesheet" type="text/css">
<link href="assets/css/plugins/owl-carousel/owl.transitions.css"
	rel="stylesheet" type="text/css">
<link href="assets/css/plugins/magnific-popup.css" rel="stylesheet"
	type="text/css">
<link href="assets/css/plugins/background.css" rel="stylesheet"
	type="text/css">
<link href="assets/css/plugins/animate.css" rel="stylesheet"
	type="text/css">
<link id="changeable-colors" rel="stylesheet"
	href="assets/css/vitality-red.css">
<link href="assets/css/custom.css" rel="stylesheet">
<script src="assets/js/search.js"></script>
<script type="text/javascript" src="assets/js/jquery-1.11.3.js"></script>
<script src="assets/js/custom.js"></script>
<script src="assets/js/like.js"></script>
<script src="assets/js/Loader.js"></script>
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
	<nav class="navbar navbar-inverse navbar-fixed-top navbar-expanded"
		style="background-color: black">
		<div class="container">
			<%
				HttpSession session=request.getSession(false);
			              User userObject=new User();
			                        userObject=(User)session.getAttribute("userObject");
			                    /*  HttpSession session=request.getSession(false);
			                     session.setAttribute("userObject", userObject); */
			%>
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand page-scroll hidden-sm" href="HomePage"> <img
					src="assets/img/logo.png" class="img-responsive hidden-sm" alt="">
				</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li class="hidden"><a class="page-scroll" href="#page-top"></a>
					</li>
					<li style="width: 400px;"><input type="text"
						name="searchUsersByKey" class="form-control" id="search"
						onkeyup="searchUsersByKey()" placeholder="Search People"
						style="margin-top: 10px; width: 400px;">
						<div id="searchBlock"
							style="display: none; width: 400px; height: 500px; position: absolute; background-color: white; overflow-y: scroll; overflow-x: hidden">
						</div></li>
					<li><a class="page-scroll" href="AboutMetaSocio">What is
							Meta-Socio</a></li>
					<li><a class="page-scroll" href="Followers">Followers</a></li>
					<li><a class="page-scroll" href="Followings">Followings</a></li>
					<li><a class="page-scroll" href="MyGroups">My Groups</a></li>
					<li><a class="page-scroll" href="LogOut">Logout</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<section id="about"
		style="background-color: #E9EAED; margin-top: 20px;">
		<div class="container-fluid">
			<div class="row rounded-corner"
				style="background-color: ghostwhite; border-bottom: 1px solid orange">
				<div class="col-lg-2 text-center">
					<img src="<%=userObject.getImageURL()%>"
						class="img-responsive rounded-corners" id="profilePhoto"
						width="200px;" style="border-radius: 10px;"> <br> <label><%=userObject.getName()%>&nbsp;&nbsp;&nbsp;<a
						href=" EditProfile" data-toggle="tooltip" title="Edit Profile"
						style="text-align: center;"><span class="fa fa-pencil-square "></span></a></label>
				</div>
				<form action="AddPost" method="post">
					<div class="col-lg-7 wow fadeIn">
						<div
							class="form-group col-xs-12 col-lg-12 floating-label-form-group controls"
							style="border-color: orange;">
							<label>What's on your mind ? </label>
							<textarea class="form-control"
								placeholder="What's on your mind ? " name="post"
								style="background-color: transparent; resize: none"
								required="required"></textarea>
						</div>
						<div class="col-md-12 form-group text-center"
							style="margin-top: 10px;">
							<button type="submit" class="btn btn-outline-dark ">
								<i class="fa fa-share"></i>&nbsp;Share Your Status
							</button>
						</div>
					</div>
				</form>
				<div class="col-md-2 col-sm-6 col-lg-3 wow fadeIn"
					data-wow-delay=".8s" id="result"
					style="background-color: whitesmoke; border-radius: 10px;">
					<div class="about-content text-center">
						<i class="fa fa-user-plus fa-2x
						
						"></i>
						<h3>Suggested People</h3>
						<%
							// String email =(String) request.getAttribute("email");
						%>
						<%
							List<User> usersOfSameDepartment =new ArrayList<User>(); 
						                        usersOfSameDepartment=(List<User>)request.getAttribute("usersList"); 
						                        if(usersOfSameDepartment.size()==1){
						%>
						<div class="col-md-12 col-lg-2 col-sm-12 col-xs-12">No
							Suggestions</div>
						<%
							}
						                        else{
						                        	int number = 1;
						                        	 for(User userOfSameDepartment : usersOfSameDepartment){
						                         		if(!userOfSameDepartment.getEmailId().equalsIgnoreCase(userObject.getEmailId())){
						                         			if(number>2){
						                         				break;
						                         			}
						                         			else{
						                         				number++;
						%>
						<div class="row" style="margin-top: 20px;">
							<div class="col-md-6"><%=userOfSameDepartment.getName()%></div>
							<div class="col-md-6">
								<a class="btn-sm btn-outline-dark"
									href="FollowPeople?followingId=<%=userOfSameDepartment.getUserId()%>">Follow</a>
							</div>
						</div>
						<%
							}
						                        			   }
						                         	
						                         		
						                        	 }
						                        }
						%>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 col-sm-6 col-lg-2 wow fadeIn"
					data-wow-delay=".2s" style="margin: 10px 0px ;border-radius:10px;padding-bottom: 20px">
					<div class="about-content">
						<h3>Groups</h3>
						<div class=" col-lg-12 col-md-12 col-sm-12 col-xs-12"
							style="margin-bottom: 20px;">
							<button class="btn btn-outline-dark " style="width: 100%;"
								data-toggle="modal" data-target="#createGroup">Create
								Group</button>
						</div>
						<div class="col-md-12">
							<a href="GetRemainingGroups" class="btn btn-outline-dark"
								style="width: 100%">Browse Group</a>
						</div>
					</div>
				</div>
				<div class="col-md-8 col-sm-8 col-lg-7 wow fadeIn"
					data-wow-delay=".4s">
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
									      List<Comment> commentList = null;
									      commentList = postMap.get(post);
						%>
						<div class="row  padding-small rounded-corner"
							style="background-color: ghostwhite; margin-top: 10px;">
							<div class="col-md-2">
								<img src="<%=post.getUser().getImageURL()%>" height="100px"
									width="100px">
							</div>
							<div class="col-md-10">
								<p>
									<strong> <%=post.getCreatedBy()%></strong> <span
										style="color: orange">Posted At &nbsp;</span><span style="font-size: small;"><%=post.getDatePosted() %></span>
									
								</p>
								<h3>
									<p style="word-break: break-all;"
										id="post<%=post.getPostId()%>"><%=post.getPostDetails()%></p>
										
										<%
										if(userObject.getUserId()==post.getUser().getUserId()){
									%>
									<input type="hidden" id="<%=post.getPostId()%>"
										value="<%=post.getPostDetails()%>">
									<%-- <a href="#" role="button" class="btn popovers"
									data-toggle="popover" title="Edit"
									data-content="<ul><li><a href='javascript:editPost(<%=post.getPostId()%>)'>Edit Post</a></li><li><a href='DeletePost?postId=<%=post.getPostId()%>'>Delete Post</a></li></ul>"
									data-original-title="test title"> --%>
									<a href="#"><i class="fa fa-pencil-square-o"
										id="editPostButton<%=post.getPostId()%>"
										onclick="buttonPress(<%=post.getPostId()%>)"></i></a> <span
										class="editPost<%=post.getPostId()%>" style="display: none">
										<a class="btn-sm btn-outline-dark"
										href='javascript:editPost(<%=post.getPostId()%>)'>Edit
											Post</a> <a class="btn-sm btn-outline-dark"
										href='DeletePost?postId=<%=post.getPostId()%>'>Delete Post</a>
									</span>
									<%
										}
									%>
								</h3>
								<div id="editDiv<%=post.getPostId()%>" style="display: none">
									<textarea id="editContent<%=post.getPostId()%>"
										class="form-control" value="hi" style="resize: none"></textarea>
									<input type="hidden" id="postId<%=post.getPostId()%>" value="">
									<button class="btn-sm btn-outline-dark"
										id="updateButton<%=post.getPostId()%>"
										onclick="updatePost(<%=post.getPostId()%>)">Update</button>
								</div>
								<%
									if(likeMap.get(post)){
								%>
								<span id="demo<%=post.getPostId()%>"> <a href="#"> <i
										class="fa fa-thumbs-up" id="like<%=post.getPostId()%>"
										onClick="loadInfo(<%=post.getPostId()%>)"
										value="<%=post.getPostId()%>" style="color: grey"></i></a> <%=post.getLikes()%>
								</span>
								<%
									}else{
								%>
								<span id="demo<%=post.getPostId()%>"> <a href="#"> <i
										class="fa fa-thumbs-up" id="like<%=post.getPostId()%>"
										onClick="loadInfo(<%=post.getPostId()%>)"
										value="<%=post.getPostId()%>" style="color: orange"></i></a> <%=post.getLikes()%>
								</span>
								<%
									}
								%>
								<%-- <a href="LikeController?postID=<%out.println(post.getPostId()); %>" class="button"> --%>
								<%
									for(Comment comment : commentList){
								%>
								<div class="col-md-12">
									<div class="row rounded-corner padding-smallComment"
										id="comment"background-color: #F6F7F8;">
										<div class="col-md-2">
											<img src="<%=comment.getUser().getImageURL()%>" height="50px"
												width="50px">
										</div>
										<div class="col-md-10">
											<p>
												<b> <i><%=comment.getCreatedBy()%></i></b><span
													Style="color: blue;">Commented</span> <input type="hidden"
													id="commentId<%=comment.getCommentId()%>"
													value="<%=comment.getComments()%>">
												<%
													if(userObject.getUserId()==comment.getUser().getUserId()){
												%>
												<a href="#"><i
													class="fa fa-pencil-square-o editCommentButton<%=comment.getCommentId()%>"
													onclick="commentButtonPress(<%=comment.getCommentId()%>)"></i></a>
												<span class="editComment<%=comment.getCommentId()%>"
													style="display: none"> <a
													class="btn-sm btn-outline-dark"
													href='javascript:editComment(<%=comment.getCommentId()%>)'>Edit
														Comment</a> <a class="btn-sm btn-outline-dark"
													href='DeleteComment?commentId=<%=comment.getCommentId()%>'>Delete
														Comment</a>
												</span>
												<%
													}
												%>
											</p>
											<pre style="word-break: break-all;"
												id="comment<%=comment.getCommentId()%>"><%=comment.getComments()%></pre>
											<div id="editCommentDiv<%=comment.getCommentId()%>"
												style="display: none">
												<textarea
													id="editCommentContent<%=comment.getCommentId()%>"
													class="form-control" value="hi" style="resize: none"
													required="required"></textarea>
												<input type="hidden"
													id="commentId<%=comment.getCommentId()%>" value="">
												<button class="btn-sm btn-outline-dark"
													id="updateCommentButton<%=comment.getCommentId()%>"
													onclick="updateComment(<%=comment.getCommentId()%>)">Update</button>
											</div>
										</div>
									</div>
								</div>
								<%
									}
								%>
								<form
									action="AddComment?postID=<%out.println(post.getPostId());%>"
									method="post">
									<textarea name="comment" placeholder="Add your comments here"
										class="form-control" required="required" style="resize: none"></textarea>
									<button type="submit" class="btn btn-outline-dark btn-small"
										style>comment</button>
								</form>
							</div>
						</div>
						<%
							}
						%>
						<% postAvailabilityIndicator = "Posts available";
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
							<a href="javascript:loadPosts(<%=0%>)"
								class="btn btn-outline-dark text-center" id="loadMore">loadMore</a>
						</div>
					</div>
					<%} %>
				</div>
				<div class="col-md-3 col-sm-6 col-lg-3 wow fadeIn"
					data-wow-delay=".8s" id="result">
					<div class="about-content text-center">
						<i class="fa fa-users fa-2x"></i>
						<h3>People Following You</h3>
						<%
							List<User> followerList = (List<User>) request.getAttribute("followerList");
						                        			    for(User followerListIteration : followerList){
						%>
						<div class="col-md-12">
							<p><%=followerListIteration.getName()%></p>
						</div>
						<%


						                        			    }
						%>
					</div>
				</div>
			</div>
		</div>
	</section>
	<div id="createGroup" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Create Group</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-6">
							<form action="CreateGroup" method="post" class="form" role="form">
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label for="name" class="control-label">Group Name</label> <input
												type="text" name="groupName" id="groupName"
												class="form-control" placeholder="Enter Group Name" required>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<input type="Submit"
											class="btn btn-success col-lg-offset-2 col-lg-8"
											Value="Create Group">
									</div>
								</div>
							</form>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<img class="img-responsive" src="assets/img/groupPhoto.png">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Style Switcher -->
	<!-- Core Scripts -->
	<script src="assets/js/jquery.js"></script>
	<script src="assets/js/bootstrap/bootstrap.min.js"></script>
	<!-- Plugin Scripts -->
	<script src="assets/js/plugins/jquery.easing.min.js"></script>
	<script src="assets/js/plugins/classie.js"></script>
	<script src="assets/js/plugins/cbpAnimatedHeader.js"></script>
	<script src="assets/js/plugins/owl-carousel/owl.carousel.js"></script>
	<script
		src="assets/js/plugins/jquery.magnific-popup/jquery.magnific-popup.min.js"></script>
	<script src="assets/js/plugins/background/core.js"></script>
	<script src="assets/js/plugins/background/transition.js"></script>
	<script src="assets/js/plugins/background/background.js"></script>
	<script src="assets/js/plugins/jquery.mixitup.js"></script>
	<script src="assets/js/plugins/wow/wow.min.js"></script>
	<script src="assets/js/contact_me.js"></script>
	<script src="assets/js/plugins/jqBootstrapValidation.js"></script>
	<!-- Vitality Theme Scripts -->
	<script src="assets/js/vitality.js"></script>
	<!-- Style Switcher Scripts - Demo Purposes Only! -->
	<script src="assets/demo/style.switcher.js"></script>
	<script>
    $(document).ready(function(){
        $("#search").keypress(function(){
            $("#searchBlock").css("display", "list-item");
        });
        $("#searchBlock").mouseleave(function(){
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
