/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.util.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutSet;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.VirtualHostLocalService;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.CompanyTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.util.PropsValues;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Michael Bowerman
 */
@RunWith(Arquillian.class)
public class PortalImplLayoutFriendlyURLTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Before
	public void setUp() throws Exception {
		_company = CompanyTestUtil.addCompany();

		_group = _groupLocalService.fetchGroup(
			_company.getCompanyId(), GroupConstants.GUEST);

		_layout = _layoutLocalService.fetchDefaultLayout(
			_group.getGroupId(), false);
	}

	@Test
	public void testCompanyDefaultSiteVirtualHost() throws Exception {
		String expectedURL = _layout.getFriendlyURL();

		if (Validator.isNull(PropsValues.VIRTUAL_HOSTS_DEFAULT_SITE_NAME)) {
			expectedURL = "/web/guest" + expectedURL;
		}

		_testLayoutFriendlyURL(_company.getVirtualHostname(), expectedURL);
	}

	@Test
	public void testCompanyDefaultSiteVirtualHostWithLayoutSetVirtualHost()
		throws Exception {

		_setLayoutSetVirtualHost();

		_testLayoutFriendlyURL(
			_company.getVirtualHostname(),
			PropsValues.LAYOUT_FRIENDLY_URL_PUBLIC_SERVLET_MAPPING +
				_group.getFriendlyURL() + _layout.getFriendlyURL());
	}

	@Test
	public void testLayoutSetVirtualHost() throws Exception {
		_testLayoutFriendlyURL(
			_setLayoutSetVirtualHost(), _layout.getFriendlyURL());
	}

	@Test
	public void testLocalhost() throws Exception {
		_testLayoutFriendlyURL(
			"localhost",
			PropsValues.LAYOUT_FRIENDLY_URL_PUBLIC_SERVLET_MAPPING +
				_group.getFriendlyURL() + _layout.getFriendlyURL());
	}

	@Test
	public void testLocalhostWithLayoutSetVirtualHost() throws Exception {
		_setLayoutSetVirtualHost();

		_testLayoutFriendlyURL(
			"localhost",
			PropsValues.LAYOUT_FRIENDLY_URL_PUBLIC_SERVLET_MAPPING +
				_group.getFriendlyURL() + _layout.getFriendlyURL());
	}

	private String _setLayoutSetVirtualHost() {
		LayoutSet layoutSet = _group.getPublicLayoutSet();

		String hostname =
			RandomTestUtil.randomString() + "." +
				RandomTestUtil.randomString(3);

		_virtualHostLocalService.updateVirtualHost(
			_company.getCompanyId(), layoutSet.getLayoutSetId(), hostname);

		return hostname;
	}

	private void _testLayoutFriendlyURL(
			String virtualHostname, String expectedURL)
		throws Exception {

		ThemeDisplay themeDisplay = new ThemeDisplay();

		themeDisplay.setCompany(_company);
		themeDisplay.setLayout(_layout);
		themeDisplay.setLayoutSet(_layout.getLayoutSet());
		themeDisplay.setPortalDomain(virtualHostname);
		themeDisplay.setServerName(virtualHostname);
		themeDisplay.setServerPort(8080);
		themeDisplay.setSiteGroupId(_group.getGroupId());
		themeDisplay.setUser(TestPropsValues.getUser());

		Assert.assertEquals(
			expectedURL, _portal.getLayoutFriendlyURL(themeDisplay));
	}

	@DeleteAfterTestRun
	private Company _company;

	private Group _group;

	@Inject
	private GroupLocalService _groupLocalService;

	private Layout _layout;

	@Inject
	private LayoutLocalService _layoutLocalService;

	@Inject
	private Portal _portal;

	@Inject
	private VirtualHostLocalService _virtualHostLocalService;

}