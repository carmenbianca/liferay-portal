/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.repository.event;

/**
 * @author Adolfo Pérez
 */
public interface TrashRepositoryEventType extends RepositoryEventType {

	public interface EntryRestored extends TrashRepositoryEventType {
	}

	public interface EntryTrashed extends TrashRepositoryEventType {
	}

}