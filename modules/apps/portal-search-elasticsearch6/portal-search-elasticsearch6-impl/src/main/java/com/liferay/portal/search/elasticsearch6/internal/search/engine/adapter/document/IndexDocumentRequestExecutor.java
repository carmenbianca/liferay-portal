/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.search.engine.adapter.document;

import com.liferay.portal.search.engine.adapter.document.IndexDocumentRequest;
import com.liferay.portal.search.engine.adapter.document.IndexDocumentResponse;

/**
 * @author Dylan Rebelak
 */
public interface IndexDocumentRequestExecutor {

	public IndexDocumentResponse execute(
		IndexDocumentRequest indexDocumentRequest);

}