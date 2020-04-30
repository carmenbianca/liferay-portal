/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.batch.engine.internal;

import com.liferay.batch.engine.ItemClassRegistry;
import com.liferay.batch.engine.internal.item.BatchEngineTaskItemDelegateExecutorCreator;

/**
 * @author Ivica Cardic
 */
public interface BatchEngineTaskMethodRegistry extends ItemClassRegistry {

	public BatchEngineTaskItemDelegateExecutorCreator
		getBatchEngineTaskItemDelegateExecutorCreator(
			String itemClassName, String taskItemDelegateName);

}