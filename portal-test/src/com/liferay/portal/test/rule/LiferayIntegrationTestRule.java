/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.test.rule;

import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.CompanyProviderClassTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRunMethodTestRule;
import com.liferay.portal.kernel.test.rule.SynchronousDestinationTestRule;
import com.liferay.portal.kernel.test.rule.TimeoutTestRule;

import java.util.ArrayList;
import java.util.List;

import org.junit.rules.TestRule;

/**
 * @author Shuyang Zhou
 */
public class LiferayIntegrationTestRule extends AggregateTestRule {

	public LiferayIntegrationTestRule() {
		super(false, _getTestRules());
	}

	private static TestRule[] _getTestRules() {
		List<TestRule> testRules = new ArrayList<>();

		if (System.getenv("JENKINS_HOME") != null) {
			testRules.add(TimeoutTestRule.INSTANCE);
		}

		testRules.add(LogAssertionTestRule.INSTANCE);
		testRules.add(SybaseDumpTransactionLogTestRule.INSTANCE);
		testRules.add(ClearThreadLocalClassTestRule.INSTANCE);
		testRules.add(UniqueStringRandomizerBumperClassTestRule.INSTANCE);
		testRules.add(DestinationAwaitClassTestRule.INSTANCE);
		testRules.add(CompanyProviderClassTestRule.INSTANCE);
		testRules.add(DeleteAfterTestRunMethodTestRule.INSTANCE);
		testRules.add(SynchronousDestinationTestRule.INSTANCE);
		testRules.add(InjectTestRule.INSTANCE);

		return testRules.toArray(new TestRule[0]);
	}

}