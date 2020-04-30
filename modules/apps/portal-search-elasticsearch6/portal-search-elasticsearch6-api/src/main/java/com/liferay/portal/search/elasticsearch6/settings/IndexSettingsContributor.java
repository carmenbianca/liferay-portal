/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.settings;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author André de Oliveira
 */
@ProviderType
public interface IndexSettingsContributor
	extends Comparable<IndexSettingsContributor> {

	public void contribute(
		String indexName, TypeMappingsHelper typeMappingsHelper);

	public int getPriority();

	public void populate(IndexSettingsHelper indexSettingsHelper);

}