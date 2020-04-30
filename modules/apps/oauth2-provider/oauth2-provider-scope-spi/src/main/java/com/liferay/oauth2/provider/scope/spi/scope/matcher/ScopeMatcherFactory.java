/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.scope.spi.scope.matcher;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Factory that creates {@link ScopeMatcher} for a given input. This allow for
 * components to switch matching strategies using configuration.
 *
 * @author Carlos Sierra Andrés
 * @review
 */
@ProviderType
public interface ScopeMatcherFactory {

	/**
	 * Creates a {@link ScopeMatcher} for the given input.
	 *
	 * @param  input the input the matcher will match against.
	 * @return the ScopeMatcher that will match against the input.
	 * @review
	 */
	public ScopeMatcher create(String input);

}