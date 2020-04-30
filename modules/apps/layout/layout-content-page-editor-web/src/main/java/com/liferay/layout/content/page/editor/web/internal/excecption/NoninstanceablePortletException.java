/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.content.page.editor.web.internal.excecption;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Eudaldo Alonso
 */
public class NoninstanceablePortletException extends PortalException {

	public NoninstanceablePortletException(String portletId) {
		_portletId = portletId;
	}

	public String getPortletId() {
		return _portletId;
	}

	public void setPortletId(String portletId) {
		_portletId = portletId;
	}

	private String _portletId;

}