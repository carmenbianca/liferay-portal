/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.yaml.openapi;

import java.util.Map;

/**
 * @author Peter Shin
 */
public class Response {

	public Map<String, Content> getContent() {
		return _content;
	}

	public String getDescription() {
		return _description;
	}

	public void setContent(Map<String, Content> content) {
		_content = content;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private Map<String, Content> _content;
	private String _description;

}