/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.clay.servlet.taglib.soy;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.LabelItem;

import java.util.List;
import java.util.Map;

/**
 * @author Eudaldo Alonso
 */
public interface VerticalCard extends BaseClayCard {

	public default String getIcon() {
		return null;
	}

	public default String getImageAlt() {
		return null;
	}

	public default String getImageSrc() {
		return null;
	}

	public default List<LabelItem> getLabels() {
		return null;
	}

	public default Map<String, String> getLabelStylesMap() {
		return null;
	}

	public default String getStickerCssClass() {
		return null;
	}

	public default String getStickerIcon() {
		return null;
	}

	public default String getStickerImageAlt() {
		return null;
	}

	public default String getStickerImageSrc() {
		return null;
	}

	/**
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	public default String getStickerLabel() {
		return null;
	}

	public default String getStickerShape() {
		return null;
	}

	public default String getStickerStyle() {
		return null;
	}

	public default String getSubtitle() {
		return null;
	}

	public String getTitle();

}