/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.util.comparator;

import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author Eduardo García
 */
public class TemplateIdComparator extends OrderByComparator<DDMTemplate> {

	public static final String ORDER_BY_ASC = "DDMTemplate.templateId ASC";

	public static final String ORDER_BY_DESC = "DDMTemplate.templateId DESC";

	public static final String[] ORDER_BY_FIELDS = {"templateId"};

	public TemplateIdComparator() {
		this(false);
	}

	public TemplateIdComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(DDMTemplate template1, DDMTemplate template2) {
		long templateId1 = template1.getTemplateId();
		long templateId2 = template2.getTemplateId();

		int value = 0;

		if (templateId1 < templateId2) {
			value = -1;
		}
		else if (templateId1 > templateId2) {
			value = 1;
		}

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