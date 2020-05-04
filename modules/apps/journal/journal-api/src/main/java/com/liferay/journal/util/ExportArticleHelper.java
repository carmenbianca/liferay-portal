/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.util;

import java.io.IOException;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * @author Tom Wang
 */
public interface ExportArticleHelper {

	public void sendFile(
			String targetExtension, PortletRequest portletRequest,
			PortletResponse portletResponse)
		throws IOException;

}