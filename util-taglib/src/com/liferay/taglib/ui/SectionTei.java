/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.taglib.ui;

import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.VariableInfo;

/**
 * @author Brian Wing Shun Chan
 */
public class SectionTei extends TagExtraInfo {

	@Override
	public VariableInfo[] getVariableInfo(TagData tagData) {
		return Concealer._variableInfo;
	}

	private static class Concealer {

		private static final VariableInfo[] _variableInfo = {
			new VariableInfo(
				"sectionParam", String.class.getName(), true,
				VariableInfo.NESTED),
			new VariableInfo(
				"sectionName", String.class.getName(), true,
				VariableInfo.NESTED),
			new VariableInfo(
				"sectionSelected", Boolean.class.getName(), true,
				VariableInfo.NESTED),
			new VariableInfo(
				"sectionScroll", String.class.getName(), true,
				VariableInfo.NESTED),
			new VariableInfo(
				"sectionRedirectParams", String.class.getName(), true,
				VariableInfo.NESTED)
		};

	}

}