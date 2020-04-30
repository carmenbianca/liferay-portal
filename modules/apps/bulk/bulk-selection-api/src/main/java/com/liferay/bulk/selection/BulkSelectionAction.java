/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bulk.selection;

import com.liferay.portal.kernel.model.User;

import java.io.Serializable;

import java.util.Map;

/**
 * @author Adolfo Pérez
 */
public interface BulkSelectionAction<T> {

	public void execute(
			User user, BulkSelection<T> bulkSelection,
			Map<String, Serializable> inputMap)
		throws Exception;

}