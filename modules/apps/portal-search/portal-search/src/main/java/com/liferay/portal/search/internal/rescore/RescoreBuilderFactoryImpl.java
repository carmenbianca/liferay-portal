/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.rescore;

import com.liferay.portal.search.rescore.RescoreBuilder;
import com.liferay.portal.search.rescore.RescoreBuilderFactory;

import org.osgi.service.component.annotations.Component;

/**
 * @author Bryan Engler
 */
@Component(immediate = true, service = RescoreBuilderFactory.class)
public class RescoreBuilderFactoryImpl implements RescoreBuilderFactory {

	@Override
	public RescoreBuilder getRescoreBuilder() {
		return new RescoreBuilderImpl();
	}

}