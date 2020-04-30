/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.jsonwebservice;

/**
 * @author Miguel Pastor
 */
public class JSONWebServiceRegistratorFactory {

	public JSONWebServiceRegistrator build(
		JSONWebServiceScannerStrategy jsonWebServiceScannerStrategy) {

		return _jsonWebServiceRegistratorBuilder.build(
			jsonWebServiceScannerStrategy);
	}

	public void setJSONWebServiceRegistratorBuilder(
		JSONWebServiceRegistratorBuilder jsonWebServiceRegistratorBuilder) {

		_jsonWebServiceRegistratorBuilder = jsonWebServiceRegistratorBuilder;
	}

	private JSONWebServiceRegistratorBuilder _jsonWebServiceRegistratorBuilder;

}