/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.servlet.taglib;

import com.liferay.frontend.taglib.internal.servlet.ServletContextUtil;
import com.liferay.taglib.util.IncludeTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;

/**
 * @author Eudaldo Alonso
 */
public class ManagementBarFiltersTag extends IncludeTag implements BodyTag {

	@Override
	public int doEndTag() {
		BodyContent bodyContent = getBodyContent();

		if (bodyContent != null) {
			ManagementBarTag managementBarTag =
				(ManagementBarTag)findAncestorWithClass(
					this, ManagementBarTag.class);

			managementBarTag.setFilters(bodyContent.getString());
		}

		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		setAttributeNamespace(_ATTRIBUTE_NAMESPACE);

		return super.doStartTag();
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);

		servletContext = ServletContextUtil.getServletContext();
	}

	@Override
	protected String getPage() {
		return _PAGE;
	}

	@Override
	protected int processStartTag() throws Exception {
		return EVAL_BODY_BUFFERED;
	}

	private static final String _ATTRIBUTE_NAMESPACE =
		"liferay-frontend:management-bar-filters:";

	private static final String _PAGE = "/management_bar_filters/page.jsp";

}