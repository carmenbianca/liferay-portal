/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.modified.facet.builder;

import com.liferay.portal.kernel.json.JSONArray;

/**
 * @author Lino Alves
 */
public interface ModifiedFacetConfiguration {

	public JSONArray getRangesJSONArray();

	public void setRangesJSONArray(JSONArray ranges);

}