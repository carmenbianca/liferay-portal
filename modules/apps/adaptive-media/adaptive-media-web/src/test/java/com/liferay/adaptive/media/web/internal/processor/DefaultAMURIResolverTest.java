/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.web.internal.processor;

import com.liferay.adaptive.media.AMURIResolver;
import com.liferay.adaptive.media.web.internal.constants.AMWebConstants;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;

import java.net.URI;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mockito;

/**
 * @author Adolfo Pérez
 */
public class DefaultAMURIResolverTest {

	@Before
	public void setUp() {
		PortalUtil portalUtil = new PortalUtil();

		portalUtil.setPortal(_portal);

		ReflectionTestUtil.setFieldValue(_amURIResolver, "_portal", _portal);
	}

	@Test
	public void testMediaURIWhenPathDoesNotEndInSlash() {
		String pathModule = StringPool.SLASH + RandomTestUtil.randomString();

		Mockito.when(
			_portal.getPathModule()
		).thenReturn(
			pathModule
		);

		URI relativeURI = URI.create(RandomTestUtil.randomString());

		URI uri = _amURIResolver.resolveURI(relativeURI);

		String uriString = uri.toString();

		Assert.assertTrue(uriString, uriString.contains(pathModule));
		Assert.assertTrue(
			uriString, uriString.contains(AMWebConstants.SERVLET_PATH));
		Assert.assertTrue(
			uriString, uriString.contains(relativeURI.toString()));
	}

	@Test
	public void testMediaURIWhenPathEndsInSlash() {
		String pathModule =
			StringPool.SLASH + RandomTestUtil.randomString() + StringPool.SLASH;

		Mockito.when(
			_portal.getPathModule()
		).thenReturn(
			pathModule
		);

		URI relativeURI = URI.create(RandomTestUtil.randomString());

		URI uri = _amURIResolver.resolveURI(relativeURI);

		String uriString = uri.toString();

		Assert.assertTrue(uriString, uriString.contains(pathModule));
		Assert.assertTrue(
			uriString, uriString.contains(AMWebConstants.SERVLET_PATH));
		Assert.assertTrue(
			uriString, uriString.contains(relativeURI.toString()));
	}

	private final AMURIResolver _amURIResolver = new DefaultAMURIResolver();
	private final Portal _portal = Mockito.mock(Portal.class);

}