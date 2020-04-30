/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.runtime.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.workflow.kaleo.model.KaleoAction;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;

/**
 * @author Leonardo Barros
 */
public interface ActionExecutorManager {

	public void executeKaleoAction(
			KaleoAction kaleoAction, ExecutionContext executionContext)
		throws PortalException;

}