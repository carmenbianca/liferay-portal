/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.test.mail;

import java.util.Iterator;

/**
 * @author Adam Brandizzi
 */
public interface MailMessage {

	public String getBody();

	public String getFirstHeaderValue(String headerName);

	public Iterator<String> getHeaderNames();

	public String[] getHeaderValues(String headerName);

}