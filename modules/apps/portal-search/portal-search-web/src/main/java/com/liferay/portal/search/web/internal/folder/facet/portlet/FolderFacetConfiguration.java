/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.folder.facet.portlet;

/**
 * @author Lino Alves
 */
public interface FolderFacetConfiguration {

	public int getFrequencyThreshold();

	public int getMaxTerms();

	public void setFrequencyThreshold(int frequencyThreshold);

	public void setMaxTerms(int maxTerms);

}