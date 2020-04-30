/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.osgi.web.servlet.context.helper.internal.order;

/**
 * @author Vernon Singleton
 * @author Juan González
 */
public class OrderBeforeAndAfterException extends Exception {

	public OrderBeforeAndAfterException(String configName, String name) {
		super(configName + " cannot be both before and after " + name);
	}

}