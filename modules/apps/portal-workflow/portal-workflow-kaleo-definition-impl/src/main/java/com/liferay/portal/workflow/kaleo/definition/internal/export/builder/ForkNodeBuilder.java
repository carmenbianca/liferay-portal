/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.definition.internal.export.builder;

import com.liferay.portal.workflow.kaleo.definition.Fork;
import com.liferay.portal.workflow.kaleo.model.KaleoNode;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(
	immediate = true, property = "node.type=FORK", service = NodeBuilder.class
)
public class ForkNodeBuilder
	extends BaseNodeBuilder<Fork> implements NodeBuilder {

	@Override
	protected Fork createNode(KaleoNode kaleoNode) {
		return new Fork(kaleoNode.getName(), kaleoNode.getDescription());
	}

}