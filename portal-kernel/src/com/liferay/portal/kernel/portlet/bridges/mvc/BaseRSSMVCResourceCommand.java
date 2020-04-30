/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet.bridges.mvc;

import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

/**
 * @author Eduardo García
 */
public abstract class BaseRSSMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws PortletException {

		if (isRSSFeedsEnabled(resourceRequest)) {
			try {
				PortletResponseUtil.sendFile(
					resourceRequest, resourceResponse, null,
					getRSS(resourceRequest, resourceResponse),
					ContentTypes.TEXT_XML_UTF8);
			}
			catch (Exception exception) {
				throw new PortletException(exception);
			}
		}
		else {
			try {
				PortalUtil.sendRSSFeedsDisabledError(
					resourceRequest, resourceResponse);
			}
			catch (Exception exception) {
			}
		}

		return false;
	}

	protected abstract byte[] getRSS(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws Exception;

	protected boolean isRSSFeedsEnabled(ResourceRequest resourceRequest) {
		return PortalUtil.isRSSFeedsEnabled();
	}

}