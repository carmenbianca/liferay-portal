/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.upload;

import javax.portlet.PortletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public interface UploadPortletRequest extends UploadRequest {

	public PortletRequest getPortletRequest();

}