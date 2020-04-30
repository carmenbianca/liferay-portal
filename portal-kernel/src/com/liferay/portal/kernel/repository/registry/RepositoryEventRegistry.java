/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.repository.registry;

import com.liferay.portal.kernel.repository.event.RepositoryEventListener;
import com.liferay.portal.kernel.repository.event.RepositoryEventType;

/**
 * @author Adolfo Pérez
 */
public interface RepositoryEventRegistry {

	public <S extends RepositoryEventType, T> void
		registerRepositoryEventListener(
			Class<S> repositoryEventTypeClass, Class<T> modelClass,
			RepositoryEventListener<S, T> repositoryEventListeners);

	public default <S extends RepositoryEventType, T> void
		unregisterRepositoryEventListener(
			Class<S> repositoryEventTypeClass, Class<T> modelClass,
			RepositoryEventListener<S, T> repositoryEventListener) {
	}

}