/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal;

import com.liferay.portal.kernel.search.Document;

import org.elasticsearch.search.SearchHit;

/**
 * @author Michael C. Han
 */
public interface SearchHitDocumentTranslator {

	public Document translate(SearchHit searchHit);

}