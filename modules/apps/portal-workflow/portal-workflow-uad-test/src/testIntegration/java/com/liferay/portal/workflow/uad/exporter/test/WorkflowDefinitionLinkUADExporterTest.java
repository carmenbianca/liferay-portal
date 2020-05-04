/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.uad.exporter.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.model.WorkflowDefinitionLink;
import com.liferay.portal.kernel.service.WorkflowDefinitionLinkLocalService;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.user.associated.data.exporter.UADExporter;
import com.liferay.user.associated.data.test.util.BaseUADExporterTestCase;

import java.util.ArrayList;
import java.util.List;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * @author Brian Wing Shun Chan
 */
@RunWith(Arquillian.class)
public class WorkflowDefinitionLinkUADExporterTest
	extends BaseUADExporterTestCase<WorkflowDefinitionLink> {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Override
	protected WorkflowDefinitionLink addBaseModel(long userId)
		throws Exception {

		WorkflowDefinitionLink workflowDefinitionLink =
			_workflowDefinitionLinkLocalService.addWorkflowDefinitionLink(
				userId, TestPropsValues.getCompanyId(),
				TestPropsValues.getGroupId(), null, 0, 0,
				RandomTestUtil.randomString(), 0);

		_workflowDefinitionLinks.add(workflowDefinitionLink);

		return workflowDefinitionLink;
	}

	@Override
	protected String getPrimaryKeyName() {
		return "workflowDefinitionLinkId";
	}

	@Override
	protected UADExporter getUADExporter() {
		return _uadExporter;
	}

	@Inject(filter = "component.name=*.WorkflowDefinitionLinkUADExporter")
	private UADExporter _uadExporter;

	@Inject
	private WorkflowDefinitionLinkLocalService
		_workflowDefinitionLinkLocalService;

	@DeleteAfterTestRun
	private final List<WorkflowDefinitionLink> _workflowDefinitionLinks =
		new ArrayList<>();

}