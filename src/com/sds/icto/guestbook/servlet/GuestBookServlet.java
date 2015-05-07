package com.sds.icto.guestbook.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.guestbook.action.deleteAction;
import com.sds.icto.guestbook.action.indexAction;
import com.sds.icto.guestbook.action.insertAction;
import com.sds.icto.web.Action;

/**
 * Servlet implementation class GuestBookServlet
 */
@WebServlet("/GB")
public class GuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String a = request.getParameter("a");
		
			if( "delete".equals( a )){
				Action act = new deleteAction();
				try {
					act.execute(request, response);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else if("insert".equals(a)){
				Action act = new insertAction();
				try {
					act.execute(request, response);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else {
		
				Action act = new indexAction();
				try {
					act.execute(request, response);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		
		
	}

}
