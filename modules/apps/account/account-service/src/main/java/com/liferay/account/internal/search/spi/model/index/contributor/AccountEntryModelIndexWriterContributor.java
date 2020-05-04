/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.internal.search.spi.model.index.contributor;

import com.liferay.account.model.AccountEntry;
import com.liferay.account.service.AccountEntryLocalService;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Drew Brokke
 */
@Component(
	immediate = true,
	property = "indexer.class.name=com.liferay.account.model.AccountEntry",
	service = ModelIndexerWriterContributor.class
)
public class AccountEntryModelIndexWriterContributor
	implements ModelIndexerWriterContributor<AccountEntry> {

	@Override
	public void customize(
		BatchIndexingActionable batchIndexingActionable,
		ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

		batchIndexingActionable.setPerformActionMethod(
			(AccountEntry accountEntry) -> batchIndexingActionable.addDocuments(
				modelIndexerWriterDocumentHelper.getDocument(accountEntry)));
	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return dynamicQueryBatchIndexingActionableFactory.
			getBatchIndexingActionable(
				_accountEntryLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(AccountEntry accountEntry) {
		return accountEntry.getCompanyId();
	}

	@Reference
	protected DynamicQueryBatchIndexingActionableFactory
		dynamicQueryBatchIndexingActionableFactory;

	@Reference
	private AccountEntryLocalService _accountEntryLocalService;

}