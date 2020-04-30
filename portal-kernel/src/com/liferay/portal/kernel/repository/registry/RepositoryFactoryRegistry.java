/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.repository.registry;

import com.liferay.portal.kernel.repository.RepositoryFactory;

/**
 * @author Adolfo Pérez
 */
public interface RepositoryFactoryRegistry {

	public void setRepositoryFactory(RepositoryFactory repositoryFactory);

}