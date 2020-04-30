/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.facet;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.search.facet.Facet;

import java.util.Map;

/**
 * @author Michael C. Han
 */
public interface FacetProcessor<T> {

	public Map<String, JSONObject> processFacet(Facet facet);

}