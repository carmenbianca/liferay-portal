/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.settings;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author     Bryan Engler
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 */
@Deprecated
@ProviderType
public interface XPackSecuritySettings {

	public boolean requiresXPackSecurity();

}