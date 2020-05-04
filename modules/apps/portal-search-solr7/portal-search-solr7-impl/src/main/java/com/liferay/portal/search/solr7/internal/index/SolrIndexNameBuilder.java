/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.index;

import com.liferay.portal.search.index.IndexNameBuilder;

import org.osgi.service.component.annotations.Component;

/**
 * @author Bryan Engler
 */
@Component(immediate = true, service = IndexNameBuilder.class)
public class SolrIndexNameBuilder implements IndexNameBuilder {

	@Override
	public String getIndexName(long companyId) {
		return "liferay";
	}

}