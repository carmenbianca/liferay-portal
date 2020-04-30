/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.image.media.query;

/**
 * @author Alejandro Tardín
 */
public class Condition {

	public Condition(String attribute, String value) {
		_attribute = attribute;
		_value = value;
	}

	public String getAttribute() {
		return _attribute;
	}

	public String getValue() {
		return _value;
	}

	private final String _attribute;
	private final String _value;

}