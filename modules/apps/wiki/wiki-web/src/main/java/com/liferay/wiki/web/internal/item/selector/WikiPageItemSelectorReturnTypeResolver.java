/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.web.internal.item.selector;

import com.liferay.item.selector.ItemSelectorReturnType;
import com.liferay.item.selector.ItemSelectorReturnTypeResolver;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.wiki.model.WikiPage;

/**
 * @author Roberto Díaz
 */
public interface WikiPageItemSelectorReturnTypeResolver
	<T extends ItemSelectorReturnType, S>
		extends ItemSelectorReturnTypeResolver<T, WikiPage> {

	public String getTitle(WikiPage page, ThemeDisplay themeDisplay)
		throws Exception;

}