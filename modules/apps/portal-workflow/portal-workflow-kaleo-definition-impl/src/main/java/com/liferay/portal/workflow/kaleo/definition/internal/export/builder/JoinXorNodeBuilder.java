/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.definition.internal.export.builder;

import com.liferay.portal.workflow.kaleo.definition.JoinXor;
import com.liferay.portal.workflow.kaleo.model.KaleoNode;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(
	immediate = true, property = "node.type=JOIN_XOR",
	service = NodeBuilder.class
)
public class JoinXorNodeBuilder
	extends BaseNodeBuilder<JoinXor> implements NodeBuilder {

	@Override
	protected JoinXor createNode(KaleoNode kaleoNode) {
		return new JoinXor(kaleoNode.getName(), kaleoNode.getDescription());
	}

}