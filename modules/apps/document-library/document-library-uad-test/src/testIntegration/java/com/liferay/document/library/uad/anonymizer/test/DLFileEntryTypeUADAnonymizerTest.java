/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.uad.anonymizer.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.document.library.kernel.model.DLFileEntryType;
import com.liferay.document.library.kernel.service.DLFileEntryTypeLocalService;
import com.liferay.document.library.uad.test.DLFileEntryTypeUADTestUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.user.associated.data.anonymizer.UADAnonymizer;
import com.liferay.user.associated.data.test.util.BaseUADAnonymizerTestCase;

import java.util.List;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * @author Brian Wing Shun Chan
 */
@RunWith(Arquillian.class)
public class DLFileEntryTypeUADAnonymizerTest
	extends BaseUADAnonymizerTestCase<DLFileEntryType> {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();

		_group = GroupTestUtil.addGroup();
	}

	@Override
	protected DLFileEntryType addBaseModel(long userId) throws Exception {
		return addBaseModel(userId, true);
	}

	@Override
	protected DLFileEntryType addBaseModel(
			long userId, boolean deleteAfterTestRun)
		throws Exception {

		return DLFileEntryTypeUADTestUtil.addDLFileEntryType(
			_dlFileEntryTypeLocalService, _portal, userId, _group.getGroupId());
	}

	@Override
	protected void deleteBaseModels(List<DLFileEntryType> baseModels)
		throws Exception {

		DLFileEntryTypeUADTestUtil.cleanUpDependencies(
			_dlFileEntryTypeLocalService, _portal, baseModels);
	}

	@Override
	protected UADAnonymizer getUADAnonymizer() {
		return _uadAnonymizer;
	}

	@Override
	protected boolean isBaseModelAutoAnonymized(long baseModelPK, User user)
		throws Exception {

		DLFileEntryType dlFileEntryType =
			_dlFileEntryTypeLocalService.getDLFileEntryType(baseModelPK);

		String userName = dlFileEntryType.getUserName();

		if ((dlFileEntryType.getUserId() != user.getUserId()) &&
			!userName.equals(user.getFullName())) {

			return true;
		}

		return false;
	}

	@Override
	protected boolean isBaseModelDeleted(long baseModelPK) {
		if (_dlFileEntryTypeLocalService.fetchDLFileEntryType(baseModelPK) ==
				null) {

			return true;
		}

		return false;
	}

	@Inject
	private DLFileEntryTypeLocalService _dlFileEntryTypeLocalService;

	@DeleteAfterTestRun
	private Group _group;

	@Inject
	private Portal _portal;

	@Inject(filter = "component.name=*.DLFileEntryTypeUADAnonymizer")
	private UADAnonymizer _uadAnonymizer;

}