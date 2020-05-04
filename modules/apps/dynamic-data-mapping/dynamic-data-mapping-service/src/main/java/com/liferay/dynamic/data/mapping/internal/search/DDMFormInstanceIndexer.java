/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.internal.search;

import com.liferay.dynamic.data.mapping.model.DDMFormInstance;
import com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecord;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceLocalService;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistry;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * @author Leonardo Barros
 */
public class DDMFormInstanceIndexer extends BaseIndexer<DDMFormInstance> {

	public static final String CLASS_NAME = DDMFormInstance.class.getName();

	public DDMFormInstanceIndexer() {
		setDefaultSelectedFieldNames(
			Field.COMPANY_ID, Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK,
			Field.UID);
		setPermissionAware(true);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	protected void doDelete(DDMFormInstance ddmFormInstance) throws Exception {
		deleteDocument(
			ddmFormInstance.getCompanyId(),
			ddmFormInstance.getFormInstanceId());
	}

	@Override
	protected Document doGetDocument(DDMFormInstance ddmFormInstance)
		throws Exception {

		return getBaseModelDocument(CLASS_NAME, ddmFormInstance);
	}

	@Override
	protected Summary doGetSummary(
			Document document, Locale locale, String snippet,
			PortletRequest portletRequest, PortletResponse portletResponse)
		throws Exception {

		return createSummary(document, Field.TITLE, Field.DESCRIPTION);
	}

	@Override
	protected void doReindex(DDMFormInstance ddmFormInstance) throws Exception {
		indexWriterHelper.updateDocument(
			getSearchEngineId(), ddmFormInstance.getCompanyId(),
			getDocument(ddmFormInstance), isCommitImmediately());

		reindexRecords(ddmFormInstance);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		DDMFormInstance ddmFormInstance =
			ddmFormInstanceLocalService.getFormInstance(classPK);

		doReindex(ddmFormInstance);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);

		reindexFormInstances(companyId);
	}

	protected void reindexFormInstances(long companyId) throws Exception {
		final IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			ddmFormInstanceLocalService.getIndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setCompanyId(companyId);
		indexableActionableDynamicQuery.setPerformActionMethod(
			(DDMFormInstance ddmFormInstance) -> {
				try {
					Document document = getDocument(ddmFormInstance);

					if (document != null) {
						indexableActionableDynamicQuery.addDocuments(document);
					}
				}
				catch (PortalException portalException) {
					if (_log.isWarnEnabled()) {
						_log.warn(
							"Unable to index form instance record " +
								ddmFormInstance.getFormInstanceId(),
							portalException);
					}
				}
			});
		indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());

		indexableActionableDynamicQuery.performActions();
	}

	protected void reindexRecords(DDMFormInstance ddmFormInstance)
		throws Exception {

		Indexer<DDMFormInstanceRecord> indexer =
			indexerRegistry.nullSafeGetIndexer(DDMFormInstanceRecord.class);

		indexer.reindex(ddmFormInstance.getFormInstanceRecords());
	}

	protected DDMFormInstanceLocalService ddmFormInstanceLocalService;
	protected IndexerRegistry indexerRegistry;
	protected IndexWriterHelper indexWriterHelper;

	private static final Log _log = LogFactoryUtil.getLog(
		DDMFormInstanceIndexer.class);

}