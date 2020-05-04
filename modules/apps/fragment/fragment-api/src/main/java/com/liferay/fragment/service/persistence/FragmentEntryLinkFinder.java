/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface FragmentEntryLinkFinder {

	public int countByG_F(long groupId, long fragmentEntryId);

	public int countByG_F_C(
		long groupId, long fragmentEntryId, long classNameId);

	public int countByG_F_C_L(
		long groupId, long fragmentEntryId, long classNameId,
		int layoutPageTemplateEntryType);

	public java.util.List<com.liferay.fragment.model.FragmentEntryLink>
		findByG_F(
			long groupId, long fragmentEntryId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.fragment.model.FragmentEntryLink>
					orderByComparator);

	public java.util.List<com.liferay.fragment.model.FragmentEntryLink>
		findByG_F_C(
			long groupId, long fragmentEntryId, long classNameId, int start,
			int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.fragment.model.FragmentEntryLink>
					orderByComparator);

	public java.util.List<com.liferay.fragment.model.FragmentEntryLink>
		findByG_F_C_L(
			long groupId, long fragmentEntryId, long classNameId,
			int layoutPageTemplateEntryType, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.fragment.model.FragmentEntryLink>
					orderByComparator);

}