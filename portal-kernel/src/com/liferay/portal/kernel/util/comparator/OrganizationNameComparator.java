/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util.comparator;

import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author Brian Wing Shun Chan
 */
public class OrganizationNameComparator
	extends OrderByComparator<Organization> {

	public static final String ORDER_BY_ASC = "orgName ASC";

	public static final String ORDER_BY_DESC = "orgName DESC";

	public static final String[] ORDER_BY_FIELDS = {"name"};

	public OrganizationNameComparator() {
		this(false);
	}

	public OrganizationNameComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Organization organization1, Organization organization2) {
		String name1 = organization1.getName();
		String name2 = organization2.getName();

		int value = name1.compareTo(name2);

		if (_ascending) {
			return value;
		}

		return -value;
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}

		return ORDER_BY_DESC;
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private final boolean _ascending;

}