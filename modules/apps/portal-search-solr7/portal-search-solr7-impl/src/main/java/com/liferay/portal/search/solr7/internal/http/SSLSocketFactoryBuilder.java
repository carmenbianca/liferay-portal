/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.http;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;

/**
 * @author Michael C. Han
 */
public interface SSLSocketFactoryBuilder {

	public SSLConnectionSocketFactory build() throws Exception;

}