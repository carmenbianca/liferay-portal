/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.batch.engine.internal.item;

import com.liferay.batch.engine.internal.BatchEngineTaskMethodRegistry;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.odata.filter.ExpressionConvert;
import com.liferay.portal.odata.filter.FilterParserProvider;
import com.liferay.portal.odata.sort.SortParserProvider;

import java.io.Serializable;

import java.util.Map;

/**
 * @author Ivica Cardic
 */
public class BatchEngineTaskItemDelegateExecutorFactory {

	public BatchEngineTaskItemDelegateExecutorFactory(
		BatchEngineTaskMethodRegistry batchEngineTaskMethodRegistry,
		ExpressionConvert<Filter> expressionConvert,
		FilterParserProvider filterParserProvider,
		SortParserProvider sortParserProvider) {

		_batchEngineTaskMethodRegistry = batchEngineTaskMethodRegistry;
		_expressionConvert = expressionConvert;
		_filterParserProvider = filterParserProvider;
		_sortParserProvider = sortParserProvider;
	}

	public BatchEngineTaskItemDelegateExecutor create(
			String taskItemDelegateName, String className, Company company,
			Map<String, Serializable> parameters, User user)
		throws ReflectiveOperationException {

		BatchEngineTaskItemDelegateExecutorCreator
			batchEngineTaskItemDelegateExecutorCreator =
				_batchEngineTaskMethodRegistry.
					getBatchEngineTaskItemDelegateExecutorCreator(
						className, taskItemDelegateName);

		if (batchEngineTaskItemDelegateExecutorCreator == null) {
			throw new IllegalStateException(
				"No batch engine delegate available for class name " +
					className);
		}

		return batchEngineTaskItemDelegateExecutorCreator.create(
			company, _expressionConvert, _filterParserProvider, parameters,
			_sortParserProvider, user);
	}

	private final BatchEngineTaskMethodRegistry _batchEngineTaskMethodRegistry;
	private final ExpressionConvert<Filter> _expressionConvert;
	private final FilterParserProvider _filterParserProvider;
	private final SortParserProvider _sortParserProvider;

}