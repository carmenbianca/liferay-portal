/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.contacts.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface EntryFinder {

	public int countByKeywords(long companyId, long userId, String keywords);

	public int countByKeywords(long userId, String keywords);

	public java.util.List<com.liferay.portal.kernel.model.BaseModel<?>>
		findByKeywords(
			long companyId, long userId, String keywords, int start, int end);

	public java.util.List<com.liferay.contacts.model.Entry> findByKeywords(
		long userId, String keywords, int start, int end);

}