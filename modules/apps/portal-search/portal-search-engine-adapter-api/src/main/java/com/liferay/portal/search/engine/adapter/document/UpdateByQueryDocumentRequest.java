/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine.adapter.document;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.search.engine.adapter.ccr.CrossClusterRequest;

/**
 * @author Michael C. Han
 */
public class UpdateByQueryDocumentRequest
	extends CrossClusterRequest
	implements DocumentRequest<UpdateByQueryDocumentResponse> {

	public UpdateByQueryDocumentRequest(
		Query query, JSONObject scriptJSONObject, String... indexNames) {

		_query = query;
		_scriptJSONObject = scriptJSONObject;
		_indexNames = indexNames;
	}

	@Override
	public UpdateByQueryDocumentResponse accept(
		DocumentRequestExecutor documentRequestExecutor) {

		return documentRequestExecutor.executeDocumentRequest(this);
	}

	public String[] getIndexNames() {
		return _indexNames;
	}

	public Query getQuery() {
		return _query;
	}

	public JSONObject getScriptJSONObject() {
		return _scriptJSONObject;
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
	private final JSONObject _scriptJSONObject;
	private boolean _waitForCompletion;

}