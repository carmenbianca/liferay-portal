/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.osgi.web.servlet.context.helper.internal.order;

/**
 * @author Vernon Singleton
 * @author Juan González
 */
public class OrderMaxAttemptsException extends Exception {

	public OrderMaxAttemptsException(int limit) {
		super("Exceeded the limit of " + limit + " maximum attempts");
	}

}