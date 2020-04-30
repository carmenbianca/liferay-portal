/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.item.selector.web.internal.servlet.taglib.clay;

import com.liferay.frontend.taglib.clay.servlet.taglib.soy.BaseVerticalCard;
import com.liferay.item.selector.ItemSelectorViewDescriptor;

import javax.portlet.RenderRequest;

/**
 * @author Alejandro Tardín
 */
public class ItemDescriptorVerticalCard extends BaseVerticalCard {

	public ItemDescriptorVerticalCard(
		ItemSelectorViewDescriptor.ItemDescriptor itemDescriptor,
		RenderRequest renderRequest) {

		super(null, renderRequest, null);

		_itemDescriptor = itemDescriptor;
	}

	@Override
	public String getAspectRatioCssClasses() {
		return "aspect-ratio-item-center-middle " +
			"aspect-ratio-item-vertical-fluid";
	}

	@Override
	public String getElementClasses() {
		return "card-interactive card-interactive-secondary";
	}

	@Override
	public String getIcon() {
		return _itemDescriptor.getIcon();
	}

	@Override
	public String getImageSrc() {
		return _itemDescriptor.getImageURL();
	}

	@Override
	public String getSubtitle() {
		return _itemDescriptor.getSubtitle(themeDisplay.getLocale());
	}

	@Override
	public String getTitle() {
		return _itemDescriptor.getTitle(themeDisplay.getLocale());
	}

	private final ItemSelectorViewDescriptor.ItemDescriptor _itemDescriptor;

}