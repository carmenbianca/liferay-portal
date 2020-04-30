/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.facet.display.context;

/**
 * @author André de Oliveira
 */
public class AssetTagsSearchFacetTermDisplayContext {

	public String getDisplayName() {
		return _value;
	}

	public int getFrequency() {
		return _frequency;
	}

	public int getPopularity() {
		return _popularity;
	}

	public String getValue() {
		return _value;
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

	public void setFrequencyVisible(boolean frequencyVisible) {
		_frequencyVisible = frequencyVisible;
	}

	public void setPopularity(int popularity) {
		_popularity = popularity;
	}

	public void setSelected(boolean selected) {
		_selected = selected;
	}

	public void setValue(String value) {
		_value = value;
	}

	private int _frequency;
	private boolean _frequencyVisible;
	private int _popularity;
	private boolean _selected;
	private String _value;

}