/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface OAuth2ScopeGrantFinder {

	public java.util.Collection
		<com.liferay.oauth2.provider.model.OAuth2ScopeGrant> findByC_A_B_A(
			long companyId, String applicationName, String bundleSymbolicName,
			String accessTokenContent);

}