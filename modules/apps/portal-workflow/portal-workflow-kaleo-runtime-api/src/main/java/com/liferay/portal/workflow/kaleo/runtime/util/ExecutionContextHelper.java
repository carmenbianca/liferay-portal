/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.runtime.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;

/**
 * @author Michael C. Han
 */
public interface ExecutionContextHelper {

	public void checkKaleoInstanceComplete(ExecutionContext executionContext)
		throws PortalException;

	public void completeKaleoTimerInstances(ExecutionContext executionContext)
		throws PortalException;

	public String convert(ExecutionContext executionContext);

	public ExecutionContext convert(String json) throws Exception;

	public boolean isKaleoInstanceBlocked(ExecutionContext executionContext);

}