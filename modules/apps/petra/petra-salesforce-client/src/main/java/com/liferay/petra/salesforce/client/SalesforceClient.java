/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.salesforce.client;

import com.sforce.ws.ConnectorConfig;

/**
 * @author Brian Wing Shun Chan
 * @author Peter Shin
 * @author Rachael Koestartyo
 */
public interface SalesforceClient {

	public String getAuthEndpoint();

	public int getConnectionTimeout();

	public ConnectorConfig getConnectorConfig();

	public String getPassword();

	public int getReadTimeout();

	public String getServiceEndpoint();

	public String getSessionId();

	public String getUserName();

	public boolean isDebugEnabled();

	public void setAuthEndpoint(String authEndpoint);

	public void setConnectionTimeout(int connectionTimeout);

	public void setDebugEnabled(boolean debugEnabled);

	public void setPassword(String password);

	public void setReadTimeout(int readTimeout);

	public void setServiceEndpoint(String serviceEndpoint);

	public void setSessionId(String sessionId);

	public void setUserName(String userName);

}