/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.salesforce.client.streaming;

import com.liferay.petra.salesforce.client.SalesforceClient;

import com.sforce.ws.ConnectionException;

import org.cometd.bayeux.Channel;

/**
 * @author Brian Wing Shun Chan
 * @author Rachael Koestartyo
 * @author Peter Shin
 */
public interface SalesforceStreamingClient extends SalesforceClient {

	public boolean connect() throws ConnectionException;

	public boolean disconnect();

	public Channel getChannel(String name);

	public int getTransportTimeout();

	public void setTransportTimeout(int transportTimeout);

}