/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine.adapter.document;

import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.search.engine.adapter.ccr.CrossClusterRequest;

/**
 * @author Michael C. Han
 */
public class DeleteByQueryDocumentRequest
	extends CrossClusterRequest
	implements DocumentRequest<DeleteByQueryDocumentResponse> {

	public DeleteByQueryDocumentRequest(Query query, String... indexNames) {
		_query = query;
		_indexNames = indexNames;
	}

	@Override
	public DeleteByQueryDocumentResponse accept(
		DocumentRequestExecutor documentRequestExecutor) {

		return documentRequestExecutor.executeDocumentRequest(this);
	}

	public String[] getIndexNames() {
		return _indexNames;
	}

	public Query getQuery() {
		return _query;
	}

	public boolean isRefresh() {
		return _refresh;
	}

	public boolean isWaitForCompletion() {
		return _waitForCompletion;
	}

	public void setRefresh(boolean refresh) {
		_refresh = refresh;
	}

	public void setWaitForCompletion(boolean waitForCompletion) {
		_waitForCompletion = waitForCompletion;
	}

	private final String[] _indexNames;
	private final Query _query;
	private boolean _refresh;
	private boolean _waitForCompletion;

}