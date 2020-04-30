/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.ldap.internal.model.listener;

import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;

import java.io.Serializable;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

/**
 * @author Michael C. Han
 */
public class CallableUtil {

	public static Callable<Void> getCallable(
		Consumer<Map<String, Serializable>> consumer) {

		return () -> {
			Map<String, Serializable> expandoBridgeAttributes = null;

			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			if (serviceContext != null) {
				expandoBridgeAttributes =
					serviceContext.getExpandoBridgeAttributes();
			}

			consumer.accept(expandoBridgeAttributes);

			return null;
		};
	}

}