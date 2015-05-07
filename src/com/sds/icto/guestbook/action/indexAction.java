package com.sds.icto.guestbook.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sds.icto.guestbook.dao.GuestbookDao;
import com.sds.icto.guestbook.vo.GuestbookVo;
import com.sds.icto.web.Action;
import com.sds.icto.web.WebUtil;

public class indexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, 
			ClassNotFoundException, 
			ServletException,
			IOException {
		// TODO Auto-generated method stub

		
		GuestbookDao dao = new GuestbookDao();
		List<GuestbookVo> list = dao.fetchList();
				
		//리퀘스트로 포워드에 달아놓는다.
		request.setAttribute("list", list);
		//모델과 뷰를 연결시켜주는 포워드
		WebUtil.forward("/View/index.jsp", request, response);
	}

}
