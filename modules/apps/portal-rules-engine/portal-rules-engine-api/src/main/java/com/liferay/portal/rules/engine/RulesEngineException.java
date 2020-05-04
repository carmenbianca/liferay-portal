/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.rules.engine;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Michael C. Han
 */
public class RulesEngineException extends PortalException {

	public RulesEngineException(String msg) {
		super(msg);
	}

	public RulesEngineException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RulesEngineException(Throwable cause) {
		super(cause);
	}

}