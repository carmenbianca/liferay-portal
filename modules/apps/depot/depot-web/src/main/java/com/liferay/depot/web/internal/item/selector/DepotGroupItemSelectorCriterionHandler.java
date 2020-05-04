/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.depot.web.internal.item.selector;

import com.liferay.depot.web.internal.item.selector.criteria.depot.group.criterion.DepotGroupItemSelectorCriterion;
import com.liferay.item.selector.BaseItemSelectorCriterionHandler;
import com.liferay.item.selector.ItemSelectorCriterionHandler;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Cristina González
 */
@Component(service = ItemSelectorCriterionHandler.class)
public class DepotGroupItemSelectorCriterionHandler
	extends BaseItemSelectorCriterionHandler<DepotGroupItemSelectorCriterion> {

	@Override
	public Class<DepotGroupItemSelectorCriterion>
		getItemSelectorCriterionClass() {

		return DepotGroupItemSelectorCriterion.class;
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