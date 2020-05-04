/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.summary;

import com.liferay.portal.search.summary.SummaryBuilder;
import com.liferay.portal.search.summary.SummaryBuilderFactory;

import org.osgi.service.component.annotations.Component;

/**
 * @author Bryan Engler
 */
@Component(immediate = true, service = SummaryBuilderFactory.class)
public class SummaryBuilderFactoryImpl implements SummaryBuilderFactory {

	@Override
	public SummaryBuilder newInstance() {
		return new SummaryBuilderImpl();
	}

}