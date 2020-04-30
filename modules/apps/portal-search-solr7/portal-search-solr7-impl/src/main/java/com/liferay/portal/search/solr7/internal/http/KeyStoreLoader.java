/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.http;

import java.security.KeyStore;

/**
 * @author Michael C. Han
 */
public interface KeyStoreLoader {

	public KeyStore load(
			String keyStoreType, String keyStoreLocation,
			char[] keyStorePassword)
		throws Exception;

}