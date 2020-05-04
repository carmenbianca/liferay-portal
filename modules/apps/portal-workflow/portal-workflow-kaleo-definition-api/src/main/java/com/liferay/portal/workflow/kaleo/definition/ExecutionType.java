/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.definition;

import java.util.Objects;

/**
 * @author Michael C. Han
 */
public enum ExecutionType {

	ON_ASSIGNMENT("onAssignment"), ON_ENTRY("onEntry"), ON_EXIT("onExit"),
	ON_TIMER("onTimer");

	public static ExecutionType parse(String value) {
		if (Objects.equals(ON_ASSIGNMENT.getValue(), value)) {
			return ON_ASSIGNMENT;
		}
		else if (Objects.equals(ON_ENTRY.getValue(), value)) {
			return ON_ENTRY;
		}
		else if (Objects.equals(ON_EXIT.getValue(), value)) {
			return ON_EXIT;
		}
		else if (Objects.equals(ON_TIMER.getValue(), value)) {
			return ON_TIMER;
		}
		else {
			throw new IllegalArgumentException("Invalid value " + value);
		}
	}

	public String getValue() {
		return _value;
	}

	@Override
	public String toString() {
		return _value;
	}

	private ExecutionType(String value) {
		_value = value;
	}

	private final String _value;

}