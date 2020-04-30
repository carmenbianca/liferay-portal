/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.connection;

import org.elasticsearch.client.Client;

/**
 * @author André de Oliveira
 */
public interface ElasticsearchClientResolver {

	public Client getClient();

}