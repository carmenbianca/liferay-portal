/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.analytics.client;

import com.liferay.analytics.model.IdentityContextMessage;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Eduardo García
 */
@ProviderType
public interface IdentityClient {

	public String getUserId(IdentityContextMessage identityContextMessage)
		throws Exception;

}