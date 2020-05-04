/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.staging.taglib.servlet.taglib;

import com.liferay.portal.kernel.model.StagedModel;
import com.liferay.staging.taglib.internal.servlet.ServletContextUtil;
import com.liferay.taglib.util.IncludeTag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

/**
 * @author Levente Hudák
 */
public class StatusTag extends IncludeTag {

	public String getCssClass() {
		return _cssClass;
	}

	public StagedModel getStagedModel() {
		return _stagedModel;
	}

	public void setCssClass(String cssClass) {
		_cssClass = cssClass;
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);

		servletContext = ServletContextUtil.getServletContext();
	}

	public void setStagedModel(StagedModel stagedModel) {
		_stagedModel = stagedModel;
	}

	@Override
	protected void cleanUp() {
		super.cleanUp();

		_cssClass = null;
		_stagedModel = null;
	}

	@Override
	protected String getPage() {
		return _PAGE;
	}

	@Override
	protected void setAttributes(HttpServletRequest httpServletRequest) {
		httpServletRequest.setAttribute(
			"liferay-staging:status:cssClass", _cssClass);
		httpServletRequest.setAttribute(
			"liferay-staging:status:stagedModel", _stagedModel);
	}

	private static final String _PAGE = "/status/page.jsp";

	private String _cssClass;
	private StagedModel _stagedModel;

}