/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.search;

import java.util.List;

/**
 * @author Eudaldo Alonso
 */
public class ResultRowSplitterEntry {

	public ResultRowSplitterEntry(String title, List<ResultRow> resultRows) {
		_title = title;
		_resultRows = resultRows;
	}

	public List<ResultRow> getResultRows() {
		return _resultRows;
	}

	public String getTitle() {
		return _title;
	}

	public void setResultRows(List<ResultRow> resultRows) {
		_resultRows = resultRows;
	}

	public void setTitle(String title) {
		_title = title;
	}

	private List<ResultRow> _resultRows;
	private String _title;

}