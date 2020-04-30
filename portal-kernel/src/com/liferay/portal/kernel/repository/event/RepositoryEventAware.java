/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.repository.event;

import com.liferay.portal.kernel.repository.registry.RepositoryEventRegistry;

/**
 * @author Adolfo Pérez
 */
public interface RepositoryEventAware {

	public void registerRepositoryEventListeners(
		RepositoryEventRegistry repositoryEventRegistry);

}