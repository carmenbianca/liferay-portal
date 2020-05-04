/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.permission;

import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.index.UpdateDocumentIndexWriter;
import com.liferay.portal.search.indexer.BaseModelDocumentFactory;
import com.liferay.portal.search.permission.SearchPermissionDocumentContributor;
import com.liferay.portal.search.permission.SearchPermissionIndexWriter;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Michael C. Han
 */
@Component(immediate = true, service = SearchPermissionIndexWriter.class)
public class SearchPermissionIndexWriterImpl
	implements SearchPermissionIndexWriter {

	@Override
	public void updatePermissionFields(
		BaseModel<?> baseModel, long companyId, String searchEngineId,
		boolean commitImmediately) {

		Document document = baseModelDocumentFactory.createDocument(baseModel);

		searchPermissionDocumentContributor.addPermissionFields(
			companyId, document);

		updateDocumentIndexWriter.updateDocumentPartially(
			searchEngineId, companyId, document, commitImmediately);
	}

	@Reference
	protected BaseModelDocumentFactory baseModelDocumentFactory;

	@Reference
	protected SearchPermissionDocumentContributor
		searchPermissionDocumentContributor;

	@Reference
	protected UpdateDocumentIndexWriter updateDocumentIndexWriter;

}