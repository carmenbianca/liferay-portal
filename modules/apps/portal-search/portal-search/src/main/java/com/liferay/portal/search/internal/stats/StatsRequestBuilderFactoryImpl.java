/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.stats;

import com.liferay.portal.search.stats.StatsRequestBuilder;
import com.liferay.portal.search.stats.StatsRequestBuilderFactory;

import org.osgi.service.component.annotations.Component;

/**
 * @author Bryan Engler
 */
@Component(immediate = true, service = StatsRequestBuilderFactory.class)
public class StatsRequestBuilderFactoryImpl
	implements StatsRequestBuilderFactory {

	@Override
	public StatsRequestBuilder getStatsRequestBuilder() {
		return new StatsRequestBuilderImpl();
	}

}