/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.dynamic.data.mapping.uad.display.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecord;
import com.liferay.dynamic.data.mapping.test.util.DDMFormInstanceRecordTestUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.user.associated.data.display.UADDisplay;
import com.liferay.user.associated.data.test.util.BaseUADDisplayTestCase;

import java.io.Serializable;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Marcos Martins
 */
@RunWith(Arquillian.class)
public class DDMFormInstanceRecordUADDisplayTest
	extends BaseUADDisplayTestCase<DDMFormInstanceRecord> {

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

	@Test
	public void testGetParentContainerId() throws Exception {
		DDMFormInstanceRecord ddmFormInstanceRecord =
			DDMFormInstanceRecordTestUtil.addDDMFormInstanceRecord(
				_group, TestPropsValues.getUserId());

		Serializable parentContainerId = _uadDisplay.getParentContainerId(
			ddmFormInstanceRecord);

		Assert.assertEquals(
			ddmFormInstanceRecord.getFormInstanceId(), (long)parentContainerId);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testGetTopLevelContainer() throws Exception {
		_uadDisplay.getTopLevelContainer(null, null, null);
	}

	@Override
	protected BaseModel<?> addBaseModel(long userId) throws Exception {
		return DDMFormInstanceRecordTestUtil.addDDMFormInstanceRecord(
			_group, userId);
	}

	@Override
	protected UADDisplay<DDMFormInstanceRecord> getUADDisplay() {
		return _uadDisplay;
	}

	@DeleteAfterTestRun
	private Group _group;

	@Inject(filter = "component.name=*.DDMFormInstanceRecordUADDisplay")
	private UADDisplay _uadDisplay;

}