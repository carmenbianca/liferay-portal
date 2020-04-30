/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.network.utilities.web.internal.model;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 */
public class Whois implements Serializable {

	public Whois() {
	}

	public Whois(String domain, String results) {
		_domain = domain;
		_results = results;
	}

	public String getDomain() {
		return _domain;
	}

	public String getResults() {
		return _results;
	}

	public void setDomain(String domain) {
		_domain = domain;
	}

	public void setResults(String results) {
		_results = results;
	}

	private String _domain;
	private String _results;

}