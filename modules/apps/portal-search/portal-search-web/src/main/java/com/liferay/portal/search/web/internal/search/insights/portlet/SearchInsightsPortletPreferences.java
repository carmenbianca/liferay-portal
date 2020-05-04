/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.search.insights.portlet;

import java.util.Optional;

/**
 * @author Wade Cao
 */
public interface SearchInsightsPortletPreferences {

	public static final String PREFERENCE_KEY_EXPLAIN = "explain";

	public static final String PREFERENCE_KEY_FEDERATED_SEARCH_KEY =
		"federatedSearchKey";

	public Optional<String> getFederatedSearchKeyOptional();

	public String getFederatedSearchKeyString();

	public boolean isExplain();

}