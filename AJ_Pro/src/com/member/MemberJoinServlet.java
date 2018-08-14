package com.member;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dto.MemberDTO;
import com.service.MemberService;


@WebServlet("/MemberJoinServlet")
public class MemberJoinServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 DiskFileItemFactory factory = new DiskFileItemFactory();

			// Configure a repository (to ensure a secure temp location is used)
		
			 ServletContext ctx =getServletContext();		
			File repository = (File) ctx.getAttribute("javax.servlet.context.tempdir"); // new File("c://temp") 임시파일 경로
			factory.setRepository(repository);

			
			 ServletFileUpload upload = new ServletFileUpload(factory);
		        // If file size exceeds, a FileUploadException will be thrown
			 upload.setSizeMax(1024*1024*5); //업로드 되는 전체 파일크기 제한
			 upload.setFileSizeMax(1024*1024*2); // 개별 파일의 max값 제한

		        List fileItems = null;
				try {
					fileItems = upload.parseRequest(request);
				} catch (FileUploadException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		        Iterator<FileItem> itr = fileItems.iterator();
		        
		        ArrayList<String> fileNames = new ArrayList<>();
		        
		        String fileName = null;
		        String comment = null;
		       String um_photo = null;
		       String um_photo_bg = null;
		       
		       ArrayList<String> arr = new ArrayList<>();
		        while(itr.hasNext()) {
		          FileItem fi = itr.next();

		          if( !fi.isFormField() ) { // input type="file" 인 경우
		        	  fileName = fi.getName();
		        	  fileNames.add(fileName);
		            System.out.println("\nNAME: "+fi.getName());
		            System.out.println("SIZE: "+fi.getSize());
		           
		         
		           
		            File fullFile  = new File(fi.getName());  
		            File fNew = new File("c://upload//",fullFile.getName());
		            try {
						fi.write(fNew);
					} catch (Exception e) {
						e.printStackTrace();
					}
		          }
		          else { // input type="file" 아닌 경우
		            System.out.println("Field ="+fi.getFieldName()+"\t"+fi.getString("UTF-8"));  // getString("UTF-8") 지정해야 한글처리 가능
		            comment = fi.getString("UTF-8");
		            

					
					arr.add(fi.getString("UTF-8"));
		          }
		        }//end while  
		        
		        
		        um_photo = fileNames.get(0);
	            um_photo_bg = fileNames.get(1);
				String um_loginid =  arr.get(0);
				String um_passwd = arr.get(1);
				String um_name = arr.get(2);
				String um_email = arr.get(3);
				String um_tel = arr.get(4);
				
		        MemberDTO dto = new MemberDTO(um_loginid,um_passwd,um_name,um_email,um_tel,um_photo,um_photo_bg);
				
				MemberService service = new MemberService();
				int n = service.MemberAdd(dto);

		    	HttpSession session = request.getSession();
				session.setAttribute("success","회원가입 성공");
				session.setMaxInactiveInterval(5); // 5초가 지나면 더이상 home.jsp에서 회원가입성공이 안뜨게한다.
				response.sendRedirect("Main.jsp");
		
	}

}
