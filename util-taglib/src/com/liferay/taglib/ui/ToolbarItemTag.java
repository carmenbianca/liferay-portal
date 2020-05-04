/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.taglib.ui;

import com.liferay.portal.kernel.servlet.taglib.ui.ToolbarItem;
import com.liferay.taglib.util.IncludeTag;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Iván Zaera
 */
public class ToolbarItemTag extends IncludeTag {

	@Override
	public int doStartTag() {
		return EVAL_BODY_INCLUDE;
	}

	public ToolbarItem getToolbarItem() {
		return _toolbarItem;
	}

	public void setToolbarItem(ToolbarItem toolbarItem) {
		_toolbarItem = toolbarItem;
	}

	@Override
	protected void cleanUp() {
		super.cleanUp();

		_toolbarItem = null;
	}

	@Override
	protected String getPage() {
		return _PAGE;
	}

	@Override
	protected boolean isCleanUpSetAttributes() {
		return _CLEAN_UP_SET_ATTRIBUTES;
	}

	@Override
	protected void setAttributes(HttpServletRequest httpServletRequest) {
		httpServletRequest.setAttribute(
			"liferay-ui:toolbar-item:toolbarItem", _toolbarItem);
	}

	private static final boolean _CLEAN_UP_SET_ATTRIBUTES = true;

	private static final String _PAGE = "/html/taglib/ui/toolbar_item/page.jsp";

	private ToolbarItem _toolbarItem;

}