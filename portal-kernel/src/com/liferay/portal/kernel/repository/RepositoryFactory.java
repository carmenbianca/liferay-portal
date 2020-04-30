/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.repository;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Adolfo Pérez
 */
public interface RepositoryFactory {

	public LocalRepository createLocalRepository(long repositoryId)
		throws PortalException;

	public Repository createRepository(long repositoryId)
		throws PortalException;

}