/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.definition;

/**
 * @author Marcellus Tavares
 */
public class ResourceActionAssignment extends Assignment {

	public ResourceActionAssignment(String actionId) {
		super(AssignmentType.RESOURCE_ACTION);

		_actionId = actionId;
	}

	public String getActionId() {
		return _actionId;
	}

	public void setActionId(String actionId) {
		_actionId = actionId;
	}

	private String _actionId;

}