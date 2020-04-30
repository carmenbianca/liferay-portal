/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.search.engine.adapter.index;

import org.elasticsearch.action.support.IndicesOptions;

/**
 * @author Michael C. Han
 */
public interface IndicesOptionsTranslator {

	public IndicesOptions translate(
		com.liferay.portal.search.engine.adapter.index.IndicesOptions
			indicesOptions);

}