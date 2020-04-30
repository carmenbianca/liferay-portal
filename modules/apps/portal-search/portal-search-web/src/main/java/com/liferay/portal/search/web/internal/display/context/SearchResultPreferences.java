/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.display.context;

import java.util.Optional;

/**
 * @author André de Oliveira
 */
public interface SearchResultPreferences {

	public Optional<String> getFieldsToDisplayOptional();

	public boolean isDisplayResultsInDocumentForm();

	public boolean isHighlightEnabled();

	public boolean isViewInContext();

}