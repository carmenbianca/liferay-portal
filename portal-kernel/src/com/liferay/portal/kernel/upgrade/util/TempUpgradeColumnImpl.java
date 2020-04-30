/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.upgrade.util;

/**
 * @author Alexander Chow
 * @author Brian Wing Shun Chan
 */
public class TempUpgradeColumnImpl extends BaseUpgradeColumnImpl {

	public TempUpgradeColumnImpl(String name) {
		super(name);
	}

	public TempUpgradeColumnImpl(String name, Integer oldColumnType) {
		super(name, oldColumnType);
	}

	@Override
	public Integer getNewColumnType(Integer defaultType) {
		return getOldColumnType(defaultType);
	}

	@Override
	public Object getNewValue(Object oldValue) throws Exception {
		return oldValue;
	}

}