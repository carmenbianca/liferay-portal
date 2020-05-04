/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface MBMessageFinder {

	public int countByC_T(java.util.Date createDate, long threadId);

	public int countByG_U_C_S(
		long groupId, long userId, long[] categoryIds, int status);

	public int countByG_U_C_A_S(
		long groupId, long userId, long[] categoryIds, boolean anonymous,
		int status);

	public int filterCountByG_U_C_S(
		long groupId, long userId, long[] categoryIds, int status);

	public int filterCountByG_U_C_A_S(
		long groupId, long userId, long[] categoryIds, boolean anonymous,
		int status);

	public int filterCountByG_U_MD_C_S(
		long groupId, long userId, java.util.Date modifiedDate,
		long[] categoryIds, int status);

	public int filterCountByG_U_MD_C_A_S(
		long groupId, long userId, java.util.Date modifiedDate,
		long[] categoryIds, boolean anonymous, int status);

	public java.util.List<Long> filterFindByG_U_C_S(
		long groupId, long userId, long[] categoryIds, int status, int start,
		int end);

	public java.util.List<Long> filterFindByG_U_C_A_S(
		long groupId, long userId, long[] categoryIds, boolean anonymous,
		int status, int start, int end);

	public java.util.List<Long> filterFindByG_U_MD_C_S(
		long groupId, long userId, java.util.Date modifiedDate,
		long[] categoryIds, int status, int start, int end);

	public java.util.List<Long> filterFindByG_U_MD_C_A_S(
		long groupId, long userId, java.util.Date modifiedDate,
		long[] categoryIds, boolean anonymous, int status, int start, int end);

	public java.util.List<com.liferay.message.boards.model.MBMessage>
		findByThreadId(
			long threadId,
			com.liferay.portal.kernel.dao.orm.QueryDefinition
				<com.liferay.message.boards.model.MBMessage> queryDefinition);

	public java.util.List<Long> findByG_U_C_S(
		long groupId, long userId, long[] categoryIds, int status, int start,
		int end);

	public java.util.List<Long> findByG_U_C_A_S(
		long groupId, long userId, long[] categoryIds, boolean anonymous,
		int status, int start, int end);

}