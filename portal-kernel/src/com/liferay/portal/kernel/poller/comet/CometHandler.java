/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.poller.comet;

/**
 * @author Edward Han
 * @author Brian Wing Shun Chan
 */
public interface CometHandler {

	public CometHandler clone();

	public void destroy() throws CometException;

	public CometSession getCometSession();

	public CometState getCometState();

	public void init(CometSession cometSession) throws CometException;

	public void receiveData(char[] data) throws CometException;

	public void receiveData(String data) throws CometException;

}