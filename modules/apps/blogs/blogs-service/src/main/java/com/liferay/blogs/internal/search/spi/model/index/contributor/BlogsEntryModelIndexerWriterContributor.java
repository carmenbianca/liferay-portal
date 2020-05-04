/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.internal.search.spi.model.index.contributor;

import com.liferay.blogs.model.BlogsEntry;
import com.liferay.blogs.service.BlogsEntryLocalService;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.IndexerWriterMode;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;

import java.util.Date;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Luan Maoski
 */
@Component(
	immediate = true,
	property = "indexer.class.name=com.liferay.blogs.model.BlogsEntry",
	service = ModelIndexerWriterContributor.class
)
public class BlogsEntryModelIndexerWriterContributor
	implements ModelIndexerWriterContributor<BlogsEntry> {

	@Override
	public void customize(
		BatchIndexingActionable batchIndexingActionable,
		ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

		batchIndexingActionable.setAddCriteriaMethod(
			dynamicQuery -> {
				Property displayDateProperty = PropertyFactoryUtil.forName(
					"displayDate");

				dynamicQuery.add(displayDateProperty.lt(new Date()));
			});
		batchIndexingActionable.setPerformActionMethod(
			(BlogsEntry blogsEntry) -> batchIndexingActionable.addDocuments(
				modelIndexerWriterDocumentHelper.getDocument(blogsEntry)));
	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return _dynamicQueryBatchIndexingActionableFactory.
			getBatchIndexingActionable(
				_blogsEntryLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(BlogsEntry blogsEntry) {
		return blogsEntry.getCompanyId();
	}

	@Override
	public IndexerWriterMode getIndexerWriterMode(BlogsEntry blogsEntry) {
		if (blogsEntry.isApproved() || blogsEntry.isDraft() ||
			blogsEntry.isInTrash() || blogsEntry.isPending()) {

			return IndexerWriterMode.UPDATE;
		}

		if (!blogsEntry.isApproved() && !blogsEntry.isInTrash()) {
			return IndexerWriterMode.SKIP;
		}

		return IndexerWriterMode.DELETE;
	}

	@Reference
	private BlogsEntryLocalService _blogsEntryLocalService;

	@Reference
	private DynamicQueryBatchIndexingActionableFactory
		_dynamicQueryBatchIndexingActionableFactory;

}