/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.search.results.portlet;

import java.util.Optional;

/**
 * @author Lino Alves
 */
public interface SearchResultsPortletPreferences {

	public static final String PREFERENCE_KEY_DISPLAY_IN_DOCUMENT_FORM =
		"displayInDocumentForm";

	public static final String PREFERENCE_KEY_FEDERATED_SEARCH_KEY =
		"federatedSearchKey";

	public static final String PREFERENCE_KEY_FIELDS_TO_DISPLAY =
		"fieldsToDisplay";

	public static final String PREFERENCE_KEY_HIGHLIGHT_ENABLED =
		"highlightEnabled";

	public static final String PREFERENCE_KEY_PAGINATION_DELTA =
		"paginationDelta";

	public static final String PREFERENCE_KEY_PAGINATION_DELTA_PARAMETER_NAME =
		"paginationDeltaParameterName";

	public static final String PREFERENCE_KEY_PAGINATION_START_PARAMETER_NAME =
		"paginationStartParameterName";

	public static final String PREFERENCE_KEY_VIEW_IN_CONTEXT = "viewInContext";

	public Optional<String> getFederatedSearchKeyOptional();

	public String getFederatedSearchKeyString();

	public Optional<String> getFieldsToDisplayOptional();

	public String getFieldsToDisplayString();

	public int getPaginationDelta();

	public String getPaginationDeltaParameterName();

	public String getPaginationStartParameterName();

	public boolean isDisplayInDocumentForm();

	public boolean isHighlightEnabled();

	public boolean isViewInContext();

}