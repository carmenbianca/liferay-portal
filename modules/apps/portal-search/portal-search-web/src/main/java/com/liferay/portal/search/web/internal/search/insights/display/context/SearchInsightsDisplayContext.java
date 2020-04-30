/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.search.insights.display.context;

import java.io.Serializable;

/**
 * @author Bryan Engler
 */
public class SearchInsightsDisplayContext implements Serializable {

	public String getHelpMessage() {
		return _helpMessage;
	}

	public String getRequestString() {
		return _requestString;
	}

	public String getResponseString() {
		return _responseString;
	}

	public void setHelpMessage(String helpMessage) {
		_helpMessage = helpMessage;
	}

	public void setRequestString(String queryString) {
		_requestString = queryString;
	}

	public void setResponseString(String responseString) {
		_responseString = responseString;
	}

	private String _helpMessage;
	private String _requestString;
	private String _responseString;

}