/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.resource.manager;

import com.liferay.portal.kernel.resource.ResourceRetriever;

/**
 * @author Miguel Pastor
 */
public interface ResourceManager {

	public ResourceRetriever getResourceRetriever(String location);

}