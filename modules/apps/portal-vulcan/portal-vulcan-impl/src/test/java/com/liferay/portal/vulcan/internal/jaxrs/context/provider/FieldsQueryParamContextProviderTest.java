/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.internal.jaxrs.context.provider;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import com.liferay.portal.vulcan.fields.FieldsQueryParam;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.cxf.jaxrs.ext.ContextProvider;
import org.apache.cxf.message.Message;

import org.junit.Test;

import org.mockito.Mockito;

/**
 * @author Alejandro Hernández
 */
public class FieldsQueryParamContextProviderTest {

	@Test
	public void test() {

		// Null

		assertThat(_getFieldNames(null), is(nullValue()));

		// Empty

		assertThat(_getFieldNames(""), is(empty()));

		// Expanded

		assertThat(
			_getFieldNames("hello.hi.hello,potato"),
			containsInAnyOrder(
				"hello", "hello.hi", "hello.hi.hello", "potato"));

		// No duplicates

		assertThat(
			_getFieldNames("hello,hi,hello"),
			containsInAnyOrder("hello", "hi"));
	}

	private Set<String> _getFieldNames(String fieldNames) {
		ContextProvider<FieldsQueryParam> contextProvider =
			new FieldsQueryParamContextProvider();

		FieldsQueryParam fieldsQueryParam = contextProvider.createContext(
			_getMessage(fieldNames));

		return fieldsQueryParam.getFieldNames();
	}

	private Message _getMessage(String fieldNames) {
		Message message = Mockito.mock(Message.class);

		HttpServletRequest httpServletRequest = Mockito.mock(
			HttpServletRequest.class);

		Mockito.when(
			message.getContextualProperty("HTTP.REQUEST")
		).thenReturn(
			httpServletRequest
		);

		Mockito.when(
			httpServletRequest.getParameter("fields")
		).thenReturn(
			fieldNames
		);

		return message;
	}

}