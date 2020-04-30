/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet.taglib.ui;

/**
 * @author Iván Zaera
 */
public abstract class ToolbarItem extends BaseUIItem implements UIActionItem {

	@Override
	public String getIcon() {
		return _icon;
	}

	@Override
	public String getLabel() {
		return _label;
	}

	@Override
	public void setIcon(String icon) {
		_icon = icon;
	}

	@Override
	public void setLabel(String label) {
		_label = label;
	}

	private String _icon;
	private String _label;

}