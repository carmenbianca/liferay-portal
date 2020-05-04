/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.web.internal.search;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletRequest;

/**
 * @author Eduardo Lundgren
 * @author Fabio Pezzutto
 */
public class CalendarResourceDisplayTerms extends DisplayTerms {

	public static final String ACTIVE = "active";

	public static final String CODE = "code";

	public static final String DESCRIPTION = "description";

	public static final String NAME = "name";

	public static final String SCOPE = "scope";

	public CalendarResourceDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);

		active = ParamUtil.getBoolean(portletRequest, ACTIVE, true);
		code = ParamUtil.getString(portletRequest, CODE);
		description = ParamUtil.getString(portletRequest, DESCRIPTION);
		name = ParamUtil.getString(portletRequest, NAME);
		scope = ParamUtil.getLong(portletRequest, SCOPE);
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public long getScope() {
		return scope;
	}

	public boolean isActive() {
		return active;
	}

	protected boolean active;
	protected String code;
	protected String description;
	protected String name;
	protected long scope;

}