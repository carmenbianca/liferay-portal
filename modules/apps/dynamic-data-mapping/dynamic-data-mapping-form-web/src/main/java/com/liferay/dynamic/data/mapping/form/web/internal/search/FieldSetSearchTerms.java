/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.web.internal.search;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

import javax.portlet.PortletRequest;

/**
 * @author Leonardo Barros
 */
public class FieldSetSearchTerms extends FieldSetDisplayTerms {

	public FieldSetSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);

		description = DAOParamUtil.getString(portletRequest, DESCRIPTION);
		name = DAOParamUtil.getString(portletRequest, NAME);
	}

}