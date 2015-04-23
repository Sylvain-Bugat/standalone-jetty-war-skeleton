package com.github.sbugat.samplewebapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Sample class of a web-app servlet.
 * 
 * @author Sylvain Bugat
 */
@WebServlet("/redirect")
public final class SampleWebapp extends HttpServlet {

	/** Serialization identifier. */
	private static final long serialVersionUID = 1997452078400181160L;

	@Override
	protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {

		System.out.println("SampleWebapp class: doGet method called on:" + httpServletRequest.getRequestURI());
		String argumentValue = httpServletRequest.getParameter("argument");
		if (null == argumentValue || argumentValue.isEmpty()) {
			argumentValue = "redirect";
		}

		// Forward all get request to test-el.jsp page with the argument value or redirect by default
		httpServletRequest.setAttribute("requestedURI", httpServletRequest.getRequestURI());
		httpServletRequest.getRequestDispatcher("/test-el.jsp?argument=" + argumentValue).forward(httpServletRequest, httpServletResponse);
	}
}
