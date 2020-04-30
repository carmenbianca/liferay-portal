/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.social.kernel.model;

/**
 * @author Brian Wing Shun Chan
 */
public class SocialRequestFeedEntry {

	public SocialRequestFeedEntry(String title, String body) {
		_title = title;
		_body = body;
	}

	public String getBody() {
		return _body;
	}

	public String getPortletId() {
		return _portletId;
	}

	public String getTitle() {
		return _title;
	}

	public void setBody(String body) {
		_body = body;
	}

	public void setPortletId(String portletId) {
		_portletId = portletId;
	}

	public void setTitle(String title) {
		_title = title;
	}

	private String _body;
	private String _portletId;
	private String _title;

}