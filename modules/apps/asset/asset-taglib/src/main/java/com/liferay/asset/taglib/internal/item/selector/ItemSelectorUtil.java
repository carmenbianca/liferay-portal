/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.taglib.internal.item.selector;

import com.liferay.item.selector.ItemSelector;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 */
@Component(immediate = true, service = {})
public class ItemSelectorUtil {

	public static final ItemSelector getItemSelector() {
		return _itemSelectorUtil._getItemSelector();
	}

	@Activate
	protected void activate() {
		_itemSelectorUtil = this;
	}

	@Deactivate
	protected void deactivate() {
		_itemSelectorUtil = null;
	}

	private ItemSelector _getItemSelector() {
		return _itemSelector;
	}

	private static ItemSelectorUtil _itemSelectorUtil;

	@Reference
	private ItemSelector _itemSelector;

}