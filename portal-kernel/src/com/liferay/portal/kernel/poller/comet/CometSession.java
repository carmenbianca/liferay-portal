/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.poller.comet;

/**
 * @author Edward Han
 * @author Brian Wing Shun Chan
 */
public interface CometSession {

	public void close() throws CometException;

	public Object getAttribute(String name);

	public CometRequest getCometRequest();

	public CometResponse getCometResponse();

	public String getSessionId();

	public void setAttribute(String name, Object object);

	public void setCometRequest(CometRequest cometRequest);

	public void setCometResponse(CometResponse cometResponse);

	public void setSessionId(String sessionId);

}