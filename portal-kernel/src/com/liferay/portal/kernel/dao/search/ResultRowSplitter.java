/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.search;

import java.util.List;

/**
 * @author Sergio González
 */
public interface ResultRowSplitter {

	public List<ResultRowSplitterEntry> split(List<ResultRow> resultRows);

}