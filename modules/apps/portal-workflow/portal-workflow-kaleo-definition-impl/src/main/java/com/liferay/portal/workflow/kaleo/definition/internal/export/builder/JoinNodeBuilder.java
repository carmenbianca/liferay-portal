/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.definition.internal.export.builder;

import com.liferay.portal.workflow.kaleo.definition.Join;
import com.liferay.portal.workflow.kaleo.model.KaleoNode;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(
	immediate = true, property = "node.type=JOIN", service = NodeBuilder.class
)
public class JoinNodeBuilder
	extends BaseNodeBuilder<Join> implements NodeBuilder {

	@Override
	protected Join createNode(KaleoNode kaleoNode) {
		return new Join(kaleoNode.getName(), kaleoNode.getDescription());
	}

}