/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface BlogsEntryFinder {

	public int countByOrganizationId(
		long organizationId, java.util.Date displayDate,
		com.liferay.portal.kernel.dao.orm.QueryDefinition
			<com.liferay.blogs.model.BlogsEntry> queryDefinition);

	public int countByOrganizationIds(
		java.util.List<Long> organizationIds, java.util.Date displayDate,
		com.liferay.portal.kernel.dao.orm.QueryDefinition
			<com.liferay.blogs.model.BlogsEntry> queryDefinition);

	public java.util.List<com.liferay.blogs.model.BlogsEntry> findByGroupIds(
		long companyId, long groupId, java.util.Date displayDate,
		com.liferay.portal.kernel.dao.orm.QueryDefinition
			<com.liferay.blogs.model.BlogsEntry> queryDefinition);

	public java.util.List<com.liferay.blogs.model.BlogsEntry>
		findByOrganizationId(
			long organizationId, java.util.Date displayDate,
			com.liferay.portal.kernel.dao.orm.QueryDefinition
				<com.liferay.blogs.model.BlogsEntry> queryDefinition);

	public java.util.List<com.liferay.blogs.model.BlogsEntry>
		findByOrganizationIds(
			java.util.List<Long> organizationIds, java.util.Date displayDate,
			com.liferay.portal.kernel.dao.orm.QueryDefinition
				<com.liferay.blogs.model.BlogsEntry> queryDefinition);

}