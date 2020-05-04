/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.nio.intraband;

import java.io.IOException;

/**
 * @author Shuyang Zhou
 */
public interface CompletionHandler<A> {

	public void delivered(A attachment);

	public void failed(A attachment, IOException ioException);

	public void replied(A attachment, Datagram datagram);

	public void submitted(A attachment);

	public void timedOut(A attachment);

	public static enum CompletionType {

		DELIVERED, REPLIED, SUBMITTED

	}

}