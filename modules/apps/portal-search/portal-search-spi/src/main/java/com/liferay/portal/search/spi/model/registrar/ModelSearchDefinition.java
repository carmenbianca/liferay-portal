/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.spi.model.registrar;

import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.liferay.portal.search.spi.model.result.contributor.ModelVisibilityContributor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author André de Oliveira
 */
@ProviderType
public interface ModelSearchDefinition {

	public void setDefaultSelectedFieldNames(
		String... defaultSelectedFieldNames);

	public void setDefaultSelectedLocalizedFieldNames(
		String... defaultSelectedLocalizedFieldNames);

	public void setModelIndexWriteContributor(
		ModelIndexerWriterContributor<?> modelIndexWriterContributor);

	public void setModelSummaryContributor(
		ModelSummaryContributor modelSummaryContributor);

	public void setModelVisibilityContributor(
		ModelVisibilityContributor modelVisibilityContributor);

	public void setSearchEngineId(String searchEngineId);

	public void setSearchResultPermissionFilterSuppressed(
		boolean searchResultPermissionFilterSuppressed);

	public void setSelectAllLocales(boolean selectAllLocales);

}