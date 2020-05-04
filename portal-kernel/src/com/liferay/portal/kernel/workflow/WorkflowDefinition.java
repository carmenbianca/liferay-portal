/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.workflow;

import java.io.InputStream;

import java.util.Date;
import java.util.Map;

/**
 * @author Micha Kiener
 * @author Shuyang Zhou
 * @author Brian Wing Shun Chan
 * @author Eduardo Lundgren
 */
public interface WorkflowDefinition {

	public default long getCompanyId() {
		return 0;
	}

	public String getContent();

	public default String getDescription() {
		return "";
	}

	public InputStream getInputStream();

	public default Date getModifiedDate() {
		return null;
	}

	public String getName();

	public Map<String, Object> getOptionalAttributes();

	public String getTitle();

	public String getTitle(String languageId);

	public default long getUserId() {
		return 0;
	}

	public int getVersion();

	public default long getWorkflowDefinitionId() {
		return 0;
	}

	public boolean isActive();

}