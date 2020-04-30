/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.clay.servlet.taglib.util;

/**
 * @author Adolfo Pérez
 */
public class SelectOption {

	public SelectOption(String label, String value) {
		this(label, value, false);
	}

	public SelectOption(String label, String value, boolean selected) {
		_label = label;
		_value = value;
		_selected = selected;
	}

	public String getLabel() {
		return _label;
	}

	public String getValue() {
		return _value;
	}

	public boolean isSelected() {
		return _selected;
	}

	private final String _label;
	private final boolean _selected;
	private final String _value;

}