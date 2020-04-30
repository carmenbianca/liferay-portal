/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.connection;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.common.settings.Settings;

/**
 * @author André de Oliveira
 */
public interface IndexCreationHelper {

	public void contribute(CreateIndexRequest createIndexRequest);

	public void contributeIndexSettings(Settings.Builder builder);

	public void whenIndexCreated(String indexName);

}