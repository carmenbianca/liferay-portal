/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.client.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.oauth2.provider.internal.test.TestAnnotatedApplication;
import com.liferay.oauth2.provider.internal.test.TestApplication;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.UserTestUtil;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;

import java.util.Collections;
import java.util.Dictionary;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.osgi.framework.BundleActivator;

/**
 * @author Carlos Sierra Andrés
 */
@RunWith(Arquillian.class)
public class AnnotationsAndHttpApplicationClientTest
	extends BaseClientTestCase {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Test
	public void test() throws Exception {
		String tokenString = getToken("oauthTestApplication");

		WebTarget webTarget = getWebTarget("/methods");

		Invocation.Builder builder = authorize(
			webTarget.request(), tokenString);

		Assert.assertEquals("get", builder.get(String.class));

		webTarget = getWebTarget("/annotated");

		builder = authorize(webTarget.request(), tokenString);

		Assert.assertEquals("everything.read", builder.get(String.class));
	}

	public static class AnnotationsAndHttpTestPreparatorBundleActivator
		extends BaseTestPreparatorBundleActivator {

		@Override
		protected void prepareTest() throws Exception {
			long defaultCompanyId = PortalUtil.getDefaultCompanyId();

			User user = UserTestUtil.getAdminUser(defaultCompanyId);

			Dictionary<String, Object> annotatedApplicationProperties =
				new HashMapDictionary<>();

			annotatedApplicationProperties.put(
				"oauth2.scope.checker.type", "annotations");

			Dictionary<String, Object> properties = new HashMapDictionary<>();

			properties.put("osgi.jaxrs.name", TestApplication.class.getName());

			registerJaxRsApplication(
				new TestAnnotatedApplication(), "annotated",
				annotatedApplicationProperties);

			registerJaxRsApplication(
				new TestApplication(), "methods", properties);

			registerScopeMapper(
				input -> {
					if (input.equals("GET")) {
						return Collections.singleton("everything.read");
					}
					else if (input.equals("POST")) {
						return Collections.singleton("everything.write");
					}

					return Collections.singleton(input);
				},
				properties);

			createOAuth2Application(
				defaultCompanyId, user, "oauthTestApplication",
				Collections.singletonList("everything"));
		}

	}

	@Override
	protected BundleActivator getBundleActivator() {
		return new AnnotationsAndHttpTestPreparatorBundleActivator();
	}

}