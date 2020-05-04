/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.search;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.PortletResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class EmptyOnClickRowChecker extends RowChecker {

	public EmptyOnClickRowChecker(PortletResponse portletResponse) {
		super(portletResponse);
	}

	@Override
	protected String getOnClick(
		String checkBoxRowIds, String checkBoxAllRowIds,
		String checkBoxPostOnClick) {

		return StringPool.BLANK;
	}

	@Override
	protected String getRowCheckBox(
		HttpServletRequest httpServletRequest, boolean checked,
		boolean disabled, String name, String value, String checkBoxRowIds,
		String checkBoxAllRowIds, String checkBoxPostOnClick) {

		StringBundler sb = new StringBundler(15);

		sb.append("<input ");

		if (checked) {
			sb.append("checked ");
		}

		sb.append("class=\"");
		sb.append(getCssClass());
		sb.append("\" ");

		if (disabled) {
			sb.append("disabled ");
		}

		sb.append("name=\"");
		sb.append(name);
		sb.append("\" title=\"");
		sb.append(LanguageUtil.get(httpServletRequest.getLocale(), "select"));
		sb.append("\" type=\"checkbox\" value=\"");
		sb.append(HtmlUtil.escapeAttribute(value));
		sb.append("\" ");

		if (Validator.isNotNull(getAllRowIds())) {
			sb.append(
				getOnClick(
					checkBoxRowIds, checkBoxAllRowIds, checkBoxPostOnClick));
		}

		sb.append(">");

		return sb.toString();
	}

}