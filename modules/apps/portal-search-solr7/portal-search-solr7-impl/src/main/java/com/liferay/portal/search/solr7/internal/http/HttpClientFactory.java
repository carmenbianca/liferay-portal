/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.http;

import org.apache.http.client.HttpClient;

/**
 * @author André de Oliveira
 * @author László Csontos
 */
public interface HttpClientFactory {

	public HttpClient createInstance() throws Exception;

	public void shutdown();

}