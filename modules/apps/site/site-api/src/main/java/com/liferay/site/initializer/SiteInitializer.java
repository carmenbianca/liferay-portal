/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.initializer;

import com.liferay.site.exception.InitializationException;

import java.util.Locale;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Marco Leo
 */
@ProviderType
public interface SiteInitializer {

	public String getDescription(Locale locale);

	public String getKey();

	public String getName(Locale locale);

	public String getThumbnailSrc();

	public void initialize(long groupId) throws InitializationException;

	public boolean isActive(long companyId);

}