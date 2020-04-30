/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.context.vocabulary.internal.portlet.action.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.test.portlet.MockLiferayPortletActionRequest;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.LocaleThreadLocal;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;

import java.io.IOException;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;

import org.springframework.mock.web.MockHttpServletRequest;

/**
 * @author Cristina González
 */
@RunWith(Arquillian.class)
public class DeleteSegmentsContextVocabularyConfigurationMVCActionCommandTest {

	@ClassRule
	@Rule
	public static final TestRule testRule = new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() {
		_locale = LocaleThreadLocal.getThemeDisplayLocale();

		LocaleThreadLocal.setThemeDisplayLocale(LocaleUtil.US);
	}

	@AfterClass
	public static void tearDownClass() {
		LocaleThreadLocal.setThemeDisplayLocale(_locale);
	}

	@Test
	public void testProcessAction() throws Exception {
		Configuration configuration = _addConfiguration();

		try {
			_deleteMVCActionCommand.processAction(
				new MockActionRequest(configuration.getPid()), null);

			configuration = _configurationAdmin.getConfiguration(
				configuration.getPid(), StringPool.QUESTION);

			Assert.assertNull(configuration.getProperties());
		}
		finally {
			configuration.delete();
		}
	}

	private Configuration _addConfiguration() throws IOException {
		Configuration configuration =
			_configurationAdmin.createFactoryConfiguration(
				"com.liferay.segments.context.vocabulary.internal." +
					"configuration.SegmentsContextVocabularyConfiguration",
				StringPool.QUESTION);

		Dictionary<String, Object> configuredProperties = new Hashtable<>();

		configuredProperties.put(
			"assetVocabulary", RandomTestUtil.randomString());
		configuredProperties.put("configuration.cleaner.ignore", "true");
		configuredProperties.put("entityField", RandomTestUtil.randomString());

		configuration.update(configuredProperties);

		return configuration;
	}

	private static Locale _locale;

	@Inject
	private ConfigurationAdmin _configurationAdmin;

	@Inject(
		filter = "mvc.command.name=/delete_segments_context_vocabulary_configuration"
	)
	private MVCActionCommand _deleteMVCActionCommand;

	private class MockActionRequest extends MockLiferayPortletActionRequest {

		public MockActionRequest(String pid) {
			_httpServletRequest = new MockHttpServletRequest() {
				{
					setParameter("pid", pid);
				}
			};
		}

		@Override
		public HttpServletRequest getHttpServletRequest() {
			return _httpServletRequest;
		}

		@Override
		public HttpServletRequest getOriginalHttpServletRequest() {
			return _httpServletRequest;
		}

		@Override
		public String getParameter(String name) {
			return _httpServletRequest.getParameter(name);
		}

		private final HttpServletRequest _httpServletRequest;

	}

}