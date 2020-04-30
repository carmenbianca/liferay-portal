/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.nio.intraband.rpc;

import java.io.Serializable;

/**
 * @author Shuyang Zhou
 */
public class RPCResponse implements Serializable {

	public RPCResponse(Exception exception) {
		_exception = exception;

		_result = null;
	}

	public RPCResponse(Serializable result) {
		_result = result;

		_exception = null;
	}

	public Exception getException() {
		return _exception;
	}

	public Serializable getResult() {
		return _result;
	}

	private static final long serialVersionUID = 1L;

	private final Exception _exception;
	private final Serializable _result;

}