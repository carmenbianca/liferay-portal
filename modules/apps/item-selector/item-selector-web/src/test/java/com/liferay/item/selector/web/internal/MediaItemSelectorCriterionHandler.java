/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.item.selector.web.internal;

import com.liferay.item.selector.ItemSelectorCriterionHandler;
import com.liferay.item.selector.ItemSelectorView;
import com.liferay.portal.kernel.util.ListUtil;

import java.util.List;

/**
 * @author Iván Zaera
 */
public class MediaItemSelectorCriterionHandler
	implements ItemSelectorCriterionHandler<MediaItemSelectorCriterion> {

	@Override
	public Class<MediaItemSelectorCriterion> getItemSelectorCriterionClass() {
		return MediaItemSelectorCriterion.class;
	}

	@Override
	public List<ItemSelectorView<MediaItemSelectorCriterion>>
		getItemSelectorViews(
			MediaItemSelectorCriterion mediaItemSelectorCriterion) {

		return ListUtil.fromArray(new MediaItemSelectorView());
	}

}