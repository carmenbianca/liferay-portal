/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.spi.model.query.contributor;

import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.spi.model.query.contributor.helper.SearchContextContributorHelper;

/**
 * @author Michael C. Han
 */
public interface SearchContextContributor {

	public void contribute(
		SearchContext searchContext,
		SearchContextContributorHelper searchContextContributorHelper);

}