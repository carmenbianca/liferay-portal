/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.servlet.taglib;

import com.liferay.frontend.taglib.internal.servlet.ServletContextUtil;
import com.liferay.portal.kernel.diff.DiffResult;
import com.liferay.taglib.util.IncludeTag;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

/**
 * @author Bruno Farache
 */
public class DiffTag extends IncludeTag {

	public List<DiffResult>[] getDiffResults() {
		return _diffResults;
	}

	public String getSourceName() {
		return _sourceName;
	}

	public String getTargetName() {
		return _targetName;
	}

	public void setDiffResults(List<DiffResult>[] diffResults) {
		_diffResults = diffResults;
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);

		servletContext = ServletContextUtil.getServletContext();
	}

	public void setSourceName(String sourceName) {
		_sourceName = sourceName;
	}

	public void setTargetName(String targetName) {
		_targetName = targetName;
	}

	@Override
	protected void cleanUp() {
		super.cleanUp();

		_diffResults = null;
		_sourceName = null;
		_targetName = null;
	}

	@Override
	protected String getPage() {
		return _PAGE;
	}

	@Override
	protected void setAttributes(HttpServletRequest httpServletRequest) {
		httpServletRequest.setAttribute(
			"liferay-frontend:diff:diffResults", _diffResults);
		httpServletRequest.setAttribute(
			"liferay-frontend:diff:sourceName", _sourceName);
		httpServletRequest.setAttribute(
			"liferay-frontend:diff:targetName", _targetName);
	}

	private static final String _PAGE = "/diff/page.jsp";

	private List<DiffResult>[] _diffResults;
	private String _sourceName;
	private String _targetName;

}