/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine.adapter.document;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Dylan Rebelak
 */
@ProviderType
public interface DocumentRequestExecutor {

	public BulkDocumentResponse executeBulkDocumentRequest(
		BulkDocumentRequest bulkDocumentRequest);

	public DeleteByQueryDocumentResponse executeDocumentRequest(
		DeleteByQueryDocumentRequest deleteByQueryDocumentRequest);

	public DeleteDocumentResponse executeDocumentRequest(
		DeleteDocumentRequest deleteDocumentRequest);

	public GetDocumentResponse executeDocumentRequest(
		GetDocumentRequest getDocumentRequest);

	public IndexDocumentResponse executeDocumentRequest(
		IndexDocumentRequest indexDocumentRequest);

	public UpdateByQueryDocumentResponse executeDocumentRequest(
		UpdateByQueryDocumentRequest updateByQueryDocumentRequest);

	public UpdateDocumentResponse executeDocumentRequest(
		UpdateDocumentRequest updateDocumentRequest);

}