/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.nio.intraband.blocking;

import com.liferay.portal.kernel.nio.intraband.ChannelContext;
import com.liferay.portal.kernel.nio.intraband.Intraband;
import com.liferay.portal.kernel.nio.intraband.RegistrationReference;

import java.util.concurrent.Future;

/**
 * @author Shuyang Zhou
 */
public class FutureRegistrationReference implements RegistrationReference {

	@Override
	public void cancelRegistration() {
		readFuture.cancel(true);
		writeFuture.cancel(true);
	}

	@Override
	public Intraband getIntraband() {
		return intraband;
	}

	@Override
	public boolean isValid() {
		if (!readFuture.isDone() && !writeFuture.isDone()) {
			return true;
		}

		return false;
	}

	protected FutureRegistrationReference(
		Intraband intraband, ChannelContext channelContext,
		Future<Void> readFuture, Future<Void> writeFuture) {

		this.intraband = intraband;
		this.channelContext = channelContext;
		this.readFuture = readFuture;
		this.writeFuture = writeFuture;
	}

	protected final ChannelContext channelContext;
	protected final Intraband intraband;
	protected final Future<Void> readFuture;
	protected final Future<Void> writeFuture;

}