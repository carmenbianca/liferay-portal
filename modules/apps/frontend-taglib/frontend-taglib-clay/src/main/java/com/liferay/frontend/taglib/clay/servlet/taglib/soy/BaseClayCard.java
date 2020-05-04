/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.clay.servlet.taglib.soy;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;

import java.util.List;
import java.util.Map;

/**
 * @author Eudaldo Alonso
 */
public interface BaseClayCard {

	public default List<DropdownItem> getActionDropdownItems() {
		return null;
	}

	public default String getAspectRatioCssClasses() {
		return null;
	}

	public default String getComponentId() {
		return null;
	}

	public default Map<String, String> getData() {
		return null;
	}

	public default String getDefaultEventHandler() {
		return null;
	}

	public default String getElementClasses() {
		return null;
	}

	public default String getGroupName() {
		return null;
	}

	public default String getHref() {
		return null;
	}

	public default String getId() {
		return null;
	}

	public default String getInputName() {
		return null;
	}

	public default String getInputValue() {
		return null;
	}

	public default String getSpritemap() {
		return null;
	}

	public default boolean isDisabled() {
		return false;
	}

	public default boolean isSelectable() {
		return true;
	}

	public default boolean isSelected() {
		return false;
	}

}