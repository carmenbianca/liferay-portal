/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.jsonwebservice;

/**
 * @author Miguel Pastor
 */
public interface JSONWebServiceRegistratorBuilder {

	public JSONWebServiceRegistrator build(
		JSONWebServiceScannerStrategy jsonWebServiceScannerStrategy);

}