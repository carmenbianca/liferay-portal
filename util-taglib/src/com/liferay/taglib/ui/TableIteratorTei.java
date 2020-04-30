/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.taglib.ui;

import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.VariableInfo;

/**
 * @author Brian Wing Shun Chan
 */
public class TableIteratorTei extends TagExtraInfo {

	@Override
	public VariableInfo[] getVariableInfo(TagData tagData) {
		String listType = tagData.getAttributeString("listType");

		return new VariableInfo[] {
			new VariableInfo(
				"tableIteratorObj", listType, true, VariableInfo.NESTED),
			new VariableInfo(
				"tableIteratorPos", Integer.class.getName(), true,
				VariableInfo.NESTED)
		};
	}

}