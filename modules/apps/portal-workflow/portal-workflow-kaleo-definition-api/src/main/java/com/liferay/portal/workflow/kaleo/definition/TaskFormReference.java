/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.definition;

/**
 * @author Michael C. Han
 */
public class TaskFormReference {

	public long getCompanyId() {
		return _companyId;
	}

	public long getFormId() {
		return _formId;
	}

	public String getFormUuid() {
		return _formUuid;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public void setFormId(long formId) {
		_formId = formId;
	}

	public void setFormUuid(String formUuid) {
		_formUuid = formUuid;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	private long _companyId;
	private long _formId;
	private String _formUuid;
	private long _groupId;

}