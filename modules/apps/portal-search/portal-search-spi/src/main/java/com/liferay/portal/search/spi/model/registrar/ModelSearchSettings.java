/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.spi.model.registrar;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author André de Oliveira
 */
@ProviderType
public interface ModelSearchSettings {

	public String getClassName();

	public String[] getDefaultSelectedFieldNames();

	public String[] getDefaultSelectedLocalizedFieldNames();

	public String[] getSearchClassNames();

	public String getSearchEngineId();

	public boolean isCommitImmediately();

	public boolean isSearchResultPermissionFilterSuppressed();

	public boolean isSelectAllLocales();

	public boolean isStagingAware();

}