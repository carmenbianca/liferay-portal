/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.webdav.methods;

import com.liferay.portal.kernel.webdav.Resource;
import com.liferay.portal.kernel.webdav.WebDAVException;
import com.liferay.portal.kernel.webdav.WebDAVRequest;
import com.liferay.portal.kernel.webdav.WebDAVStorage;
import com.liferay.portal.kernel.webdav.methods.Method;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Brian Wing Shun Chan
 * @author Alexander Chow
 */
public class HeadMethodImpl implements Method {

	@Override
	public int process(WebDAVRequest webDAVRequest) throws WebDAVException {
		try {
			WebDAVStorage storage = webDAVRequest.getWebDAVStorage();

			Resource resource = storage.getResource(webDAVRequest);

			if (resource == null) {
				return HttpServletResponse.SC_NOT_FOUND;
			}

			if (!resource.isCollection()) {
				HttpServletResponse httpServletResponse =
					webDAVRequest.getHttpServletResponse();

				httpServletResponse.setContentLength((int)resource.getSize());
			}

			return HttpServletResponse.SC_OK;
		}
		catch (Exception exception) {
			throw new WebDAVException(exception);
		}
	}

}