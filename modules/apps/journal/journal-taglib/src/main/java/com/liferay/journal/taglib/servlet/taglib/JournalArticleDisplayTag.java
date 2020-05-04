/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.taglib.servlet.taglib;

import com.liferay.journal.model.JournalArticleDisplay;
import com.liferay.journal.taglib.internal.servlet.ServletContextUtil;
import com.liferay.taglib.util.IncludeTag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

/**
 * @author Alejandro Tardín
 */
public class JournalArticleDisplayTag extends IncludeTag {

	public JournalArticleDisplay getArticleDisplay() {
		return _articleDisplay;
	}

	public String getWrapperCssClass() {
		return _wrapperCssClass;
	}

	public boolean isShowTitle() {
		return _showTitle;
	}

	public void setArticleDisplay(JournalArticleDisplay articleDisplay) {
		_articleDisplay = articleDisplay;
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);

		servletContext = ServletContextUtil.getServletContext();
	}

	public void setShowTitle(boolean showTitle) {
		_showTitle = showTitle;
	}

	public void setWrapperCssClass(String wrapperCssClass) {
		_wrapperCssClass = wrapperCssClass;
	}

	@Override
	protected void cleanUp() {
		super.cleanUp();

		_articleDisplay = null;
		_showTitle = false;
		_wrapperCssClass = null;
	}

	@Override
	protected String getPage() {
		return _PAGE;
	}

	@Override
	protected void setAttributes(HttpServletRequest httpServletRequest) {
		httpServletRequest.setAttribute(
			"liferay-journal:journal-article:articleDisplay", _articleDisplay);
		httpServletRequest.setAttribute(
			"liferay-journal:journal-article:showTitle",
			String.valueOf(_showTitle));
		httpServletRequest.setAttribute(
			"liferay-journal:journal-article:wrapperCssClass",
			_wrapperCssClass);
	}

	private static final String _PAGE = "/journal_article/page.jsp";

	private JournalArticleDisplay _articleDisplay;
	private boolean _showTitle;
	private String _wrapperCssClass;

}