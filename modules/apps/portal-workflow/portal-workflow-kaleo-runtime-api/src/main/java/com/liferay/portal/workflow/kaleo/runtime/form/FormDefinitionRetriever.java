/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.runtime.form;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskForm;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceToken;

/**
 * @author Michael C. Han
 */
public interface FormDefinitionRetriever {

	public String getFormDefinition(
			KaleoTaskForm kaleoTaskForm,
			KaleoTaskInstanceToken kaleoTaskInstanceToken)
		throws PortalException;

}