/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.item.selector.criteria.info.item.criterion;

import com.liferay.info.item.selector.InfoItemSelectorView;
import com.liferay.item.selector.ItemSelectorCriterion;
import com.liferay.item.selector.ItemSelectorView;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Jürgen Kappler
 */
public class InfoItemItemSelectorCriterionHandlerUtil {

	public static List<ItemSelectorView<InfoItemItemSelectorCriterion>>
		getFilteredItemSelectorViews(
			ItemSelectorCriterion itemSelectorCriterion,
			List<ItemSelectorView<InfoItemItemSelectorCriterion>>
				itemSelectorViews) {

		InfoItemItemSelectorCriterion infoItemItemSelectorCriterion =
			(InfoItemItemSelectorCriterion)itemSelectorCriterion;

		if (Validator.isNull(infoItemItemSelectorCriterion.getItemType())) {
			return itemSelectorViews;
		}

		Stream<ItemSelectorView<InfoItemItemSelectorCriterion>> stream =
			itemSelectorViews.stream();

		return stream.filter(
			itemSelectorView -> {
				if (!(itemSelectorView instanceof InfoItemSelectorView)) {
					return false;
				}

				InfoItemSelectorView infoItemSelectorView =
					(InfoItemSelectorView)itemSelectorView;

				return Objects.equals(
					infoItemSelectorView.getClassName(),
					infoItemItemSelectorCriterion.getItemType());
			}
		).collect(
			Collectors.toList()
		);
	}

}