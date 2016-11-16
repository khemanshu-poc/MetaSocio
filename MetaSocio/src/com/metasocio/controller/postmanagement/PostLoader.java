package com.metasocio.controller.postmanagement;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.model.commentmanagement.Comment;
import com.metasocio.model.postmanagement.Post;
import com.metasocio.model.usermanagement.User;
import com.metasocio.service.commentmanagement.CommentService;
import com.metasocio.service.likemanagement.LikeService;
import com.metasocio.service.postmanagement.PostService;

/**
 * Servlet implementation class PostLoader
 */
@WebServlet("/PostLoader")
public class PostLoader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostLoader() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int startIndex = Integer.parseInt(request.getParameter("startIndex"));
		
		int groupId = Integer.parseInt(request.getParameter("groupId"));
		int maxResult = 2;
		try {
			
			PostService iPostService=new PostService();
			CommentService iCommentService=new CommentService();
			Map<Post, List<Comment>> postMap = new LinkedHashMap<Post, List<Comment>>();
		   List<Post> postList = null;
		   List<Comment> commentList = null;
		   postList = iPostService.retrievePostWithImageOnHome(startIndex,maxResult,groupId);
		   System.out.println(postList);
		   Map<Post, Boolean> likeMap  = new LinkedHashMap<Post, Boolean>(); 
		   Map<Integer, String> imageMap = new HashMap<Integer, String>();
		   LikeService iLikeService=new LikeService();
		   User user=new User();
		   HttpSession session=request.getSession(false);
		   user = (User) session.getAttribute("userObject");
		   for(Post post:postList){ 
			   boolean isLikedByUser = iLikeService.hasUSerAlreadyLiked(user.getUserId(),post.getPostId());
			   likeMap.put(post, isLikedByUser);
			  commentList = iCommentService.retrieveCommentListWithImageByPostID(post.getPostId());
			  for(Comment comments : commentList){
					System.out.println("Crud Comments " + comments.getComments());
				}
			  postMap.put(post, commentList);
		   }
		   
		   
		   
		   

		
		   
		   String result = "";
		   
		
			if(!postMap.isEmpty())
			{
				 Iterator iterator = postMap.keySet().iterator();

			   while (iterator.hasNext()) {
			      Post post = (Post) iterator.next();
			      List<Comment> postCommentList = null;
			      postCommentList = postMap.get(post);
			 
			     
			result += "<div class='row  padding-small rounded-corner' style='background-color:ghostwhite;margin-top: 10px;'>"
					+ "<div class='col-md-2'>"
					+ "<img src='"+post.getUser().getImageURL() +"' height='100px' width='100px'>"
							+ "</div>"
							+ "<div class='col-md-10'>"
							+ "<p>"
							+ "<strong>"+post.getCreatedBy()+"</strong>"
									+ " <span style='color: orange'>Posted</span>";
						
						if(user.getUserId()==post.getUser().getUserId()){ 
						
					result +=  "<input type='hidden' id='"+post.getPostId()+"' value='"+post.getPostDetails()+"'>"
							+ "<a href='#'>"
							+ "<i class='fa fa-pencil-square-o fa-2x' id='editPostButton"+post.getPostId()+"' onclick='buttonPress("+post.getPostId()+")'></i>"
							+ "</a>"
							+ "<span class='editPost"+post.getPostId()+"' style='display: none'>"
							+ "<a class='btn-sm btn-outline-dark' href='javascript:editPost("+post.getPostId()+")'>Edit Post</a>"
							+ "<a class='btn-sm btn-outline-dark' href='DeletePost?postId="+post.getPostId()+"'>Delete Post</a>"
							+ "</span>";
							/*+ "<script>"
							+ "function buttonPress("+postId+"){"
						   + "$('.editPost'"+postId").show();
					}
					
				</script>;
						*/
							}
						
						result += "</p>"
								+ "<h3>"
								+ "<p style='word-break: break-all;' id='post"+post.getPostId()+"'>"+post.getPostDetails()+"</p>"
								+ "</h3>"
								+ "<div id='editDiv"+post.getPostId()+"' style='display:none'>"
								+ "<textarea id='editContent"+post.getPostId()+"' class='form-control' required='required' value='hi' style='resize:none'></textarea>"
								+ "<input type='hidden' id='postId"+post.getPostId()+"' value=''>"
								+ "<button class='btn-sm btn-outline-dark' id='updateButton"+post.getPostId()+"'  onclick='updatePost("+post.getPostId()+")'>Update</button>"
								+ "</div>";
					
					
						if(likeMap.get(post)){
							
							result += "<span id='demo"+post.getPostId()+"'>"
									+ "<a href='#'>"
									+ "<i class='fa fa-thumbs-up' id ='like"+post.getPostId()+"' onClick='loadInfo("+post.getPostId()+")' value='"+post.getPostId()+"' style='color:orange'></i>"
									+ "</a>"+post.getLikes()+""
									+ "</span>";

						}else{
						
							result += "<span id='demo"+post.getPostId()+"'>"
									+ "<a href='#'>"
									+ "<i class='fa fa-thumbs-up' id ='like"+post.getPostId()+"' onClick='loadInfo("+post.getPostId()+")' value='"+post.getPostId()+"' style='color:grey'></i>"
									+ "</a>"+post.getLikes()+"</span>";
					
					
					}
				
					 for(Comment postComment : postCommentList){
					
						 result += "<div class='col-md-12' >"
								 
								 
								 
								 
								 
								 
						 		+ "<div class='row rounded-corner padding-smallComment' id='comment' background-color: #F6F7F8;'>"
						 		
						 		
						 		
						 		
						 		
						 		+ "<div class='col-md-2'>"
						 		+ "<img src='"+postComment.getUser().getImageURL()+"' height='50px' width='50px'>"
						 		+ "</div>"
						 		+ "<div class='col-md-10'>"
						 		+ "<p>"
						 		+ "<b>"
						 		+ "<i>"+postComment.getCreatedBy()+"</i>"
						 		+ "</b>"
						 		+ "<span Style='color:blue;'>Commented</span> "
						 		+ "<input type='hidden' id='commentId"+postComment.getCommentId()+"' value='"+postComment.getComments()+"'>";
						
						 
						 
					
						
						if(user.getUserId()==postComment.getUser().getUserId()){
						
							
						
							
							
							
							
							 result += "<a href='#'>"
							 		+ "<i class='fa fa-pencil-square-o fa-2x editCommentButton"+postComment.getCommentId()+"' onclick='commentButtonPress("+postComment.getCommentId()+")'></i>"
							 		+ "</a>"
							 		+ "<span class='editComment"+postComment.getCommentId()+"' style='display: none'>"
							 		+ "<a class='btn-sm btn-outline-dark' href='javascript:editComment("+postComment.getCommentId()+")'>Edit Comment</a>"
							 		+ "<a class='btn-sm btn-outline-dark' href='DeleteComment?commentId="+postComment.getCommentId()+"'>Delete Comment</a>"
							 		+ "</span>";
									

                                      
									 
							 		/*"data-content='<ul><li><a href='javascript:editComment(<%=comment.getCommentId()%>)'>Edit Comment</a></li><li><a href='DeleteComment?commentId=<%=comment.getCommentId()%>'>Delete Comment</a></li></ul>'
										data-original-title="test title"><i class="fa fa-pencil-square-o fa-2x" ></i></a>*/

                            }
						



						



						 result += "</p>"
						 		+ "<pre style='word-break: break-all;' id='comment"+postComment.getCommentId()+"'>"+postComment.getComments()+"></pre>"
						 	    + "<div id='editCommentDiv"+postComment.getCommentId()+"' style='display:none'>"
						 	    + "<textarea id='editCommentContent"+postComment.getCommentId()+"' class='form-control'  required='required' value='hi' style='resize:none'></textarea>"
						 	    + "<input type='hidden' id='commentId"+postComment.getCommentId()+"' value=''>"
						 	    + "<button class='btn-sm btn-outline-dark' id='updateCommentButton"+postComment.getCommentId()+"' onclick='updateComment("+postComment.getCommentId()+")'>Update</button>"
						 	    + "</div>"
						 		+ "</div>"
						 		+ "</div>"
						 		+ "</div>";


				}
			   result += "<form action='AddComment?postID="+post.getPostId()+"' method='post'>"
			   		+ "<textarea name='comment' placeholder='Add your comments here' class='form-control' required='required' style='resize:none'></textarea>"
			   		+ "<button type='submit' class='btn btn-outline-dark btn-small' style>comment</button>"
			   		+ "</form>"
			   		+ "</div>"
			   		+ "<div class='col-md-12'>"
			   		+ "</div>"
			   		+ "</div>";
				}
					
				}
			else{
				
				 result ="";
			
			}
			
	
		   response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(result);
		
		} catch (MetaSocioSystemException e) {
			// TODO Auto-generated catch block
			//System.out.println("[" + e.getMessage() + "]");
			request.setAttribute("message", "[" + e.getMessage() + "]");
			request.getRequestDispatcher("./exception/error.jsp").forward(
					request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServ
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
