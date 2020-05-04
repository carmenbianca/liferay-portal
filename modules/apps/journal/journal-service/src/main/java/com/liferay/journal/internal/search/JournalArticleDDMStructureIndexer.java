/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.internal.search;

import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.journal.configuration.JournalServiceConfiguration;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalArticleResource;
import com.liferay.journal.service.JournalArticleResourceLocalService;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.search.DDMStructureIndexer;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistry;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.search.index.IndexStatusManager;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Lucas Marques de Paula
 */
@Component(
	immediate = true,
	property = "ddm.structure.indexer.class.name=com.liferay.journal.model.JournalArticle",
	service = DDMStructureIndexer.class
)
public class JournalArticleDDMStructureIndexer implements DDMStructureIndexer {

	@Override
	public void reindexDDMStructures(List<Long> ddmStructureIds)
		throws SearchException {

		try {
			Indexer<JournalArticle> indexer =
				indexerRegistry.nullSafeGetIndexer(JournalArticle.class);

			if (_indexStatusManager.isIndexReadOnly() ||
				!indexer.isIndexerEnabled()) {

				return;
			}

			String[] ddmStructureKeys = new String[ddmStructureIds.size()];

			for (int i = 0; i < ddmStructureIds.size(); i++) {
				long ddmStructureId = ddmStructureIds.get(i);

				DDMStructure ddmStructure =
					ddmStructureLocalService.getDDMStructure(ddmStructureId);

				ddmStructureKeys[i] = ddmStructure.getStructureKey();
			}

			ActionableDynamicQuery actionableDynamicQuery =
				journalArticleResourceLocalService.getActionableDynamicQuery();

			actionableDynamicQuery.setAddCriteriaMethod(
				dynamicQuery -> {
					Class<?> clazz = getClass();

					DynamicQuery journalArticleDynamicQuery =
						DynamicQueryFactoryUtil.forClass(
							JournalArticle.class, "journalArticle",
							clazz.getClassLoader());

					journalArticleDynamicQuery.setProjection(
						ProjectionFactoryUtil.property("resourcePrimKey"));

					journalArticleDynamicQuery.add(
						RestrictionsFactoryUtil.eqProperty(
							"journalArticle.resourcePrimKey",
							"this.resourcePrimKey"));

					journalArticleDynamicQuery.add(
						RestrictionsFactoryUtil.eqProperty(
							"journalArticle.groupId", "this.groupId"));

					Property ddmStructureKey = PropertyFactoryUtil.forName(
						"DDMStructureKey");

					journalArticleDynamicQuery.add(
						ddmStructureKey.in(ddmStructureKeys));

					if (!isIndexAllArticleVersions()) {
						Property statusProperty = PropertyFactoryUtil.forName(
							"status");

						Integer[] statuses = {
							WorkflowConstants.STATUS_APPROVED,
							WorkflowConstants.STATUS_IN_TRASH
						};

						journalArticleDynamicQuery.add(
							statusProperty.in(statuses));
					}

					Property resourcePrimKeyProperty =
						PropertyFactoryUtil.forName("resourcePrimKey");

					dynamicQuery.add(
						resourcePrimKeyProperty.in(journalArticleDynamicQuery));
				});
			actionableDynamicQuery.setPerformActionMethod(
				(JournalArticleResource article) -> {
					try {
						indexer.reindex(
							indexer.getClassName(),
							article.getResourcePrimKey());
					}
					catch (Exception exception) {
						throw new PortalException(exception);
					}
				});

			actionableDynamicQuery.performActions();
		}
		catch (Exception exception) {
			throw new SearchException(exception);
		}
	}

	protected boolean isIndexAllArticleVersions() {
		JournalServiceConfiguration journalServiceConfiguration = null;

		try {
			journalServiceConfiguration =
				configurationProvider.getCompanyConfiguration(
					JournalServiceConfiguration.class,
					CompanyThreadLocal.getCompanyId());

			return journalServiceConfiguration.indexAllArticleVersionsEnabled();
		}
		catch (Exception exception) {
			_log.error(exception, exception);
		}

		return false;
	}

	@Reference
	protected ConfigurationProvider configurationProvider;

	@Reference
	protected DDMStructureLocalService ddmStructureLocalService;

	@Reference
	protected IndexerRegistry indexerRegistry;

	@Reference
	protected JournalArticleResourceLocalService
		journalArticleResourceLocalService;

	private static final Log _log = LogFactoryUtil.getLog(
		JournalArticleDDMStructureIndexer.class);

	@Reference
	private IndexStatusManager _indexStatusManager;

}