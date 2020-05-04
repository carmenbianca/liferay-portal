/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.upgrade.util;

/**
 * @author Brian Wing Shun Chan
 * @author Alexander Chow
 */
public interface UpgradeColumn {

	public String getName();

	public Integer getNewColumnType(Integer defaultType);

	public Object getNewValue();

	public Object getNewValue(Object oldValue) throws Exception;

	public Integer getOldColumnType(Integer defaultType);

	public Object getOldValue();

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             CounterLocalServiceUtil#increment()}
	 */
	@Deprecated
	public long increment();

	public boolean isApplicable(String name);

	public void setNewValue(Object newValue);

	public void setOldValue(Object oldValue);

}