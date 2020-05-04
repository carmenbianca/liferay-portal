/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.sort.display.context;

/**
 * @author Wade Cao
 * @author André de Oliveira
 */
public class SortTermDisplayContext {

	public String getField() {
		return _field;
	}

	public String getLabel() {
		return _label;
	}

	public String getLanguageLabel() {
		return _languageLabel;
	}

	public boolean isSelected() {
		return _selected;
	}

	public void setField(String field) {
		_field = field;
	}

	public void setLabel(String label) {
		_label = label;
	}

	public void setLanguageLabel(String languageLabel) {
		_languageLabel = languageLabel;
	}

	public void setSelected(boolean selected) {
		_selected = selected;
	}

	private String _field;
	private String _label;
	private String _languageLabel;
	private boolean _selected;

}