/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.search.engine.adapter.document;

import com.liferay.portal.search.engine.adapter.document.UpdateByQueryDocumentRequest;
import com.liferay.portal.search.engine.adapter.document.UpdateByQueryDocumentResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Bryan Engler
 */
@Component(
	immediate = true, service = UpdateByQueryDocumentRequestExecutor.class
)
public class UpdateByQueryDocumentRequestExecutorImpl
	implements UpdateByQueryDocumentRequestExecutor {

	@Override
	public UpdateByQueryDocumentResponse execute(
		UpdateByQueryDocumentRequest updateByQueryDocumentRequest) {

		throw new UnsupportedOperationException();
	}

}