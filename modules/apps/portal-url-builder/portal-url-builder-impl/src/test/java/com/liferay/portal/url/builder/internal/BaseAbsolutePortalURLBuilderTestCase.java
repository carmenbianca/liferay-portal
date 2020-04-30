/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.url.builder.internal;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.Portal;

import javax.servlet.http.HttpServletRequest;

import org.mockito.Mockito;

/**
 * @author Iván Zaera Avellón
 */
public abstract class BaseAbsolutePortalURLBuilderTestCase {

	protected Portal mockPortal(boolean context, boolean proxy, boolean cdnHost)
		throws PortalException {

		Portal portal = Mockito.mock(Portal.class);

		String pathProxy = proxy ? "/proxy" : StringPool.BLANK;

		Mockito.when(
			portal.getPathProxy()
		).thenReturn(
			pathProxy
		);

		Mockito.when(
			portal.getPathContext()
		).thenReturn(
			pathProxy + (context ? "/context" : StringPool.BLANK)
		);

		Mockito.when(
			portal.getCDNHost(Mockito.any(HttpServletRequest.class))
		).thenReturn(
			cdnHost ? "http://cdn-host" : StringPool.BLANK
		);

		return portal;
	}

}