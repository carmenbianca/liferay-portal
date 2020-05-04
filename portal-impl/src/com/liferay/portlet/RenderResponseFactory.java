/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet;

import com.liferay.portal.kernel.portlet.LiferayRenderResponse;
import com.liferay.portlet.internal.RenderRequestImpl;
import com.liferay.portlet.internal.RenderResponseImpl;

import javax.portlet.RenderRequest;
import javax.portlet.filter.RenderRequestWrapper;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Brian Wing Shun Chan
 * @author Neil Griffin
 */
public class RenderResponseFactory {

	public static LiferayRenderResponse create() {
		return new RenderResponseImpl();
	}

	public static LiferayRenderResponse create(
		HttpServletResponse httpServletResponse, RenderRequest renderRequest) {

		while (renderRequest instanceof RenderRequestWrapper) {
			RenderRequestWrapper renderRequestWrapper =
				(RenderRequestWrapper)renderRequest;

			renderRequest = renderRequestWrapper.getRequest();
		}

		RenderResponseImpl renderResponseImpl = new RenderResponseImpl();

		renderResponseImpl.init(
			(RenderRequestImpl)renderRequest, httpServletResponse);

		return renderResponseImpl;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #create(HttpServletResponse, RenderRequest)}
	 */
	@Deprecated
	public static LiferayRenderResponse create(
		RenderRequest renderRequest, HttpServletResponse httpServletResponse) {

		return create(httpServletResponse, renderRequest);
	}

}