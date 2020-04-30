/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.definition.internal.export.builder;

import com.liferay.portal.workflow.kaleo.definition.State;
import com.liferay.portal.workflow.kaleo.model.KaleoNode;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(
	immediate = true, property = "node.type=STATE", service = NodeBuilder.class
)
public class StateNodeBuilder
	extends BaseNodeBuilder<State> implements NodeBuilder {

	@Override
	protected State createNode(KaleoNode kaleoNode) {
		return new State(
			kaleoNode.getName(), kaleoNode.getDescription(),
			kaleoNode.isInitial());
	}

}