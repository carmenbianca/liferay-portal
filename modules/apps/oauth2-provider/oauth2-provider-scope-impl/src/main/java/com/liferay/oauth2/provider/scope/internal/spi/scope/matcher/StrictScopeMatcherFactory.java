/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.scope.internal.spi.scope.matcher;

import com.liferay.oauth2.provider.scope.spi.scope.matcher.ScopeMatcher;
import com.liferay.oauth2.provider.scope.spi.scope.matcher.ScopeMatcherFactory;

import org.osgi.service.component.annotations.Component;

/**
 * @author Tomas Polesovsky
 */
@Component(
	immediate = true, property = "type=strict",
	service = ScopeMatcherFactory.class
)
public class StrictScopeMatcherFactory implements ScopeMatcherFactory {

	@Override
	public ScopeMatcher create(String input) {
		return input::equals;
	}

}