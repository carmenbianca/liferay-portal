/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.users.admin.internal.search;

import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.indexer.IndexerDocumentBuilder;
import com.liferay.portal.search.indexer.IndexerWriter;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Luan Maoski
 */
@Component(immediate = true, service = ContactBatchReindexer.class)
public class ContactBatchReindexerImpl implements ContactBatchReindexer {

	@Override
	public void reindex(long userId, long companyId) {
		BatchIndexingActionable batchIndexingActionable =
			indexerWriter.getBatchIndexingActionable();

		batchIndexingActionable.setAddCriteriaMethod(
			dynamicQuery -> {
				Property userIdPropery = PropertyFactoryUtil.forName("userId");

				dynamicQuery.add(userIdPropery.eq(userId));
			});
		batchIndexingActionable.setCompanyId(companyId);
		batchIndexingActionable.setPerformActionMethod(
			(Contact contact) -> batchIndexingActionable.addDocuments(
				indexerDocumentBuilder.getDocument(contact)));

		batchIndexingActionable.performActions();
	}

	@Reference(
		target = "(indexer.class.name=com.liferay.portal.kernel.model.Contact)"
	)
	protected IndexerDocumentBuilder indexerDocumentBuilder;

	@Reference(
		target = "(indexer.class.name=com.liferay.portal.kernel.model.Contact)"
	)
	protected IndexerWriter<Contact> indexerWriter;

}