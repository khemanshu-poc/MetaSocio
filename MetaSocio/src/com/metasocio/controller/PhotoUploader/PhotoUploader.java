package com.metasocio.controller.PhotoUploader;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.metasocio.model.usermanagement.GooglePojo;
import com.metasocio.model.usermanagement.User;

/**
 * Servlet implementation class PhotoUpload
 */
@WebServlet("/PhotoUploader")
public class PhotoUploader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotoUploader() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int MAX_MEMORY_SIZE = 1024 * 1024 * 2;
		    final int MAX_REQUEST_SIZE = 1024 * 1024;
		    DiskFileItemFactory factory = new DiskFileItemFactory();
		    // Sets the size threshold beyond which files are written directly to disk.
		    factory.setSizeThreshold(MAX_MEMORY_SIZE);
		    // Sets the directory used to temporarily store files that are larger
		    // than the configured size threshold. We use temporary directory for java
		    factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		    // constructs the folder where uploaded file will be stored
		    
		    
		    String uploadFolder = "C:/Users/Pooja/Desktop/pooja project New-1/7-12/p/MetaSocio/WebContent/assets/img/people";
		    // Create a new file upload handler
		    ServletFileUpload upload = new ServletFileUpload(factory);
		    // Set overall request size constraint
		    upload.setSizeMax(MAX_REQUEST_SIZE);
		    HttpSession session = request.getSession();
		    GooglePojo userProfile = (GooglePojo) session.getAttribute("userProfile");
		    
		    try {
		    	String filePath = null;
		        // Parse the request
		        List items = upload.parseRequest(request);
		        for (Object item1 : items) {
		        	System.out.print("D");
		            FileItem item = (FileItem) item1;
		            if (!item.isFormField()) {
		                String fileName = userProfile.getEmail();
		                filePath = uploadFolder + "/" + fileName+".jpg";
		                File uploadedFile = new File(filePath);
		                // saves the file to upload directory
		                item.write(uploadedFile);
		            }
		        }
		        userProfile.setPicture("assets/img/people/"+userProfile.getEmail()+".jpg");
		        request.setAttribute("userDataObject", userProfile);
		        request.getRequestDispatcher("./view/usermanagement/profile.jsp").forward(request, response);
		    } catch (Exception e) {
		    	System.out.print(e);
		    	e.printStackTrace();
		        response.sendRedirect("error.jsp");
		    }
	}

}
