/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.low.level.search.options.portlet.preferences;

import java.util.Optional;

/**
 * @author Wade Cao
 */
public interface LowLevelSearchOptionsPortletPreferences {

	public static final String PREFERENCE_KEY_CONNECTION_ID = "connectionId";

	public static final String PREFERENCE_KEY_CONTRIBUTORS_TO_EXCLUDE =
		"contributorsToExclude";

	public static final String PREFERENCE_KEY_CONTRIBUTORS_TO_INCLUDE =
		"contributorsToInclude";

	public static final String PREFERENCE_KEY_FEDERATED_SEARCH_KEY =
		"federatedSearchKey";

	public static final String PREFERENCE_KEY_FIELDS_TO_RETURN =
		"fieldsToReturn";

	public static final String PREFERENCE_KEY_INDEXES = "indexes";

	public Optional<String> getConnectionIdOptional();

	public String getConnectionIdString();

	public Optional<String> getContributorsToExcludeOptional();

	public String getContributorsToExcludeString();

	public Optional<String> getContributorsToIncludeOptional();

	public String getContributorsToIncludeString();

	public Optional<String> getFederatedSearchKeyOptional();

	public String getFederatedSearchKeyString();

	public Optional<String> getFieldsToReturnOptional();

	public String getFieldsToReturnString();

	public Optional<String> getIndexesOptional();

	public String getIndexesString();

}