/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.expando.util;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactory;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

/**
 * @author Raymond Augé
 * @deprecated As of Athanasius (7.3.x)
 */
@Deprecated
public class ExpandoBridgeFactoryImpl implements ExpandoBridgeFactory {

	@Override
	public ExpandoBridge getExpandoBridge(long companyId, String className) {
		return new ExpandoBridgeImpl(companyId, className);
	}

	@Override
	public ExpandoBridge getExpandoBridge(
		long companyId, String className, long classPK) {

		return new ExpandoBridgeImpl(companyId, className, classPK);
	}

}