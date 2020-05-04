/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.taglib.theme;

import com.liferay.portal.kernel.model.Theme;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.taglib.servlet.PipingServletResponse;
import com.liferay.taglib.util.ThemeUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

/**
 * @author Brian Wing Shun Chan
 */
public class IncludeTag extends com.liferay.taglib.util.IncludeTag {

	@Override
	public int doEndTag() throws JspException {
		try {
			HttpServletRequest httpServletRequest = getRequest();

			Theme theme = (Theme)httpServletRequest.getAttribute(WebKeys.THEME);

			ThemeUtil.include(
				getServletContext(), httpServletRequest,
				PipingServletResponse.createPipingServletResponse(pageContext),
				getPage(), theme);

			return EVAL_PAGE;
		}
		catch (Exception exception) {
			throw new JspException(exception);
		}
	}

}