/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.template.soy.internal.util;

import com.liferay.portal.template.soy.internal.SoyContextImpl;
import com.liferay.portal.template.soy.util.SoyContext;
import com.liferay.portal.template.soy.util.SoyContextFactory;

import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * @author Matthew Tambara
 */
@Component(immediate = true, service = SoyContextFactory.class)
public class SoyContextFactoryImpl implements SoyContextFactory {

	@Override
	public SoyContext createSoyContext() {
		return new SoyContextImpl();
	}

	@Override
	public SoyContext createSoyContext(Map<String, Object> context) {
		return new SoyContextImpl(context);
	}

}