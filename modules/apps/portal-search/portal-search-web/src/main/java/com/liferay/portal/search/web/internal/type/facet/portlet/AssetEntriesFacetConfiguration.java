/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.type.facet.portlet;

/**
 * @author Lino Alves
 */
public interface AssetEntriesFacetConfiguration {

	public int getFrequencyThreshold();

	public void setFrequencyThreshold(int frequencyThreshold);

}