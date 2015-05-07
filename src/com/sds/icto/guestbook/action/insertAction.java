package com.sds.icto.guestbook.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.guestbook.dao.GuestbookDao;
import com.sds.icto.guestbook.vo.GuestbookVo;
import com.sds.icto.web.Action;

public class insertAction implements Action {

	public insertAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		// TODO Auto-generated method stub
		
		// 한글처리
		request.setCharacterEncoding( "utf-8" );

		// 메세지 등록
		String name = request.getParameter( "name" );
		String password = request.getParameter( "pass" );
		String message = request.getParameter( "content" );

		GuestbookVo vo = new GuestbookVo();
		vo.setName( name );
		vo.setPassword(password);
		vo.setMessage(message);

		GuestbookDao dao = new GuestbookDao();
		dao.insert(vo);

		//리다이렉트
		response.sendRedirect( "/GuestBook2/GB" );
	}

}
