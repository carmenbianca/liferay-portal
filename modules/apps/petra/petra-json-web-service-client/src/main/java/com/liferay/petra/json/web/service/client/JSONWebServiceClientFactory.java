/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.json.web.service.client;

import java.util.Map;

/**
 * @author Ivica Cardic
 */
public interface JSONWebServiceClientFactory {

	public JSONWebServiceClient getInstance(
			Map<String, Object> properties, boolean oAuthEnabled)
		throws Exception;

}