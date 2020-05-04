/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.connection;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.common.settings.Settings;

/**
 * @author André de Oliveira
 */
public interface IndexCreationHelper {

	public void contribute(CreateIndexRequestBuilder createIndexRequestBuilder);

	public void contributeIndexSettings(Settings.Builder builder);

	public void whenIndexCreated(String indexName);

}