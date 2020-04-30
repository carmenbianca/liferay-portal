/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.definition.export;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Michael C. Han
 */
public interface DefinitionExporter {

	public String export(long kaleoDefinitionId) throws PortalException;

	public String export(long companyId, String name, int version)
		throws PortalException;

}