/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.service.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.workflow.kaleo.model.KaleoAction;
import com.liferay.portal.workflow.kaleo.model.KaleoInstance;
import com.liferay.portal.workflow.kaleo.model.KaleoNode;

import java.util.List;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Inácio Nery
 */
@RunWith(Arquillian.class)
public class KaleoActionLocalServiceTest extends BaseKaleoLocalServiceTestCase {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Test
	public void testGetKaleoActions() throws Exception {
		long companyId = TestPropsValues.getCompanyId();

		KaleoInstance kaleoInstance = addKaleoInstance();

		KaleoNode kaleoNode = addKaleoNode(kaleoInstance);

		KaleoAction kaleoAction = addKaleoAction(kaleoInstance, kaleoNode);

		List<KaleoAction> kaleoActions =
			kaleoActionLocalService.getKaleoActions(
				companyId, KaleoNode.class.getName(),
				kaleoNode.getKaleoNodeId());

		Assert.assertEquals(kaleoActions.toString(), 1, kaleoActions.size());
		Assert.assertEquals(kaleoAction, kaleoActions.get(0));

		kaleoActions = kaleoActionLocalService.getKaleoActions(
			companyId, KaleoNode.class.getName(), kaleoNode.getKaleoNodeId(),
			"onAssignment");

		Assert.assertEquals(kaleoActions.toString(), 1, kaleoActions.size());
		Assert.assertEquals(kaleoAction, kaleoActions.get(0));
	}

}