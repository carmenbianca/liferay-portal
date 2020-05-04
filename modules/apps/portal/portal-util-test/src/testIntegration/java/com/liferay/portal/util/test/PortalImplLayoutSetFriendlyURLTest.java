/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.util.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.layout.test.util.LayoutTestUtil;
import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.LayoutSetLocalService;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.util.PropsValues;

import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Carlos Sierra
 * @author Akos Thurzo
 */
@RunWith(Arquillian.class)
public class PortalImplLayoutSetFriendlyURLTest
	extends BasePortalImplURLTestCase {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Test
	public void testAccessFromVirtualHost() throws Exception {
		Field field = ReflectionUtil.getDeclaredField(
			PropsValues.class, "VIRTUAL_HOSTS_DEFAULT_SITE_NAME");

		Object value = field.get(null);

		Group defaultGroup = GroupTestUtil.addGroup();

		try {
			field.set(null, defaultGroup.getName());

			Layout layout = LayoutTestUtil.addLayout(defaultGroup);

			String friendlyURL = portal.getLayoutSetFriendlyURL(
				layout.getLayoutSet(),
				initThemeDisplay(
					company, group, publicLayout, LOCALHOST, VIRTUAL_HOSTNAME));

			Assert.assertFalse(friendlyURL, friendlyURL.contains(LOCALHOST));
		}
		finally {
			field.set(null, value);

			_groupLocalService.deleteGroup(defaultGroup);
		}
	}

	@Test
	public void testPreserveParameters() throws Exception {
		ThemeDisplay themeDisplay = initThemeDisplay(
			company, group, controlPanelLayout, VIRTUAL_HOSTNAME);

		themeDisplay.setDoAsUserId("impersonated");

		String layoutSetFriendlyURL = portal.getLayoutSetFriendlyURL(
			_layoutSetLocalService.getLayoutSet(group.getGroupId(), false),
			themeDisplay);

		Assert.assertEquals(
			"impersonated",
			_http.getParameter(layoutSetFriendlyURL, "doAsUserId"));
	}

	@Inject
	private GroupLocalService _groupLocalService;

	@Inject
	private Http _http;

	@Inject
	private LayoutSetLocalService _layoutSetLocalService;

}