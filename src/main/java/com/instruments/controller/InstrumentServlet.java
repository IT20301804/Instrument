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
 * Servlet implementation class InstrumentServlet
 */
@WebServlet("/InstrumentServlet")
public class InstrumentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private InstrumentsDao instrumentDao = new InstrumentsDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InstrumentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/addInstrument.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
        String price = request.getParameter("price");
        String des = request.getParameter("des");
        String category = request.getParameter("category");
        String warrenty = request.getParameter("warrenty");

        Instrument instrument = new Instrument(1, name, price, des, category, warrenty);

        try {
            instrumentDao.addProduct(instrument);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        request.setAttribute("instrument", instrument);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/InstrumentDetails.jsp");
		dispatcher.forward(request, response);
	}

}
