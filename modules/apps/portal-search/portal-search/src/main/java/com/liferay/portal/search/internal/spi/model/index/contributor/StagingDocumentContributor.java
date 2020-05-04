/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.spi.model.index.contributor;

import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.DocumentContributor;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistry;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Michael C. Han
 */
@Component(
	immediate = true, property = "service.ranking:Integer=-10000",
	service = DocumentContributor.class
)
public class StagingDocumentContributor implements DocumentContributor {

	@Override
	public void contribute(Document document, BaseModel baseModel) {
		String className = document.get(Field.ENTRY_CLASS_NAME);

		if (Validator.isNull(className)) {
			return;
		}

		Indexer indexer = indexerRegistry.getIndexer(className);

		if (!indexer.isStagingAware()) {
			return;
		}

		Map<String, Field> fields = document.getFields();

		Field groupIdField = fields.get(Field.GROUP_ID);

		if (groupIdField == null) {
			return;
		}

		long groupId = GetterUtil.getLong(groupIdField.getValue());

		document.addKeyword(Field.STAGING_GROUP, isStagingGroup(groupId));
	}

	protected boolean isStagingGroup(long groupId) {
		Group group = GroupUtil.fetchSiteGroup(groupLocalService, groupId);

		if (group == null) {
			return false;
		}

		return group.isStagingGroup();
	}

	@Reference
	protected GroupLocalService groupLocalService;

	@Reference
	protected IndexerRegistry indexerRegistry;

}