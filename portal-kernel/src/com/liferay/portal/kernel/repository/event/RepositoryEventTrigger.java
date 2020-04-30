/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.repository.event;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Adolfo Pérez
 */
public interface RepositoryEventTrigger {

	public <S extends RepositoryEventType, T> void trigger(
			Class<S> repositoryEventTypeClass, Class<T> modelClass, T model)
		throws PortalException;

}