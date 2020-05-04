/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.facet;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author André de Oliveira
 */
@ProviderType
public interface Facet extends com.liferay.portal.kernel.search.facet.Facet {

	public String getAggregationName();

	public String[] getSelections();

	public void select(String... selections);

	public void setAggregationName(String aggregationName);

}