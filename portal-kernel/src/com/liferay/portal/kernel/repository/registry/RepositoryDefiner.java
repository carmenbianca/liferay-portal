/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.repository.registry;

import com.liferay.portal.kernel.repository.DocumentRepository;
import com.liferay.portal.kernel.repository.RepositoryConfiguration;

import java.util.Locale;

/**
 * @author Adolfo Pérez
 */
public interface RepositoryDefiner {

	public String getClassName();

	public RepositoryConfiguration getRepositoryConfiguration();

	public String getRepositoryTypeLabel(Locale locale);

	public boolean isExternalRepository();

	public void registerCapabilities(
		CapabilityRegistry<DocumentRepository> capabilityRegistry);

	public void registerRepositoryEventListeners(
		RepositoryEventRegistry repositoryEventRegistry);

	public void registerRepositoryFactory(
		RepositoryFactoryRegistry repositoryFactoryRegistry);

}