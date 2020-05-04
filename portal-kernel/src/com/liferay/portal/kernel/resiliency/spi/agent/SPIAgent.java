/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.resiliency.spi.agent;

import com.liferay.portal.kernel.resiliency.PortalResiliencyException;
import com.liferay.portal.kernel.resiliency.spi.SPI;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Shuyang Zhou
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 */
@Deprecated
public interface SPIAgent {

	public void destroy();

	public void init(SPI spi) throws PortalResiliencyException;

	public HttpServletRequest prepareRequest(
			HttpServletRequest httpServletRequest)
		throws IOException;

	public HttpServletResponse prepareResponse(
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse);

	public void service(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws PortalResiliencyException;

	public void transferResponse(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, Exception exception)
		throws IOException;

	public enum Lifecycle {

		ACTION("0"), EVENT("1"), RENDER("2"), RESOURCE("3");

		public String getValue() {
			return _value;
		}

		private Lifecycle(String value) {
			_value = value;
		}

		private final String _value;

	}

}