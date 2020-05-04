/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.http;

import java.io.IOException;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

/**
 * @author Michael C. Han
 */
public class HttpRequestInterceptorWrapper
	implements Comparable<HttpRequestInterceptorWrapper>,
			   HttpRequestInterceptor {

	public HttpRequestInterceptorWrapper(
		HttpRequestInterceptor httpRequestInterceptor, int sortOrder) {

		_httpRequestInterceptor = httpRequestInterceptor;
		_sortOrder = sortOrder;
	}

	@Override
	public int compareTo(
		HttpRequestInterceptorWrapper httpRequestInterceptorWrapper) {

		Integer sortOrder = _sortOrder;

		return sortOrder.compareTo(
			httpRequestInterceptorWrapper.getSortOrder());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		return _httpRequestInterceptor.equals(obj);
	}

	public int getSortOrder() {
		return _sortOrder;
	}

	@Override
	public int hashCode() {
		return _httpRequestInterceptor.hashCode();
	}

	@Override
	public void process(HttpRequest httpRequest, HttpContext httpContext)
		throws HttpException, IOException {

		_httpRequestInterceptor.process(httpRequest, httpContext);
	}

	private final HttpRequestInterceptor _httpRequestInterceptor;
	private final int _sortOrder;

}