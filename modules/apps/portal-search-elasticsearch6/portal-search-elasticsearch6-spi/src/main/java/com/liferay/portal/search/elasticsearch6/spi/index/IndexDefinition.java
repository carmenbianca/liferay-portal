/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.spi.index;

/**
 * @author     André de Oliveira
 * @deprecated As of Athanasius (7.3.x), replaced by {@link
 *             com.liferay.portal.search.spi.index.IndexDefinition}
 */
@Deprecated
public interface IndexDefinition {

	public static final String PROPERTY_KEY_INDEX_NAME = "index.name";

	public static final String PROPERTY_KEY_INDEX_SETTINGS_RESOURCE_NAME =
		"index.settings.resource.name";

}