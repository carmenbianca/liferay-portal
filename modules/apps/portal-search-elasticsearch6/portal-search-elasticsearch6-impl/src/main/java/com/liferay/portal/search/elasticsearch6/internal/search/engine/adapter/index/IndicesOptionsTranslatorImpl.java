/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.search.engine.adapter.index;

import org.elasticsearch.action.support.IndicesOptions;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(service = IndicesOptionsTranslator.class)
public class IndicesOptionsTranslatorImpl implements IndicesOptionsTranslator {

	@Override
	public IndicesOptions translate(
		com.liferay.portal.search.engine.adapter.index.IndicesOptions
			indicesOptions) {

		if (indicesOptions == null) {
			return IndicesOptions.fromOptions(false, true, true, true);
		}

		return IndicesOptions.fromOptions(
			indicesOptions.isIgnoreUnavailable(),
			indicesOptions.isAllowNoIndices(),
			indicesOptions.isExpandToOpenIndices(),
			indicesOptions.isExpandToClosedIndices());
	}

}