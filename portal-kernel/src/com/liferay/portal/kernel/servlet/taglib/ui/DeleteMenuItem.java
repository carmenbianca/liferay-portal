/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet.taglib.ui;

/**
 * @author Iván Zaera
 */
public class DeleteMenuItem extends MenuItem {

	public String getURL() {
		return _url;
	}

	public boolean isTrash() {
		return _trash;
	}

	public void setTrash(boolean trash) {
		_trash = trash;
	}

	public void setURL(String url) {
		_url = url;
	}

	private boolean _trash;
	private String _url;

}