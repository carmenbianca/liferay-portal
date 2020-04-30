/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.engine;

import com.liferay.portal.search.engine.ConnectionInformationBuilder;
import com.liferay.portal.search.engine.ConnectionInformationBuilderFactory;

import org.osgi.service.component.annotations.Component;

/**
 * @author Bryan Engler
 */
@Component(service = ConnectionInformationBuilderFactory.class)
public class ConnectionInformationBuilderFactoryImpl
	implements ConnectionInformationBuilderFactory {

	@Override
	public ConnectionInformationBuilder getConnectionInformationBuilder() {
		return new ConnectionInformationImpl.Builder();
	}

}