/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.item.selector.web.internal;

import com.liferay.item.selector.BaseItemSelectorCriterionHandler;
import com.liferay.item.selector.ItemSelectorCriterion;
import com.liferay.item.selector.ItemSelectorCriterionHandler;
import com.liferay.item.selector.ItemSelectorView;
import com.liferay.layout.item.selector.criterion.LayoutItemSelectorCriterion;
import com.liferay.layout.item.selector.view.LayoutItemSelectorView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Sergio González
 */
@Component(service = ItemSelectorCriterionHandler.class)
public class LayoutItemSelectorCriterionHandler
	extends BaseItemSelectorCriterionHandler<LayoutItemSelectorCriterion> {

	@Override
	public Class<LayoutItemSelectorCriterion> getItemSelectorCriterionClass() {
		return LayoutItemSelectorCriterion.class;
	}

	@Override
	public List<ItemSelectorView<LayoutItemSelectorCriterion>>
		getItemSelectorViews(ItemSelectorCriterion itemSelectorCriterion) {

		List<ItemSelectorView<LayoutItemSelectorCriterion>> itemSelectorViews =
			super.getItemSelectorViews(itemSelectorCriterion);

		List<ItemSelectorView<LayoutItemSelectorCriterion>>
			visibleItemSelectorViews = new ArrayList<>();

		LayoutItemSelectorCriterion layoutItemSelectorCriterion =
			(LayoutItemSelectorCriterion)itemSelectorCriterion;

		Iterator<ItemSelectorView<LayoutItemSelectorCriterion>> iterator =
			itemSelectorViews.iterator();

		while (iterator.hasNext()) {
			ItemSelectorView itemSelectorView = iterator.next();

			if (!(itemSelectorView instanceof LayoutItemSelectorView)) {
				continue;
			}

			LayoutItemSelectorView layoutItemSelectorView =
				(LayoutItemSelectorView)itemSelectorView;

			if ((layoutItemSelectorView.isPrivateLayout() &&
				 !layoutItemSelectorCriterion.isShowPrivatePages()) ||
				(!layoutItemSelectorView.isPrivateLayout() &&
				 !layoutItemSelectorCriterion.isShowPublicPages())) {

				continue;
			}

			visibleItemSelectorViews.add(itemSelectorView);
		}

		return visibleItemSelectorViews;
	}

	@Activate
	@Override
	protected void activate(BundleContext bundleContext) {
		super.activate(bundleContext);
	}

	@Deactivate
	@Override
	protected void deactivate() {
		super.deactivate();
	}

}