/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.taglib.ui;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.Validator;

import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.VariableInfo;

/**
 * @author Raymond Augé
 */
public class SearchContainerColumnTextTei extends TagExtraInfo {

	@Override
	public VariableInfo[] getVariableInfo(TagData tagData) {
		String buffer = tagData.getAttributeString("buffer");

		if (Validator.isNotNull(buffer)) {
			return new VariableInfo[] {
				new VariableInfo(
					buffer, StringBundler.class.getName(), true,
					VariableInfo.NESTED)
			};
		}

		return null;
	}

}