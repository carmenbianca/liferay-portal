/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface DDMStructureLinkFinder {

	public int countByKeywords(long classNameId, long classPK, String keywords);

	public java.util.List
		<com.liferay.dynamic.data.mapping.model.DDMStructureLink>
			findByKeywords(
				long classNameId, long classPK, String keywords, int start,
				int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.dynamic.data.mapping.model.DDMStructureLink>
						orderByComparator);

}