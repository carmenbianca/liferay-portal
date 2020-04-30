/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.batch;

import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author André de Oliveira
 */
@ProviderType
public interface DynamicQueryBatchIndexingActionableFactory {

	public BatchIndexingActionable getBatchIndexingActionable(
		IndexableActionableDynamicQuery indexableActionableDynamicQuery);

}