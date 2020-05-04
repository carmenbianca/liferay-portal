/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.preferences.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.portlet.PortletIdCodec;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;

import javax.portlet.PortletPreferences;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Jorge Ferrer
 */
@RunWith(Arquillian.class)
public class PortletPreferencesFactoryImplTest
	extends BasePortletPreferencesTestCase {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Test
	public void testGetLayoutPortletSetup() throws Exception {
		String name = RandomTestUtil.randomString(20);
		String[] values = {RandomTestUtil.randomString(20)};

		String portletPreferencesXML = getPortletPreferencesXML(name, values);

		addLayoutPortletPreferences(
			testLayout, testPortlet, portletPreferencesXML);

		PortletPreferences layoutPortletSetup =
			portletPreferencesFactory.getLayoutPortletSetup(
				testLayout, _PORTLET_ID);

		Assert.assertArrayEquals(
			layoutPortletSetup.getValues(name, null), values);
	}

	@Test
	public void testGetLayoutPortletSetupCustomizableColumn() throws Exception {
		long userId = RandomTestUtil.randomLong();

		long ownerId = userId;

		int ownerType = PortletKeys.PREFS_OWNER_TYPE_USER;
		String customizableColumnPortletId = PortletIdCodec.encode(
			_PORTLET_ID, userId, null);

		String name = RandomTestUtil.randomString(20);
		String[] values = {RandomTestUtil.randomString(20)};

		String portletPreferencesXML = getPortletPreferencesXML(name, values);

		portletPreferencesLocalService.addPortletPreferences(
			TestPropsValues.getCompanyId(), ownerId, ownerType,
			testLayout.getPlid(), customizableColumnPortletId, testPortlet,
			portletPreferencesXML);

		PortletPreferences layoutPortletSetup =
			portletPreferencesFactory.getLayoutPortletSetup(
				testLayout, customizableColumnPortletId);

		Assert.assertArrayEquals(
			layoutPortletSetup.getValues(name, null), values);
	}

	@Override
	protected String getPortletId() {
		return _PORTLET_ID;
	}

	private static final String _PORTLET_ID = RandomTestUtil.randomString(10);

}