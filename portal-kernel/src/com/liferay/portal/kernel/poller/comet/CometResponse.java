/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.poller.comet;

/**
 * @author Edward Han
 * @author Brian Wing Shun Chan
 */
public interface CometResponse {

	public void close() throws CometException;

	public boolean isOpen();

	public void writeData(byte[] data) throws CometException;

	public void writeData(String data) throws CometException;

}