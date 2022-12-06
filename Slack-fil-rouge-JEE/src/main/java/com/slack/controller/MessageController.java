package com.slack.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slack.dao.ChatApiDAO;
import com.slack.entity.Message;

/**
 * Servlet implementation class MessageController
 */
@WebServlet("/chat")
public class MessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MessageController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Set General channel as default for starting
		request.getSession().setAttribute("channelId", 1);
		// Retrieve previous messages
		try {
			List<Message> messages = ChatApiDAO.getInstance().getAllMessages();
			request.setAttribute("messages", messages);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("Chat.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg = request.getParameter("message");

		if (!"".equals(msg)) {
			Message m = new Message(msg, new Date(), new Date(),
					(Integer) request.getSession().getAttribute("channelId"),
					(Integer) request.getSession().getAttribute("userId"));
			try {
				ChatApiDAO.getInstance().addMessage(m);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		response.sendRedirect("./chat");
	}

}
