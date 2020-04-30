/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bean.portlet.cdi.extension.internal.scope;

import javax.enterprise.context.spi.Context;
import javax.enterprise.context.spi.Contextual;

/**
 * @author Neil Griffin
 */
public abstract class BaseContextImpl implements Context {

	@Override
	public <T> T get(Contextual<T> contextual) {
		return get(contextual, null);
	}

	@Override
	public boolean isActive() {
		ScopedBeanManager scopedBeanManager =
			ScopedBeanManagerThreadLocal.getCurrentScopedBeanManager();

		if ((scopedBeanManager != null) &&
			(scopedBeanManager.getPortletRequest() != null)) {

			return true;
		}

		return false;
	}

}