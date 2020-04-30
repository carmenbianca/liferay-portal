/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.item.selector;

/**
 * @author Roberto Díaz
 */
public interface ItemSelectorCriterionSerializer {

	public <T extends ItemSelectorCriterion> T deserialize(
		Class<T> itemSelectorCriterionClass, String json);

	public String serialize(ItemSelectorCriterion itemSelectorCriterion);

}