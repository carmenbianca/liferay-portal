/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.pmd.rules.junit;

import net.sourceforge.pmd.testframework.SimpleAggregatorTst;

/**
 * @author Cristina González
 */
public class AssertFailJUnitRuleTest extends SimpleAggregatorTst {

	@Override
	public void setUp() {
		addRule(_RULESET, "AssertFailJUnitRule");
	}

	private static final String _RULESET = "java-liferay-junit";

}