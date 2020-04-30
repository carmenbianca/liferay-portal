/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.item.selector;

import java.util.List;

/**
 * @author Alicia García
 */
public interface PortletItemSelectorView<T extends ItemSelectorCriterion>
	extends ItemSelectorView<T> {

	public List<String> getPortletIds();

}