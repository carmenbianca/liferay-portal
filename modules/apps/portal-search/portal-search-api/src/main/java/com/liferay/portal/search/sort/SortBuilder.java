/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.sort;

import java.util.Locale;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Wade Cao
 * @author André de Oliveira
 */
@ProviderType
public interface SortBuilder {

	public Sort build();

	public SortBuilder field(String field);

	public SortBuilder locale(Locale locale);

	public SortBuilder sortOrder(SortOrder sortOrder);

}