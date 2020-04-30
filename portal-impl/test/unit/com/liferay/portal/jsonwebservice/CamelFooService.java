/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.jsonwebservice;

import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.servlet.HttpMethods;
import com.liferay.portal.kernel.transaction.Isolation;

/**
 * @author Igor Spasic
 */
public class CamelFooService {

	public static void addIsolation(Isolation isolation) {
	}

	@JSONWebService("cool-new-world")
	public static void braveNewWorld() {
	}

	public static Isolation getIsolation() {
		return Isolation.DEFAULT;
	}

	public static void hello() {
	}

	public static void helloWorld() {
	}

	@JSONWebService(method = HttpMethods.POST)
	public static String post(String value) {
		return "post " + value;
	}

}