/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.runtime.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.rules.engine.Fact;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;

import java.util.List;

/**
 * @author Michael C. Han
 */
public interface RulesContextBuilder {

	public List<Fact<?>> buildRulesContext(ExecutionContext executionContext)
		throws PortalException;

}