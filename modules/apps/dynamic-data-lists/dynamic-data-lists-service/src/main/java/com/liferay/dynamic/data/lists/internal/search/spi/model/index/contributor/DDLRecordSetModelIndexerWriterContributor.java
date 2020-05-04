/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.lists.internal.search.spi.model.index.contributor;

import com.liferay.dynamic.data.lists.internal.search.util.DDLRecordBatchReindexer;
import com.liferay.dynamic.data.lists.model.DDLRecordSet;
import com.liferay.dynamic.data.lists.service.DDLRecordSetLocalService;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Marcela Cunha
 */
@Component(
	immediate = true,
	property = "indexer.class.name=com.liferay.dynamic.data.lists.model.DDLRecordSet",
	service = ModelIndexerWriterContributor.class
)
public class DDLRecordSetModelIndexerWriterContributor
	implements ModelIndexerWriterContributor<DDLRecordSet> {

	@Override
	public void customize(
		BatchIndexingActionable batchIndexingActionable,
		ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

		batchIndexingActionable.setPerformActionMethod(
			(DDLRecordSet ddlRecordSet) -> batchIndexingActionable.addDocuments(
				modelIndexerWriterDocumentHelper.getDocument(ddlRecordSet)));
	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return dynamicQueryBatchIndexingActionableFactory.
			getBatchIndexingActionable(
				ddlRecordSetLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(DDLRecordSet ddlRecordSet) {
		return ddlRecordSet.getCompanyId();
	}

	@Override
	public void modelIndexed(DDLRecordSet ddlRecordSet) {
		ddlRecordBatchReindexer.reindex(
			ddlRecordSet.getRecordSetId(), ddlRecordSet.getCompanyId());
	}

	@Reference
	protected DDLRecordBatchReindexer ddlRecordBatchReindexer;

	@Reference
	protected DDLRecordSetLocalService ddlRecordSetLocalService;

	@Reference
	protected DynamicQueryBatchIndexingActionableFactory
		dynamicQueryBatchIndexingActionableFactory;

}