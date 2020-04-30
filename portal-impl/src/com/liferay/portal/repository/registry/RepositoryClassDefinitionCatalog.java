/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.repository.registry;

import com.liferay.portal.kernel.util.ResourceBundleLoader;
import com.liferay.portal.repository.util.ExternalRepositoryFactory;

import java.util.Collection;

/**
 * @author Adolfo Pérez
 */
public interface RepositoryClassDefinitionCatalog {

	public Iterable<RepositoryClassDefinition>
		getExternalRepositoryClassDefinitions();

	public Collection<String> getExternalRepositoryClassNames();

	public RepositoryClassDefinition getRepositoryClassDefinition(
		String className);

	public void registerLegacyExternalRepositoryFactory(
		String className, ExternalRepositoryFactory externalRepositoryFactory,
		ResourceBundleLoader resourceBundleLoader);

	public void unregisterLegacyExternalRepositoryFactory(String className);

}