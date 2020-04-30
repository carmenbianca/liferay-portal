/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.taglib.ui;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.util.Validator;

import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.VariableInfo;

/**
 * @author Raymond Augé
 */
public class SearchContainerTei extends TagExtraInfo {

	@Override
	public VariableInfo[] getVariableInfo(TagData tagData) {
		String totalVar = tagData.getAttributeString("totalVar");

		if (Validator.isNull(totalVar)) {
			totalVar = SearchContainer.DEFAULT_TOTAL_VAR;
		}

		String var = tagData.getAttributeString("var");

		if (Validator.isNull(var)) {
			var = SearchContainer.DEFAULT_VAR;
		}

		return new VariableInfo[] {
			new VariableInfo(
				totalVar, Integer.class.getName(), true, VariableInfo.NESTED),
			new VariableInfo(
				var, SearchContainer.class.getName(), true, VariableInfo.NESTED)
		};
	}

}