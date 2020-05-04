/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mobile.device.rules.util.comparator;

import com.liferay.mobile.device.rules.model.MDRRuleGroupInstance;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author Edward Han
 */
public class RuleGroupInstancePriorityComparator
	extends OrderByComparator<MDRRuleGroupInstance> {

	public static final RuleGroupInstancePriorityComparator INSTANCE_ASCENDING =
		new RuleGroupInstancePriorityComparator(Boolean.TRUE);

	public static final RuleGroupInstancePriorityComparator
		INSTANCE_DESCENDING = new RuleGroupInstancePriorityComparator(
			Boolean.FALSE);

	public static final String ORDER_BY_ASC =
		"MDRRuleGroupInstance.priority ASC";

	public static final String ORDER_BY_DESC =
		"MDRRuleGroupInstance.priority DESC";

	public static final String[] ORDER_BY_FIELDS = {"priority"};

	public static RuleGroupInstancePriorityComparator getInstance(
		boolean ascending) {

		if (ascending) {
			return INSTANCE_ASCENDING;
		}

		return INSTANCE_DESCENDING;
	}

	@Override
	public int compare(
		MDRRuleGroupInstance ruleGroupInstance1,
		MDRRuleGroupInstance ruleGroupInstance2) {

		int value =
			ruleGroupInstance2.getPriority() - ruleGroupInstance1.getPriority();

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

	private RuleGroupInstancePriorityComparator(Boolean ascending) {
		_ascending = ascending;
	}

	private final boolean _ascending;

}