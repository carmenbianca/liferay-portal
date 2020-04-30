/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.item.selector.web.internal;

import com.liferay.item.selector.BaseItemSelectorCriterionHandler;
import com.liferay.item.selector.ItemSelectorCriterionHandler;
import com.liferay.journal.item.selector.criterion.JournalItemSelectorCriterion;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * @author Eduardo García
 */
@Component(service = ItemSelectorCriterionHandler.class)
public class JournalItemSelectorCriterionHandler
	extends BaseItemSelectorCriterionHandler<JournalItemSelectorCriterion> {

	@Override
	public Class<JournalItemSelectorCriterion> getItemSelectorCriterionClass() {
		return JournalItemSelectorCriterion.class;
	}

	@Activate
	@Override
	protected void activate(BundleContext bundleContext) {
		super.activate(bundleContext);
	}

}