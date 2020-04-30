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
public interface LayoutFinder {

	public java.util.List<com.liferay.portal.kernel.model.Layout>
		findByNullFriendlyURL();

	public java.util.List<com.liferay.portal.kernel.model.Layout>
		findByScopeGroup(long groupId);

	public java.util.List<com.liferay.portal.kernel.model.Layout>
		findByScopeGroup(long groupId, boolean privateLayout);

	public java.util.List<com.liferay.portal.kernel.model.LayoutReference>
		findByC_P_P(
			long companyId, String portletId, String preferencesKey,
			String preferencesValue);

}