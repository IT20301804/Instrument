package com.instruments.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.instruments.dao.InstrumentsDao;
import com.instruments.model.Instrument;

/**
 * Servlet implementation class InstrumentAllViewServlet
 */
@WebServlet("/InstrumentAllViewServlet")
public class InstrumentAllViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private InstrumentsDao instrumentDao = new InstrumentsDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InstrumentAllViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Instrument> instruments = new ArrayList<>();
		try {
			instruments = instrumentDao.viewAllInstruments();
			request.setAttribute("instruments", instruments);
		}catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		RequestDispatcher dis =request.getRequestDispatcher("allInstruments.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
