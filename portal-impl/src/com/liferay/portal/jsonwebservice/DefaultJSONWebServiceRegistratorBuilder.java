/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.jsonwebservice;

import com.liferay.portal.kernel.jsonwebservice.JSONWebServiceRegistrator;
import com.liferay.portal.kernel.jsonwebservice.JSONWebServiceRegistratorBuilder;
import com.liferay.portal.kernel.jsonwebservice.JSONWebServiceScannerStrategy;

/**
 * @author Miguel Pastor
 */
public class DefaultJSONWebServiceRegistratorBuilder
	implements JSONWebServiceRegistratorBuilder {

	@Override
	public JSONWebServiceRegistrator build(
		JSONWebServiceScannerStrategy jsonWebServiceScannerStrategy) {

		return new DefaultJSONWebServiceRegistrator(
			jsonWebServiceScannerStrategy);
	}

}