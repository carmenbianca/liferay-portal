/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.upgrade.util;

import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;

/**
 * @author Brian Wing Shun Chan
 */
public abstract class BaseUpgradeColumnImpl implements UpgradeColumn {

	public BaseUpgradeColumnImpl(String name) {
		this(name, null);
	}

	public BaseUpgradeColumnImpl(String name, Integer oldColumnType) {
		_name = name;
		_oldColumnType = oldColumnType;
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public Integer getNewColumnType(Integer defaultType) {
		return defaultType;
	}

	@Override
	public Object getNewValue() {
		return _newValue;
	}

	@Override
	public Integer getOldColumnType(Integer defaultType) {
		if (_oldColumnType == null) {
			return defaultType;
		}

		return _oldColumnType;
	}

	@Override
	public Object getOldValue() {
		return _oldValue;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             CounterLocalServiceUtil#increment()}
	 */
	@Deprecated
	@Override
	public long increment() {
		DB db = DBManagerUtil.getDB();

		return db.increment();
	}

	@Override
	public boolean isApplicable(String name) {
		if (_name.equals(name)) {
			return true;
		}

		return false;
	}

	@Override
	public void setNewValue(Object newValue) {
		_newValue = newValue;
	}

	@Override
	public void setOldValue(Object oldValue) {
		_oldValue = oldValue;
	}

	private final String _name;
	private Object _newValue;
	private Integer _oldColumnType;
	private Object _oldValue;

}