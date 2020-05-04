/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.servlet;

import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.servlet.DisplayChart;

/**
 * @author Samuel Kong
 */
public class DisplayChartServlet extends DisplayChart {

	@Override
	public void service(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws IOException, ServletException {

		try {
			super.service(httpServletRequest, httpServletResponse);
		}
		catch (Exception exception) {
			PortalUtil.sendError(
				HttpServletResponse.SC_NOT_FOUND, exception, httpServletRequest,
				httpServletResponse);
		}
	}

}