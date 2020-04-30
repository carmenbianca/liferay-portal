/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.facet.display.context;

import java.io.Serializable;

/**
 * @author Lino Alves
 */
public class UserSearchFacetTermDisplayContext implements Serializable {

	public int getFrequency() {
		return _frequency;
	}

	public String getUserName() {
		return _userName;
	}

	public boolean isFrequencyVisible() {
		return _frequencyVisible;
	}

	public boolean isSelected() {
		return _selected;
	}

	public void setFrequency(int frequency) {
		_frequency = frequency;
	}

	public void setFrequencyVisible(boolean showFrequency) {
		_frequencyVisible = showFrequency;
	}

	public void setSelected(boolean selected) {
		_selected = selected;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	private int _frequency;
	private boolean _frequencyVisible;
	private boolean _selected;
	private String _userName;

}