/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.spi.index.helper;

import java.util.function.Consumer;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author André de Oliveira
 */
@ProviderType
public interface IndexRegistrarHelper {

	public void createIndex(
		String indexName,
		Consumer<IndexSettingsDefinition> indexSettingsDefinitionConsumer);

}