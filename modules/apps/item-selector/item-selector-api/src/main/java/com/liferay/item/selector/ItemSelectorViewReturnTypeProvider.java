/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.item.selector;

import java.util.List;

/**
 * @author Roberto Díaz
 */
public interface ItemSelectorViewReturnTypeProvider {

	public List<ItemSelectorReturnType>
		populateSupportedItemSelectorReturnTypes(
			List<ItemSelectorReturnType> supportedItemSelectorReturnTypes);

}