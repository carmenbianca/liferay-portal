/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.runtime.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;

import java.util.Map;

/**
 * @author Michael C. Han
 */
public interface ScriptingContextBuilder {

	public Map<String, Object> buildScriptingContext(
			ExecutionContext executionContext)
		throws PortalException;

}