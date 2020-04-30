/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.users.admin.internal.search;

import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.search.spi.reindexer.BulkReindexer;

import java.util.Collection;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author André de Oliveira
 */
@Component(
	immediate = true,
	property = "indexer.class.name=com.liferay.portal.kernel.model.User",
	service = BulkReindexer.class
)
public class UserBulkReindexer implements BulkReindexer {

	@Override
	public void reindex(long companyId, Collection<Long> classPKs) {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			userLocalService.getIndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setAddCriteriaMethod(
			dynamicQuery -> {
				Property userId = PropertyFactoryUtil.forName("userId");

				dynamicQuery.add(userId.in(classPKs));
			});
		indexableActionableDynamicQuery.setCompanyId(companyId);
		indexableActionableDynamicQuery.setPerformActionMethod(
			(User user) -> {
				if (!user.isDefaultUser()) {
					try {
						indexableActionableDynamicQuery.addDocuments(
							indexer.getDocument(user));
					}
					catch (PortalException portalException) {
						if (_log.isWarnEnabled()) {
							_log.warn(
								"Unable to index user " + user.getUserId(),
								portalException);
						}
					}
				}
			});
		indexableActionableDynamicQuery.setSearchEngineId(
			indexer.getSearchEngineId());

		try {
			indexableActionableDynamicQuery.performActions();
		}
		catch (PortalException portalException) {
			throw new RuntimeException(portalException);
		}
	}

	@Reference(
		target = "(indexer.class.name=com.liferay.portal.kernel.model.User)"
	)
	protected Indexer<User> indexer;

	@Reference
	protected UserLocalService userLocalService;

	private static final Log _log = LogFactoryUtil.getLog(
		UserBulkReindexer.class);

}