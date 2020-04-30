/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.spi.model.query.contributor.helper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author André de Oliveira
 */
@ProviderType
public interface QueryConfigContributorHelper {

	public String[] getDefaultSelectedFieldNames();

	public String[] getDefaultSelectedLocalizedFieldNames();

	public boolean isSelectAllLocales();

}