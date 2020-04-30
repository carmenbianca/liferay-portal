/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search.facet.collector;

import java.util.List;

/**
 * @author Raymond Augé
 */
public interface FacetCollector {

	public String getFieldName();

	public TermCollector getTermCollector(String term);

	public List<TermCollector> getTermCollectors();

}