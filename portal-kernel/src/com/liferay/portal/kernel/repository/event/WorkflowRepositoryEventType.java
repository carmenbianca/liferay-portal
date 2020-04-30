/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.repository.event;

/**
 * @author Adolfo Pérez
 */
public interface WorkflowRepositoryEventType extends RepositoryEventType {

	public interface Add extends WorkflowRepositoryEventType {
	}

	public interface Update extends WorkflowRepositoryEventType {
	}

}