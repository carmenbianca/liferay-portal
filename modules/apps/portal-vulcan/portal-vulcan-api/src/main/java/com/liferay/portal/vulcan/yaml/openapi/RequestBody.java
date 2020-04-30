/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.yaml.openapi;

import java.util.Map;

/**
 * @author Peter Shin
 */
public class RequestBody {

	public Map<String, Content> getContent() {
		return _content;
	}

	public void setContent(Map<String, Content> content) {
		_content = content;
	}

	private Map<String, Content> _content;

}