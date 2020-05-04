/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.exportimport.data.handler.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.exportimport.test.util.lar.BaseStagedModelDataHandlerTestCase;
import com.liferay.layout.test.util.LayoutTestUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.model.StagedModel;
import com.liferay.portal.kernel.service.ClassNameLocalService;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.segments.model.SegmentsExperience;
import com.liferay.segments.service.SegmentsExperienceLocalServiceUtil;
import com.liferay.segments.test.util.SegmentsTestUtil;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * @author Eduardo García
 */
@RunWith(Arquillian.class)
public class SegmentsExperienceStagedModelDataHandlerTest
	extends BaseStagedModelDataHandlerTestCase {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();

		_classNameId = _classNameLocalService.getClassNameId(
			Layout.class.getName());

		Layout layout = LayoutTestUtil.addLayout(stagingGroup);

		layout.setType(LayoutConstants.TYPE_CONTENT);

		layout = _layoutLocalService.updateLayout(layout);

		_classPK = layout.getPlid();
	}

	@Override
	protected StagedModel addStagedModel(
			Group group,
			Map<String, List<StagedModel>> dependentStagedModelsMap)
		throws Exception {

		return SegmentsTestUtil.addSegmentsExperience(
			group.getGroupId(), _classNameId, _classPK);
	}

	@Override
	protected StagedModel getStagedModel(String uuid, Group group)
		throws PortalException {

		return SegmentsExperienceLocalServiceUtil.
			getSegmentsExperienceByUuidAndGroupId(uuid, group.getGroupId());
	}

	@Override
	protected Class<? extends StagedModel> getStagedModelClass() {
		return SegmentsExperience.class;
	}

	@Override
	protected void validateImportedStagedModel(
			StagedModel stagedModel, StagedModel importedStagedModel)
		throws Exception {

		super.validateImportedStagedModel(stagedModel, importedStagedModel);

		SegmentsExperience segmentsExperience = (SegmentsExperience)stagedModel;
		SegmentsExperience importedSegmentsExperience =
			(SegmentsExperience)importedStagedModel;

		Assert.assertEquals(
			segmentsExperience.getName(), importedSegmentsExperience.getName());
		Assert.assertEquals(
			segmentsExperience.isActive(),
			importedSegmentsExperience.isActive());
		Assert.assertEquals(
			segmentsExperience.getPriority(),
			importedSegmentsExperience.getPriority());
	}

	private long _classNameId;

	@Inject
	private ClassNameLocalService _classNameLocalService;

	private long _classPK;

	@Inject
	private LayoutLocalService _layoutLocalService;

}