/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.initializer;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Marco Leo
 */
@ProviderType
public interface SiteInitializerRegistry {

	public SiteInitializer getSiteInitializer(String key);

	public List<SiteInitializer> getSiteInitializers(long companyId);

	public List<SiteInitializer> getSiteInitializers(
		long companyId, boolean active);

}