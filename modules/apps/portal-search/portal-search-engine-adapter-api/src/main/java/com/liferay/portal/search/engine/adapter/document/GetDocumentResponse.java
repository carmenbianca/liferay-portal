/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine.adapter.document;

import com.liferay.portal.search.document.Document;

/**
 * @author Bryan Engler
 */
public class GetDocumentResponse implements DocumentResponse {

	public GetDocumentResponse(boolean exists) {
		_exists = exists;
	}

	public Document getDocument() {
		return _document;
	}

	public String getSource() {
		return _source;
	}

	public long getVersion() {
		return _version;
	}

	public boolean isExists() {
		return _exists;
	}

	public void setDocument(Document document) {
		_document = document;
	}

	public void setSource(String source) {
		_source = source;
	}

	public void setVersion(long version) {
		_version = version;
	}

	private Document _document;
	private final boolean _exists;
	private String _source;
	private long _version;

}