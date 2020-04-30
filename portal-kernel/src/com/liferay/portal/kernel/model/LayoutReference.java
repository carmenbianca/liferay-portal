/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 */
public class LayoutReference implements Serializable {

	public LayoutReference() {
	}

	public LayoutReference(LayoutSoap layoutSoap, String portletId) {
		_layoutSoap = layoutSoap;
		_portletId = portletId;
	}

	public LayoutSoap getLayoutSoap() {
		return _layoutSoap;
	}

	public String getPortletId() {
		return _portletId;
	}

	public void setLayoutSoap(LayoutSoap layoutSoap) {
		_layoutSoap = layoutSoap;
	}

	public void setPortletId(String portletId) {
		_portletId = portletId;
	}

	private LayoutSoap _layoutSoap;
	private String _portletId;

}