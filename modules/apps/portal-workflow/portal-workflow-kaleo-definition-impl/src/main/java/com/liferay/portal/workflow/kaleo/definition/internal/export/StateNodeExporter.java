/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.definition.internal.export;

import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.workflow.kaleo.definition.Node;
import com.liferay.portal.workflow.kaleo.definition.State;
import com.liferay.portal.workflow.kaleo.definition.export.NodeExporter;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(
	immediate = true, property = "node.type=STATE", service = NodeExporter.class
)
public class StateNodeExporter
	extends BaseNodeExporter implements NodeExporter {

	@Override
	protected Element createNodeElement(Element element, String namespace) {
		return element.addElement("state", namespace);
	}

	@Override
	protected void exportAdditionalNodeElements(
		Node node, Element nodeElement) {

		exportTimersElement(node, nodeElement, "timers", "timer");

		State state = (State)node;

		boolean initial = state.isInitial();

		if (initial) {
			addTextElement(nodeElement, "initial", String.valueOf(initial));
		}
	}

}