/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.service.access.quota.metric;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Stian Sigvartsen
 */
@ProviderType
public interface SAQContextMatcher {

	public Set<String> getMetricNames();

	public boolean matches(String metricName, String metricValue);

}