/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.scope.liferay;

/**
 * Represents a {@code ServiceTrackerMap} that also checks for portal instance
 * specialization. A best match is registered for both the portal instance and
 * the key. If no such service exists, the next best matches only the key. If no
 * service is registered for the key, a service registered for the portal
 * instance matches.
 *
 * @author Carlos Sierra Andrés
 * @see    com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMap
 */
public interface ScopedServiceTrackerMap<T> {

	public void close();

	public T getService(long companyId, String key);

}