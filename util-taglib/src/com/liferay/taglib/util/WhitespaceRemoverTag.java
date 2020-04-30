/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.taglib.util;

import com.liferay.petra.string.CharPool;
import com.liferay.portal.kernel.util.StringUtil;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * @author Brian Wing Shun Chan
 */
public class WhitespaceRemoverTag extends BodyTagSupport {

	@Override
	public int doEndTag() throws JspException {
		try {
			JspWriter jspWriter = pageContext.getOut();

			jspWriter.write(getBodyContentString());
		}
		catch (Exception exception) {
			throw new JspException(exception);
		}

		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() {
		return EVAL_BODY_BUFFERED;
	}

	protected String getBodyContentString() {
		BodyContent bodyContent = getBodyContent();

		String bodyContentString = StringUtil.trim(bodyContent.getString());

		return StringUtil.removeChars(
			bodyContentString, CharPool.NEW_LINE, CharPool.TAB);
	}

}