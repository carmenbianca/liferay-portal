/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.repository;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Adolfo Pérez
 */
public class RepositoryFactoryUtil {

	public static LocalRepository createLocalRepository(long repositoryId)
		throws PortalException {

		return getRepositoryFactory().createLocalRepository(repositoryId);
	}

	public static Repository createRepository(long repositoryId)
		throws PortalException {

		return getRepositoryFactory().createRepository(repositoryId);
	}

	public static RepositoryFactory getRepositoryFactory() {
		return _repositoryFactory;
	}

	public void setRepositoryFactory(RepositoryFactory repositoryFactory) {
		_repositoryFactory = repositoryFactory;
	}

	private static RepositoryFactory _repositoryFactory;

}