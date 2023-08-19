package com.instruments.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.instruments.dao.InstrumentsDao;
import com.instruments.model.Instrument;

/**
 * Servlet implementation class InstrumentUpdateServlet
 */
@WebServlet("/InstrumentUpdateServlet")
public class InstrumentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private InstrumentsDao instrumentDao = new InstrumentsDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InstrumentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ID =request.getParameter("ID");
		Instrument instrument;
		
		try {
            instrument = instrumentDao.getInstrument(ID);
            request.setAttribute("instrument", instrument);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		RequestDispatcher dis =request.getRequestDispatcher("update.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String name = request.getParameter("name");
        String price = request.getParameter("price");
        String des = request.getParameter("des");
        String category = request.getParameter("category");
        String warrenty = request.getParameter("warrenty");
        
        int convertedId = Integer.parseInt(id);

        try {
            boolean isTrue = instrumentDao.updateInstrument(convertedId, name, price, des, category, warrenty);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        RequestDispatcher dis =request.getRequestDispatcher("allInstruments.jsp");
		dis.forward(request, response);
	}

}
