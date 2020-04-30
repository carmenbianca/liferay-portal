/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.custom.filter.portlet.action;

/**
 * @author André de Oliveira
 */
public class QueryTypeEntry {

	public String getName() {
		return _name;
	}

	public String getTypeId() {
		return _typeId;
	}

	protected void setName(String name) {
		_name = name;
	}

	protected void setTypeId(String typeId) {
		_typeId = typeId;
	}

	private String _name;
	private String _typeId;

}