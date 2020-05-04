/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.definition.internal.export;

import com.liferay.portal.workflow.kaleo.definition.NodeType;
import com.liferay.portal.workflow.kaleo.definition.NodeTypeDependentObjectRegistry;
import com.liferay.portal.workflow.kaleo.definition.export.NodeExporter;

import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * @author Michael C. Han
 */
@Component(immediate = true, service = NodeExporterRegistry.class)
public class NodeExporterRegistry {

	public NodeExporter getNodeExporter(NodeType nodeType) {
		return _nodeExporters.getNodeTypeDependentObjects(nodeType);
	}

	@Reference(
		cardinality = ReferenceCardinality.MULTIPLE,
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY
	)
	protected void addNodeExporter(
		NodeExporter nodeExporter, Map<String, Object> properties) {

		String nodeType = (String)properties.get("node.type");

		if (nodeType == null) {
			throw new IllegalArgumentException(
				"The property \"node.type\" is null");
		}

		_nodeExporters.addNodeTypeDependentObject(nodeType, nodeExporter);
	}

	protected void removeNodeExporter(
		NodeExporter nodeExporter, Map<String, Object> properties) {

		String nodeType = (String)properties.get("node.type");

		if (nodeType == null) {
			throw new IllegalArgumentException(
				"The property \"node.type\" is null");
		}

		_nodeExporters.removeNodeTypeDependentObjects(nodeType);
	}

	private final NodeTypeDependentObjectRegistry<NodeExporter> _nodeExporters =
		new NodeTypeDependentObjectRegistry<>();

}