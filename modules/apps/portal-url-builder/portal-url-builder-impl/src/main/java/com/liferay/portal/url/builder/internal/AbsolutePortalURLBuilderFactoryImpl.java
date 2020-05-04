/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.url.builder.internal;

import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.url.builder.AbsolutePortalURLBuilder;
import com.liferay.portal.url.builder.AbsolutePortalURLBuilderFactory;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Iván Zaera Avellón
 */
@Component(service = AbsolutePortalURLBuilderFactory.class)
public class AbsolutePortalURLBuilderFactoryImpl
	implements AbsolutePortalURLBuilderFactory {

	@Override
	public AbsolutePortalURLBuilder getAbsolutePortalURLBuilder(
		HttpServletRequest httpServletRequest) {

		return new AbsolutePortalURLBuilderImpl(_portal, httpServletRequest);
	}

	@Reference
	private Portal _portal;

}