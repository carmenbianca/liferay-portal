/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface OAuth2AuthorizationFinder {

	public java.util.Collection
		<com.liferay.oauth2.provider.model.OAuth2Authorization> findByPurgeDate(
			java.util.Date purgeDate, int start, int end);

}