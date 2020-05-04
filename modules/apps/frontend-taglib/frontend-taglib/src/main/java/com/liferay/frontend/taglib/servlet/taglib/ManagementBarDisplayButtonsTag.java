/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.servlet.taglib;

import com.liferay.frontend.taglib.internal.servlet.ServletContextUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.taglib.util.IncludeTag;

import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTag;

/**
 * @author Eudaldo Alonso
 */
public class ManagementBarDisplayButtonsTag
	extends IncludeTag implements BodyTag {

	@Override
	public int doStartTag() throws JspException {
		setAttributeNamespace(_ATTRIBUTE_NAMESPACE);

		return super.doStartTag();
	}

	public String[] getDisplayViews() {
		return _displayViews;
	}

	public PortletURL getPortletURL() {
		return _portletURL;
	}

	public String getSelectedDisplayStyle() {
		return _selectedDisplayStyle;
	}

	public void setDisabled(boolean disabled) {
		_disabled = disabled;
	}

	public void setDisplayViews(String[] displayViews) {
		_displayViews = displayViews;
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);

		servletContext = ServletContextUtil.getServletContext();
	}

	public void setPortletURL(PortletURL portletURL) {
		_portletURL = portletURL;
	}

	public void setSelectedDisplayStyle(String selectedDisplayStyle) {
		_selectedDisplayStyle = selectedDisplayStyle;
	}

	@Override
	protected void cleanUp() {
		super.cleanUp();

		_disabled = null;
		_displayViews = null;
		_portletURL = null;
		_selectedDisplayStyle = StringPool.BLANK;
	}

	@Override
	protected String getPage() {
		return _PAGE;
	}

	@Override
	protected boolean isCleanUpSetAttributes() {
		return _CLEAN_UP_SET_ATTRIBUTES;
	}

	protected boolean isDisabled() {
		ManagementBarTag managementBarTag =
			(ManagementBarTag)findAncestorWithClass(
				this, ManagementBarTag.class);

		boolean disabled = false;

		if (_disabled != null) {
			disabled = _disabled;
		}
		else if (managementBarTag != null) {
			disabled = managementBarTag.isDisabled();
		}

		return disabled;
	}

	@Override
	protected int processStartTag() throws Exception {
		return EVAL_BODY_BUFFERED;
	}

	@Override
	protected void setAttributes(HttpServletRequest httpServletRequest) {
		httpServletRequest.setAttribute(
			"liferay-frontend:management-bar-display-buttons:defaultViews",
			_DEFAULT_VIEWS);
		httpServletRequest.setAttribute(
			"liferay-frontend:management-bar-display-buttons:disabled",
			isDisabled());
		httpServletRequest.setAttribute(
			"liferay-frontend:management-bar-display-buttons:displayViews",
			_displayViews);
		httpServletRequest.setAttribute(
			"liferay-frontend:management-bar-display-buttons:portletURL",
			_portletURL);
		httpServletRequest.setAttribute(
			"liferay-frontend:management-bar-display-buttons:" +
				"selectedDisplayStyle",
			_selectedDisplayStyle);
	}

	private static final String _ATTRIBUTE_NAMESPACE =
		"liferay-frontend:management-bar-display-buttons:";

	private static final boolean _CLEAN_UP_SET_ATTRIBUTES = true;

	private static final String[] _DEFAULT_VIEWS = {
		"icon", "descriptive", "list"
	};

	private static final String _PAGE =
		"/management_bar_display_buttons/page.jsp";

	private Boolean _disabled;
	private String[] _displayViews;
	private PortletURL _portletURL;
	private String _selectedDisplayStyle = StringPool.BLANK;

}