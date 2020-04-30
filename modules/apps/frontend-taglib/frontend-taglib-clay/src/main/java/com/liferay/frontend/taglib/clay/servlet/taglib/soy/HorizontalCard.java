/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.clay.servlet.taglib.soy;

/**
 * @author Eudaldo Alonso
 */
public interface HorizontalCard extends BaseClayCard {

	public default String getIcon() {
		return null;
	}

	public String getTitle();

}