/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.hits;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Wade Cao
 */
@ProviderType
public interface SearchHitBuilderFactory {

	public SearchHitBuilder getSearchHitBuilder();

}