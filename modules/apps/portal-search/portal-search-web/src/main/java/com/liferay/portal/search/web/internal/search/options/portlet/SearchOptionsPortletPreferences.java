/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.search.options.portlet;

import java.util.Optional;

/**
 * @author Wade Cao
 */
public interface SearchOptionsPortletPreferences {

	public static final String PREFERENCE_KEY_ALLOW_EMPTY_SEARCHES =
		"allowEmptySearches";

	public static final String PREFERENCE_KEY_BASIC_FACET_SELECTION =
		"basicFacetSelection";

	public static final String PREFERENCE_KEY_FEDERATED_SEARCH_KEY =
		"federatedSearchKey";

	public Optional<String> getFederatedSearchKeyOptional();

	public String getFederatedSearchKeyString();

	public boolean isAllowEmptySearches();

	public boolean isBasicFacetSelection();

}