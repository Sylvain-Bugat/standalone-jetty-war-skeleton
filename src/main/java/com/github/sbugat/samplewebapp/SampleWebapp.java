package com.github.sbugat.samplewebapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;

/**
 * Sample class of a web-app servlet.
 * 
 * @author Sylvain Bugat
 */
@WebServlet("/redirect")
public final class SampleWebapp extends HttpServlet {

	/** SLF4J XLogger. */
	private static final XLogger LOG = XLoggerFactory.getXLogger(SampleWebapp.class);

	/** Serialization identifier. */
	private static final long serialVersionUID = 1997452078400181160L;

	@Override
	protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {

		LOG.entry(httpServletRequest, httpServletResponse);

		LOG.info("Call with:{}", httpServletRequest.getRequestURI()); //$NON-NLS-1$
		String argumentValue = httpServletRequest.getParameter("argument"); //$NON-NLS-1$
		if (null == argumentValue || argumentValue.isEmpty()) {
			argumentValue = "redirect"; //$NON-NLS-1$
		}

		// Forward all get request to test-el.jsp page with the argument value or redirect by default
		httpServletRequest.setAttribute("requestedURI", httpServletRequest.getRequestURI()); //$NON-NLS-1$
		httpServletRequest.getRequestDispatcher("/test-el.jsp?argument=" + argumentValue).forward(httpServletRequest, httpServletResponse); //$NON-NLS-1$

		LOG.info("Redirect to: /test-el.jsp?argument={}", argumentValue); //$NON-NLS-1$

		LOG.exit();
	}
}
