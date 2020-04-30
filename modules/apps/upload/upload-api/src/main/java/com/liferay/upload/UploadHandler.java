/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.upload;

import com.liferay.portal.kernel.exception.PortalException;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * @author Alejandro Tardín
 */
public interface UploadHandler {

	public void upload(
			UploadFileEntryHandler uploadFileEntryHandler,
			UploadResponseHandler uploadResponseHandler,
			PortletRequest portletRequest, PortletResponse portletResponse)
		throws PortalException;

}