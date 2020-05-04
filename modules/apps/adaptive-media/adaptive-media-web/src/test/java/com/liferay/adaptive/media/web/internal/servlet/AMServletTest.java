/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.web.internal.servlet;

import com.liferay.adaptive.media.exception.AMException;
import com.liferay.adaptive.media.handler.AMRequestHandler;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;

import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

import org.mockito.Mockito;

/**
 * @author Adolfo Pérez
 */
public class AMServletTest {

	@Before
	public void setUp() {
		ReflectionTestUtil.setFieldValue(
			_amServlet, "_amRequestHandlerLocator", _amRequestHandlerLocator);
	}

	@Test
	public void testMiscellaneousError() throws Exception {
		Mockito.when(
			_httpServletRequest.getPathInfo()
		).thenReturn(
			RandomTestUtil.randomString()
		);

		Mockito.when(
			_amRequestHandlerLocator.locateForPattern(Mockito.anyString())
		).thenReturn(
			_amRequestHandler
		);

		Mockito.when(
			_amRequestHandler.handleRequest(_httpServletRequest)
		).thenThrow(
			new IllegalArgumentException()
		);

		_amServlet.doGet(_httpServletRequest, _httpServletResponse);

		Mockito.verify(
			_httpServletResponse
		).sendError(
			Mockito.eq(HttpServletResponse.SC_BAD_REQUEST), Mockito.anyString()
		);
	}

	@Test
	public void testNoMediaFound() throws Exception {
		Mockito.when(
			_httpServletRequest.getPathInfo()
		).thenReturn(
			RandomTestUtil.randomString()
		);

		Mockito.when(
			_amRequestHandlerLocator.locateForPattern(Mockito.anyString())
		).thenReturn(
			_amRequestHandler
		);

		Mockito.when(
			_amRequestHandler.handleRequest(_httpServletRequest)
		).thenReturn(
			Optional.empty()
		);

		_amServlet.doGet(_httpServletRequest, _httpServletResponse);

		Mockito.verify(
			_httpServletResponse
		).sendError(
			Mockito.eq(HttpServletResponse.SC_NOT_FOUND), Mockito.anyString()
		);
	}

	@Test
	public void testNoMediaFoundWithException() throws Exception {
		Mockito.when(
			_httpServletRequest.getPathInfo()
		).thenReturn(
			RandomTestUtil.randomString()
		);

		Mockito.when(
			_amRequestHandlerLocator.locateForPattern(Mockito.anyString())
		).thenReturn(
			_amRequestHandler
		);

		Mockito.when(
			_amRequestHandler.handleRequest(_httpServletRequest)
		).thenThrow(
			AMException.AMNotFound.class
		);

		_amServlet.doGet(_httpServletRequest, _httpServletResponse);

		Mockito.verify(
			_httpServletResponse
		).sendError(
			Mockito.eq(HttpServletResponse.SC_NOT_FOUND), Mockito.anyString()
		);
	}

	@Test
	public void testNoPermissionError() throws Exception {
		Mockito.when(
			_httpServletRequest.getPathInfo()
		).thenReturn(
			RandomTestUtil.randomString()
		);

		Mockito.when(
			_amRequestHandlerLocator.locateForPattern(Mockito.anyString())
		).thenReturn(
			_amRequestHandler
		);

		Mockito.when(
			_amRequestHandler.handleRequest(_httpServletRequest)
		).thenThrow(
			new ServletException(new PrincipalException())
		);

		_amServlet.doGet(_httpServletRequest, _httpServletResponse);

		Mockito.verify(
			_httpServletResponse
		).sendError(
			Mockito.eq(HttpServletResponse.SC_FORBIDDEN), Mockito.anyString()
		);
	}

	@Test
	public void testNoRequestHandlerFound() throws Exception {
		Mockito.when(
			_httpServletRequest.getPathInfo()
		).thenReturn(
			RandomTestUtil.randomString()
		);

		Mockito.when(
			_amRequestHandlerLocator.locateForPattern(Mockito.anyString())
		).thenReturn(
			null
		);

		_amServlet.doGet(_httpServletRequest, _httpServletResponse);

		Mockito.verify(
			_httpServletResponse
		).sendError(
			Mockito.eq(HttpServletResponse.SC_NOT_FOUND), Mockito.anyString()
		);
	}

	private final AMRequestHandler<?> _amRequestHandler = Mockito.mock(
		AMRequestHandler.class);
	private final AMRequestHandlerLocator _amRequestHandlerLocator =
		Mockito.mock(AMRequestHandlerLocator.class);
	private final AMServlet _amServlet = new AMServlet();
	private final HttpServletRequest _httpServletRequest = Mockito.mock(
		HttpServletRequest.class);
	private final HttpServletResponse _httpServletResponse = Mockito.mock(
		HttpServletResponse.class);

}