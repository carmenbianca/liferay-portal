/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.settings;

/**
 * @author André de Oliveira
 */
public interface TypeMappingsHelper {

	public void addTypeMappings(String indexName, String source);

}