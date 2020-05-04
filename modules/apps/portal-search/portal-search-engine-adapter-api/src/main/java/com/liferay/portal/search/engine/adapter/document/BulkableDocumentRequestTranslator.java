/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine.adapter.document;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface BulkableDocumentRequestTranslator {

	public <T> T translate(DeleteDocumentRequest deleteDocumentRequest);

	public <T> T translate(GetDocumentRequest getDocumentRequest);

	public <T> T translate(IndexDocumentRequest indexDocumentRequest);

	public <T> T translate(UpdateDocumentRequest updateDocumentRequest);

}