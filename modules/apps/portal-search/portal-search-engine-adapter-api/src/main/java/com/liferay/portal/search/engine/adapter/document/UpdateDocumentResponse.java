/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine.adapter.document;

/**
 * @author Dylan Rebelak
 */
public class UpdateDocumentResponse implements DocumentResponse {

	public UpdateDocumentResponse(int status) {
		_status = status;
	}

	public int getStatus() {
		return _status;
	}

	private final int _status;

}