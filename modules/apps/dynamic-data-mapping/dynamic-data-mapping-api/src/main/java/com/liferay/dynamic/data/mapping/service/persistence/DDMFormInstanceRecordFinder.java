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
public interface DDMFormInstanceRecordFinder {

	public int countByF_S(long ddmFormInstanceId, int status);

	public java.util.List
		<com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecord>
			findByF_S(
				long ddmFormInstanceId, int status, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.dynamic.data.mapping.model.
						DDMFormInstanceRecord> orderByComparator);

}