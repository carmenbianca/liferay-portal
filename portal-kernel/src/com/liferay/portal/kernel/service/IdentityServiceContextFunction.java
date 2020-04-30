/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service;

import java.util.function.Function;

/**
 * @author Adolfo Pérez
 */
public class IdentityServiceContextFunction
	implements Function<String, ServiceContext> {

	public IdentityServiceContextFunction(ServiceContext serviceContext) {
		_serviceContext = serviceContext;
	}

	@Override
	public ServiceContext apply(String s) {
		return _serviceContext;
	}

	private final ServiceContext _serviceContext;

}