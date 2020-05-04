/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface KBFolderFinder {

	public int countF_A_ByG_P(
		long groupId, long parentResourcePrimKey,
		com.liferay.portal.kernel.dao.orm.QueryDefinition<?> queryDefinition);

	public int filterCountF_A_ByG_P(
		long groupId, long parentResourcePrimKey,
		com.liferay.portal.kernel.dao.orm.QueryDefinition<?> queryDefinition);

	public java.util.List<Object> filterFindF_A_ByG_P(
		long groupId, long parentResourcePrimKey,
		com.liferay.portal.kernel.dao.orm.QueryDefinition<?> queryDefinition);

	public java.util.List<Object> findF_A_ByG_P(
		long groupId, long parentResourcePrimKey,
		com.liferay.portal.kernel.dao.orm.QueryDefinition<?> queryDefinition);

}