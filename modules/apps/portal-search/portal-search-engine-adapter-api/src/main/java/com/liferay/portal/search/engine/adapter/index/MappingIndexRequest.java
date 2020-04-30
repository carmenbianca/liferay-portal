/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine.adapter.index;

/**
 * @author Leon Chi
 */
public interface MappingIndexRequest<T extends IndexResponse>
	extends IndexRequest<T> {

	public String getMappingName();

}