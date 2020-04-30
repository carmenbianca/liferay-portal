/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface FragmentEntryFinder {

	public int countFC_FE_ByG_FCI(
		long groupId, long fragmentCollectionId,
		com.liferay.portal.kernel.dao.orm.QueryDefinition<?> queryDefinition);

	public int countFC_FE_ByG_FCI_N(
		long groupId, long fragmentCollectionId, String name,
		com.liferay.portal.kernel.dao.orm.QueryDefinition<?> queryDefinition);

	public java.util.List<Object> findFC_FE_ByG_FCI(
		long groupId, long fragmentCollectionId,
		com.liferay.portal.kernel.dao.orm.QueryDefinition<?> queryDefinition);

	public java.util.List<Object> findFC_FE_ByG_FCI_N(
		long groupId, long fragmentCollectionId, String name,
		com.liferay.portal.kernel.dao.orm.QueryDefinition<?> queryDefinition);

}