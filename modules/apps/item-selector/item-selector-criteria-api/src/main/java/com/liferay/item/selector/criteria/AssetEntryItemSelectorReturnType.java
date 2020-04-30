/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.item.selector.criteria;

import com.liferay.item.selector.ItemSelectorReturnType;

/**
 * This return type should return the following information of a info item as a
 * JSON object:
 *
 * <ul>
 * <li>
 * <code>className</code>: The class name of the selected info item
 * </li>
 * <li>
 * <code>classNameId</code>: The class name ID of the selected info item
 * </li>
 * <li>
 * <code>classPK</code>: The class pk of the selected info item
 * </li>
 * <li>
 * <code>title</code>: The title of the selected info item
 * </li>
 * </ul>
 *
 * @author Adolfo Pérez
 * @review
 */
public class AssetEntryItemSelectorReturnType
	implements ItemSelectorReturnType {
}