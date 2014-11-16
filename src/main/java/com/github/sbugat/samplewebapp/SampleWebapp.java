package com.github.sbugat.samplewebapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Sample class of a web-app servlet
 *
 * @author Sylvain Bugat
 */
public class SampleWebapp extends HttpServlet {

	private static final long serialVersionUID = 1997452078400181160L;

	@Override
	protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {

		System.out.println("SampleWebapp class: doGet method called on:" + httpServletRequest.getRequestURI());
		httpServletRequest.setAttribute("requestedURI", httpServletRequest.getRequestURI());
		// Redirect all get request to index.jsp page
		httpServletRequest.getRequestDispatcher("/index.jsp").forward(httpServletRequest, httpServletResponse);
	}
}
