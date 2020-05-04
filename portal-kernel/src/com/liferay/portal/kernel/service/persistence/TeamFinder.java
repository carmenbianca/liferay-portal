/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface TeamFinder {

	public int countByG_N_D(
		long groupId, String name, String description,
		java.util.LinkedHashMap<String, Object> params);

	public int filterCountByG_N_D(
		long groupId, String name, String description,
		java.util.LinkedHashMap<String, Object> params);

	public java.util.List<com.liferay.portal.kernel.model.Team>
		filterFindByG_N_D(
			long groupId, String name, String description,
			java.util.LinkedHashMap<String, Object> params, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.portal.kernel.model.Team> obc);

	public java.util.List<com.liferay.portal.kernel.model.Team> findByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.liferay.portal.kernel.model.Team> obc);

	public java.util.List<com.liferay.portal.kernel.model.Team> findByG_N_D(
		long groupId, String name, String description,
		java.util.LinkedHashMap<String, Object> params, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.liferay.portal.kernel.model.Team> obc);

}