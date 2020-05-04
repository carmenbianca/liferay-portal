/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.application.list.taglib.servlet.taglib;

import com.liferay.application.list.PanelCategory;
import com.liferay.application.list.constants.ApplicationListWebKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.taglib.servlet.PipingServletResponse;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

/**
 * @author Eudaldo Alonso
 */
public class PanelCategoryContentTag extends BasePanelTag {

	@Override
	public int doEndTag() throws JspException {
		request.setAttribute(
			ApplicationListWebKeys.PANEL_CATEGORY, _panelCategory);

		try {
			boolean include = _panelCategory.include(
				request,
				PipingServletResponse.createPipingServletResponse(pageContext));

			if (include) {
				doClearTag();

				return EVAL_PAGE;
			}
		}
		catch (IOException ioException) {
			_log.error("Unable to include panel category", ioException);
		}

		return super.doEndTag();
	}

	@Override
	public int doStartTag() throws JspException {
		return EVAL_BODY_INCLUDE;
	}

	public PanelCategory getPanelCategory() {
		return _panelCategory;
	}

	public boolean isShowOpen() {
		return _showOpen;
	}

	public void setPanelCategory(PanelCategory panelCategory) {
		_panelCategory = panelCategory;
	}

	public void setShowOpen(boolean showOpen) {
		_showOpen = showOpen;
	}

	@Override
	protected void cleanUp() {
		super.cleanUp();

		_panelCategory = null;
		_showOpen = false;
	}

	@Override
	protected String getPage() {
		return "/panel_category_content/page.jsp";
	}

	@Override
	protected void setAttributes(HttpServletRequest httpServletRequest) {
		httpServletRequest.setAttribute(
			"liferay-application-list:panel-category-content:panelCategory",
			_panelCategory);
		httpServletRequest.setAttribute(
			"liferay-application-list:panel-category-content:showOpen",
			_showOpen);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		PanelCategoryContentTag.class);

	private PanelCategory _panelCategory;
	private boolean _showOpen;

}