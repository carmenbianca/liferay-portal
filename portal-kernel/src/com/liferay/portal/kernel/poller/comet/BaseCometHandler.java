/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.poller.comet;

/**
 * @author Edward Han
 * @author Brian Wing Shun Chan
 */
public abstract class BaseCometHandler implements CometHandler {

	@Override
	public abstract CometHandler clone();

	@Override
	public void destroy() throws CometException {
		_cometState = CometState.STATE_CLOSED;

		try {
			doDestroy();
		}
		catch (CometException cometException) {
			throw cometException;
		}
		catch (Exception exception) {
			throw new CometException(exception);
		}
	}

	@Override
	public CometSession getCometSession() {
		return _cometSession;
	}

	@Override
	public CometState getCometState() {
		return _cometState;
	}

	@Override
	public void init(CometSession cometSession) throws CometException {
		_cometSession = cometSession;
		_cometState = CometState.STATE_READY;

		try {
			doInit(cometSession);
		}
		catch (CometException cometException) {
			throw cometException;
		}
		catch (Exception exception) {
			throw new CometException(exception);
		}
	}

	@Override
	public void receiveData(char[] data) throws CometException {
		receiveData(new String(data));
	}

	protected void doDestroy() throws Exception {
	}

	protected void doInit(CometSession cometSession) throws Exception {
	}

	private CometSession _cometSession;
	private CometState _cometState = CometState.STATE_OPEN;

}