/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.monitoring;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * @author Michael C. Han
 */
public interface DataSampleFactory {

	public DataSample createPortalRequestDataSample(
		long companyId, long groupId, String referer, String remoteAddr,
		String remoteUser, String requestURI, String requestURL,
		String userAgent);

	public DataSample createPortletRequestDataSample(
		PortletRequestType requestType, PortletRequest portletRequest,
		PortletResponse portletResponse);

	public DataSample createServiceRequestDataSample(
		MethodSignature methodSignature);

}