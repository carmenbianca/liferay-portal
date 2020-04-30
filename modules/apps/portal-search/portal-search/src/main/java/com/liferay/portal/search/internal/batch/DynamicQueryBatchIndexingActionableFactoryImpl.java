/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.batch;

import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;

import org.osgi.service.component.annotations.Component;

/**
 * @author André de Oliveira
 */
@Component(
	immediate = true, service = DynamicQueryBatchIndexingActionableFactory.class
)
public class DynamicQueryBatchIndexingActionableFactoryImpl
	implements DynamicQueryBatchIndexingActionableFactory {

	@Override
	public BatchIndexingActionable getBatchIndexingActionable(
		IndexableActionableDynamicQuery indexableActionableDynamicQuery) {

		return new DynamicQueryBatchIndexingActionableAdapter(
			indexableActionableDynamicQuery);
	}

}