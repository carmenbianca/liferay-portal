/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.clay.servlet.taglib.soy;

/**
 * @author Eudaldo Alonso
 */
public interface UserCard extends BaseClayCard {

	public default String getImageAlt() {
		return null;
	}

	public default String getImageSrc() {
		return null;
	}

	public String getName();

	public default String getSubtitle() {
		return null;
	}

	public default String getUserColorClass() {
		return null;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getUserColorClass()}
	 */
	@Deprecated
	public default String getUserColorCssClass() {
		return null;
	}

}