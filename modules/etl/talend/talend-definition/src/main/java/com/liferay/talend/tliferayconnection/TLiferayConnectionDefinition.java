/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.talend.tliferayconnection;

import com.liferay.talend.LiferayDefinition;
import com.liferay.talend.properties.connection.LiferayConnectionProperties;

import java.util.EnumSet;
import java.util.Set;

import org.talend.components.api.component.ConnectorTopology;
import org.talend.components.api.component.runtime.ExecutionEngine;
import org.talend.components.api.properties.ComponentProperties;
import org.talend.daikon.properties.property.Property;
import org.talend.daikon.runtime.RuntimeInfo;

/**
 * @author Zoltán Takács
 */
public class TLiferayConnectionDefinition extends LiferayDefinition {

	public static final String COMPONENT_NAME = "tLiferayConnection";

	public TLiferayConnectionDefinition() {
		super(COMPONENT_NAME, ExecutionEngine.DI);
	}

	@Override
	public Class<? extends ComponentProperties> getPropertyClass() {
		return LiferayConnectionProperties.class;
	}

	@Override
	public Property<?>[] getReturnProperties() {
		return new Property[] {RETURN_ERROR_MESSAGE_PROP};
	}

	@Override
	public RuntimeInfo getRuntimeInfo(
		ExecutionEngine executionEngine,
		ComponentProperties componentProperties,
		ConnectorTopology connectorTopology) {

		assertConnectorTopologyCompatibility(connectorTopology);
		assertEngineCompatibility(executionEngine);

		if (connectorTopology == ConnectorTopology.NONE) {
			return getCommonRuntimeInfo(SOURCE_OR_SINK_CLASS_NAME);
		}

		return null;
	}

	@Override
	public Set<ConnectorTopology> getSupportedConnectorTopologies() {
		return EnumSet.of(ConnectorTopology.NONE);
	}

	@Override
	public boolean isStartable() {
		return true;
	}

}