/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.webdav.methods;

import com.liferay.portal.kernel.flash.FlashMagicBytesUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.webdav.Resource;
import com.liferay.portal.kernel.webdav.WebDAVException;
import com.liferay.portal.kernel.webdav.WebDAVRequest;
import com.liferay.portal.kernel.webdav.WebDAVStorage;
import com.liferay.portal.kernel.webdav.methods.Method;

import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Brian Wing Shun Chan
 * @author Alexander Chow
 */
public class GetMethodImpl implements Method {

	@Override
	public int process(WebDAVRequest webDAVRequest) throws WebDAVException {
		InputStream is = null;

		try {
			WebDAVStorage storage = webDAVRequest.getWebDAVStorage();

			Resource resource = storage.getResource(webDAVRequest);

			if (resource == null) {
				return HttpServletResponse.SC_NOT_FOUND;
			}

			try {
				is = resource.getContentAsStream();
			}
			catch (Exception exception) {
				_log.error(exception.getMessage());
			}

			if (is != null) {
				String fileName = resource.getDisplayName();

				FlashMagicBytesUtil.Result flashMagicBytesUtilResult =
					FlashMagicBytesUtil.check(is);

				if (flashMagicBytesUtilResult.isFlash()) {
					fileName = FileUtil.stripExtension(fileName) + ".swf";
				}

				is = flashMagicBytesUtilResult.getInputStream();

				try {
					ServletResponseUtil.sendFileWithRangeHeader(
						webDAVRequest.getHttpServletRequest(),
						webDAVRequest.getHttpServletResponse(), fileName, is,
						resource.getSize(), resource.getContentType());
				}
				catch (Exception exception) {
					if (_log.isWarnEnabled()) {
						_log.warn(exception, exception);
					}
				}

				return HttpServletResponse.SC_OK;
			}

			return HttpServletResponse.SC_NOT_FOUND;
		}
		catch (Exception exception) {
			throw new WebDAVException(exception);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(GetMethodImpl.class);

}