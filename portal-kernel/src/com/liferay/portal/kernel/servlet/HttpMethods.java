/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet;

/**
 * Provides constants for HTTP request methods specified in <a
 * href="http://www.rfc-base.org/rfc-2616.html">RFC 2616 Section 5.1.1</a>.
 *
 * @author Brian Wing Shun Chan
 */
public interface HttpMethods {

	public static final String CONNECT = "CONNECT";

	public static final String DELETE = "DELETE";

	public static final String GET = "GET";

	public static final String HEAD = "HEAD";

	public static final String OPTIONS = "OPTIONS";

	public static final String POST = "POST";

	public static final String PUT = "PUT";

	public static final String TRACE = "TRACE";

}