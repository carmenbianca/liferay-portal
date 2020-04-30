/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.url.builder;

/**
 * Provides a builder that returns a URL.
 *
 * @author Iván Zaera Avellón
 */
public interface BuildableAbsolutePortalURLBuilder {

	/**
	 * Returns the URL according to the builder configuration.
	 *
	 * @return the URL
	 */
	public String build();

}