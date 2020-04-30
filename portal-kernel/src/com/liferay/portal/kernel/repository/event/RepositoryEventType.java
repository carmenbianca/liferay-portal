/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.repository.event;

/**
 * @author Adolfo Pérez
 */
public interface RepositoryEventType {

	public interface Add extends RepositoryEventType {
	}

	public interface Delete extends RepositoryEventType {
	}

	public interface Move extends RepositoryEventType {
	}

	public interface Update extends RepositoryEventType {
	}

}