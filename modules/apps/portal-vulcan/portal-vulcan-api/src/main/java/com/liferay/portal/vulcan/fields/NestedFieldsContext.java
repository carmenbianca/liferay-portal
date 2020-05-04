/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.fields;

import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.cxf.message.Message;

/**
 * @author Ivica Cardic
 */
public class NestedFieldsContext {

	public NestedFieldsContext(
		List<String> fieldNames, Message message,
		MultivaluedMap<String, String> pathParameters, String resourceVersion,
		MultivaluedMap<String, String> queryParameters) {

		_fieldNames = fieldNames;
		_message = message;
		_pathParameters = pathParameters;
		_resourceVersion = resourceVersion;
		_queryParameters = queryParameters;
	}

	public List<String> getFieldNames() {
		return _fieldNames;
	}

	public Message getMessage() {
		return _message;
	}

	public MultivaluedMap<String, String> getPathParameters() {
		return _pathParameters;
	}

	public MultivaluedMap<String, String> getQueryParameters() {
		return _queryParameters;
	}

	public String getResourceVersion() {
		return _resourceVersion;
	}

	private final List<String> _fieldNames;
	private final Message _message;
	private final MultivaluedMap<String, String> _pathParameters;
	private final MultivaluedMap<String, String> _queryParameters;
	private final String _resourceVersion;

}