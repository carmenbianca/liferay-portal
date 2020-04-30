/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field;

import com.liferay.digital.signature.model.field.DSListItem;

/**
 * @author Michael C. Han
 */
public class DSListItemImpl implements DSListItem {

	public DSListItemImpl(boolean selected, String text, String value) {
		_selected = selected;
		_text = text;
		_value = value;
	}

	public DSListItemImpl(String text, String value) {
		this(false, text, value);
	}

	@Override
	public String getText() {
		return _text;
	}

	@Override
	public String getValue() {
		return _value;
	}

	@Override
	public boolean isSelected() {
		return _selected;
	}

	private final boolean _selected;
	private final String _text;
	private final String _value;

}