/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 */
public class InvokerPortletResponse implements Serializable {

	public InvokerPortletResponse(String title, String content, long time) {
		_title = title;
		_content = content;
		_time = time;
	}

	public String getContent() {
		return _content;
	}

	public long getTime() {
		return _time;
	}

	public String getTitle() {
		return _title;
	}

	public void setContent(String content) {
		_content = content;
	}

	public void setTime(long time) {
		_time = time;
	}

	public void setTitle(String title) {
		_title = title;
	}

	private String _content;
	private long _time;
	private String _title;

}