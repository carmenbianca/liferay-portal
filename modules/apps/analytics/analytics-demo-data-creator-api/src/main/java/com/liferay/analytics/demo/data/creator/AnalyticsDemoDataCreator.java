/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.analytics.demo.data.creator;

import com.liferay.portal.kernel.exception.PortalException;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Rachael Koestartyo
 */
@ProviderType
public interface AnalyticsDemoDataCreator {

	public void create() throws Exception;

	public void delete() throws PortalException;

}