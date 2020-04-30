/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.yaml.openapi;

/**
 * @author Peter Shin
 */
public class Content {

	public Schema getSchema() {
		return _schema;
	}

	public void setSchema(Schema schema) {
		_schema = schema;
	}

	private Schema _schema;

}