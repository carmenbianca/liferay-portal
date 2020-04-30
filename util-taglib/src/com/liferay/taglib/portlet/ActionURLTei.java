/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.taglib.portlet;

import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.util.Validator;

import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.VariableInfo;

/**
 * @author Brian Wing Shun Chan
 */
public class ActionURLTei extends TagExtraInfo {

	@Override
	public VariableInfo[] getVariableInfo(TagData tagData) {
		String var = tagData.getAttributeString("var");

		if (Validator.isNotNull(var)) {
			return new VariableInfo[] {
				new VariableInfo(
					var, String.class.getName(), true, VariableInfo.AT_END)
			};
		}

		String varImpl = tagData.getAttributeString("varImpl");

		if (Validator.isNotNull(varImpl)) {
			return new VariableInfo[] {
				new VariableInfo(
					varImpl, LiferayPortletURL.class.getName(), true,
					VariableInfo.AT_END)
			};
		}

		return null;
	}

}