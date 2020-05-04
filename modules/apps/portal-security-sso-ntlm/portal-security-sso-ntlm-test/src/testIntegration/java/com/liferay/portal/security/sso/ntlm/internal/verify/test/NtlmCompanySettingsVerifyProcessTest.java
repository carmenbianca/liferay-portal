/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.sso.ntlm.internal.verify.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.settings.Settings;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.sso.ntlm.constants.LegacyNtlmPropsKeys;
import com.liferay.portal.security.sso.ntlm.constants.NtlmConfigurationKeys;
import com.liferay.portal.security.sso.ntlm.constants.NtlmConstants;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.verify.test.util.BaseCompanySettingsVerifyProcessTestCase;

import javax.portlet.PortletPreferences;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * @author Brian Greenwald
 */
@RunWith(Arquillian.class)
public class NtlmCompanySettingsVerifyProcessTest
	extends BaseCompanySettingsVerifyProcessTestCase {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Override
	protected void doVerify(
		PortletPreferences portletPreferences, Settings settings) {

		for (String key : LegacyNtlmPropsKeys.NTLM_AUTH_KEYS) {
			Assert.assertTrue(
				Validator.isNull(
					portletPreferences.getValue(key, StringPool.BLANK)));
		}

		Assert.assertEquals(
			"testDomain",
			settings.getValue(
				NtlmConfigurationKeys.AUTH_DOMAIN, StringPool.BLANK));
		Assert.assertEquals(
			"testDomainController",
			settings.getValue(
				NtlmConfigurationKeys.AUTH_DOMAIN_CONTROLLER,
				StringPool.BLANK));
		Assert.assertEquals(
			"testDomainControllerName",
			settings.getValue(
				NtlmConfigurationKeys.AUTH_DOMAIN_CONTROLLER_NAME,
				StringPool.BLANK));
		Assert.assertTrue(
			GetterUtil.getBoolean(
				settings.getValue(
					NtlmConfigurationKeys.AUTH_ENABLED, StringPool.FALSE)));
		Assert.assertEquals(
			"testNegotiateFlags",
			settings.getValue(
				NtlmConfigurationKeys.AUTH_NEGOTIATE_FLAGS, StringPool.BLANK));
		Assert.assertEquals(
			"test@serviceAccount.com",
			settings.getValue(
				NtlmConfigurationKeys.AUTH_SERVICE_ACCOUNT, StringPool.BLANK));
		Assert.assertEquals(
			"testServicePassword",
			settings.getValue(
				NtlmConfigurationKeys.AUTH_SERVICE_PASSWORD, StringPool.BLANK));
	}

	@Override
	protected String getSettingsId() {
		return NtlmConstants.SERVICE_NAME;
	}

	@Override
	protected String getVerifyProcessName() {
		return "com.liferay.portal.security.sso.ntlm";
	}

	@Override
	protected void populateLegacyProperties(
		UnicodeProperties unicodeProperties) {

		unicodeProperties.put(
			LegacyNtlmPropsKeys.NTLM_AUTH_DOMAIN, "testDomain");
		unicodeProperties.put(
			LegacyNtlmPropsKeys.NTLM_AUTH_DOMAIN_CONTROLLER,
			"testDomainController");
		unicodeProperties.put(
			LegacyNtlmPropsKeys.NTLM_AUTH_DOMAIN_CONTROLLER_NAME,
			"testDomainControllerName");
		unicodeProperties.put(
			LegacyNtlmPropsKeys.NTLM_AUTH_ENABLED, StringPool.TRUE);
		unicodeProperties.put(
			LegacyNtlmPropsKeys.NTLM_AUTH_NEGOTIATE_FLAGS,
			"testNegotiateFlags");
		unicodeProperties.put(
			LegacyNtlmPropsKeys.NTLM_AUTH_SERVICE_ACCOUNT,
			"test@serviceAccount.com");
		unicodeProperties.put(
			LegacyNtlmPropsKeys.NTLM_AUTH_SERVICE_PASSWORD,
			"testServicePassword");
	}

}