/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.web.internal.display.context.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.mock.web.MockHttpServletRequest;

/**
 * @author Cristina González
 */
public class MockHttpServletRequestBuilder {

	public MockHttpServletRequestBuilder() {
	}

	public MockHttpServletRequest build() {
		MockHttpServletRequest mockHttpServletRequest =
			new MockHttpServletRequest();

		Set<Map.Entry<String, Object>> entries = _attributes.entrySet();

		entries.forEach(
			entry -> mockHttpServletRequest.setAttribute(
				entry.getKey(), entry.getValue()));

		mockHttpServletRequest.setParameters(_parameters);

		return mockHttpServletRequest;
	}

	public MockHttpServletRequestBuilder withAttribute(
		String key, Object value) {

		_attributes.put(key, value);

		return this;
	}

	public MockHttpServletRequestBuilder withParameter(
		String key, String value) {

		_parameters.put(key, value);

		return this;
	}

	private Map<String, Object> _attributes = new HashMap<>();
	private Map<String, String> _parameters = new HashMap<>();

}