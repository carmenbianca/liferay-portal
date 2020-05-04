/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.dynamic.section.servlet.taglib;

import com.liferay.petra.string.StringBundler;
import com.liferay.taglib.TagSupport;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;

/**
 * @author Matthew Tambara
 */
public class DynamicSectionOriginalBodyTag extends TagSupport {

	@Override
	public int doEndTag() throws JspException {
		ServletRequest servletRequest = pageContext.getRequest();

		StringBundler sb = (StringBundler)servletRequest.getAttribute(
			_PREFIX.concat(_name));

		if (sb == null) {
			throw new IllegalArgumentException(
				"No original body for name " + _name);
		}

		try {
			sb.writeTo(pageContext.getOut());

			return EVAL_PAGE;
		}
		catch (IOException ioException) {
			throw new JspException(ioException);
		}
		finally {
			_name = null;
		}
	}

	public void setName(String name) {
		_name = name;
	}

	private static final String _PREFIX =
		DynamicSectionTag.class.getName() + "#";

	private String _name;

}