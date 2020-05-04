/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.spi.model.registrar;

import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.QueryConfigContributor;
import com.liferay.portal.search.spi.model.query.contributor.SearchContextContributor;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.liferay.portal.search.spi.model.result.contributor.ModelVisibilityContributor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author André de Oliveira
 */
@ProviderType
public interface ModelSearchConfigurator<T extends BaseModel<?>> {

	public void close();

	public String getClassName();

	public Iterable<KeywordQueryContributor> getKeywordQueryContributors();

	public Iterable<ModelDocumentContributor> getModelDocumentContributors();

	public ModelIndexerWriterContributor<T> getModelIndexerWriterContributor();

	public ModelSearchSettings getModelSearchSettings();

	public ModelSummaryContributor getModelSummaryBuilder();

	public ModelVisibilityContributor getModelVisibilityContributor();

	public Iterable<QueryConfigContributor> getQueryConfigContributors();

	public Iterable<SearchContextContributor> getSearchContextContributors();

}