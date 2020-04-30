/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.engine;

import com.liferay.portal.search.engine.NodeInformationBuilder;
import com.liferay.portal.search.engine.NodeInformationBuilderFactory;

import org.osgi.service.component.annotations.Component;

/**
 * @author Bryan Engler
 */
@Component(service = NodeInformationBuilderFactory.class)
public class NodeInformationBuilderFactoryImpl
	implements NodeInformationBuilderFactory {

	@Override
	public NodeInformationBuilder getNodeInformationBuilder() {
		return new NodeInformationImpl.Builder();
	}

}