/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.item.selector;

import java.util.Collection;

/**
 * @author Alejandro Tardín
 */
public interface ItemSelectorViewRendererCustomizer {

	public ItemSelectorViewRenderer customizeItemSelectorViewRenderer(
		ItemSelectorViewRenderer itemSelectorViewRenderer);

	public Collection<Class<? extends ItemSelectorCriterion>>
		getSupportedItemSelectorCriterionClasses();

}