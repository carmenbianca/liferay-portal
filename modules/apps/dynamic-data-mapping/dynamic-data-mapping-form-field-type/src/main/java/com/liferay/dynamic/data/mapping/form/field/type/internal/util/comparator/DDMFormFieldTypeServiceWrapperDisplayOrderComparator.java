/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type.internal.util.comparator;

import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldType;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerCustomizerFactory.ServiceWrapper;
import com.liferay.portal.kernel.util.MapUtil;

import java.util.Comparator;

/**
 * @author Leonardo Barros
 */
public class DDMFormFieldTypeServiceWrapperDisplayOrderComparator
	implements Comparator<ServiceWrapper<DDMFormFieldType>> {

	public DDMFormFieldTypeServiceWrapperDisplayOrderComparator() {
		this(true);
	}

	public DDMFormFieldTypeServiceWrapperDisplayOrderComparator(
		boolean ascending) {

		_ascending = ascending;
	}

	@Override
	public int compare(
		ServiceWrapper<DDMFormFieldType> serviceWrapper1,
		ServiceWrapper<DDMFormFieldType> serviceWrapper2) {

		Integer displayOrder1 = MapUtil.getInteger(
			serviceWrapper1.getProperties(),
			"ddm.form.field.type.display.order", Integer.MAX_VALUE);
		Integer displayOrder2 = MapUtil.getInteger(
			serviceWrapper2.getProperties(),
			"ddm.form.field.type.display.order", Integer.MAX_VALUE);

		int value = displayOrder1.compareTo(displayOrder2);

		if (_ascending) {
			return value;
		}

		return -value;
	}

	public boolean isAscending() {
		return _ascending;
	}

	private final boolean _ascending;

}