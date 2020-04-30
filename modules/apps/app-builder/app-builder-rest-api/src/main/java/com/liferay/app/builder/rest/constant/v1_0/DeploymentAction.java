/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.app.builder.rest.constant.v1_0;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Gabriel Albuquerque
 * @generated
 */
@Generated("")
public enum DeploymentAction {

	DEPLOY("deploy"), UNDEPLOY("undeploy");

	@JsonCreator
	public static DeploymentAction fromString(String value) {
		for (DeploymentAction deploymentAction : values()) {
			if (Objects.equals(deploymentAction.getValue(), value)) {
				return deploymentAction;
			}
		}

		return null;
	}

	@JsonValue
	public String getValue() {
		return _value;
	}

	@Override
	public String toString() {
		return _value;
	}

	private DeploymentAction(String value) {
		_value = value;
	}

	private final String _value;

}