/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.query;

import com.liferay.portal.kernel.search.Query;

/**
 * @author Michael C. Han
 */
public interface LuceneQueryConverter {

	public org.apache.lucene.search.Query convert(Query query);

}