/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bulk.selection;

import java.util.Map;

/**
 * @author Adolfo Pérez
 */
public interface BulkSelectionFactory<T> {

	public BulkSelection<T> create(Map<String, String[]> parameterMap);

}