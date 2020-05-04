/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.index;

import com.liferay.portal.search.elasticsearch6.spi.index.IndexRegistrar;

/**
 * @author André de Oliveira
 */
public interface IndexSynchronizer {

	public void synchronizeIndexDefinition(
		IndexDefinitionData indexDefinitionData);

	public void synchronizeIndexes();

	public void synchronizeIndexRegistrar(IndexRegistrar indexRegistrar);

}