/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.definition.internal.export.builder;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.workflow.kaleo.definition.Definition;

/**
 * @author Michael C. Han
 */
public interface DefinitionBuilder {

	public Definition buildDefinition(long kaleoDefinitionId)
		throws PortalException;

	public Definition buildDefinition(long companyId, String name, int version)
		throws PortalException;

}