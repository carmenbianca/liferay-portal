/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.query.field;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Rodrigo Paulino
 */
@ProviderType
public interface FieldQueryBuilderFactory {

	public FieldQueryBuilder getQueryBuilder(String fieldName);

}