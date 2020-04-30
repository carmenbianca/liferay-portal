/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.chat.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface StatusFinder {

	public java.util.List<Object[]> findByModifiedDate(
		long companyId, long userId, long modifiedDate, int start, int end);

	public java.util.List<Object[]> findBySocialRelationTypes(
		long userId, int[] types, long modifiedDate, int start, int end);

	public java.util.List<Object[]> findByUsersGroups(
		long userId, long modifiedDate, String[] groupNames, int start,
		int end);

}