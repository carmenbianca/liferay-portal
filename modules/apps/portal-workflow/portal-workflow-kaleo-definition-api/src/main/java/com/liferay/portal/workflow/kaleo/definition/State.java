/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.definition;

import java.util.Map;

/**
 * @author Michael C. Han
 */
public class State extends Node {

	public State(String name, String description, boolean initial) {
		super(NodeType.STATE, name, description);

		_initial = initial;
	}

	public boolean isInitial() {
		return _initial;
	}

	public boolean isTerminal() {
		Map<String, Transition> outgoingTransitions = getOutgoingTransitions();

		return outgoingTransitions.isEmpty();
	}

	private final boolean _initial;

}