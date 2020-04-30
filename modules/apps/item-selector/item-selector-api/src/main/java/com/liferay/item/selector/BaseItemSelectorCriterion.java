/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.item.selector;

import com.liferay.portal.kernel.util.ListUtil;

import java.util.List;

/**
 * @author Iván Zaera
 */
public abstract class BaseItemSelectorCriterion
	implements ItemSelectorCriterion {

	@Override
	public List<ItemSelectorReturnType> getDesiredItemSelectorReturnTypes() {
		return _desiredItemSelectorReturnTypes;
	}

	@Override
	public void setDesiredItemSelectorReturnTypes(
		ItemSelectorReturnType... desiredItemSelectorReturnType) {

		_desiredItemSelectorReturnTypes = ListUtil.fromArray(
			desiredItemSelectorReturnType);
	}

	@Override
	public void setDesiredItemSelectorReturnTypes(
		List<ItemSelectorReturnType> desiredItemSelectorReturnTypes) {

		_desiredItemSelectorReturnTypes = desiredItemSelectorReturnTypes;
	}

	private List<ItemSelectorReturnType> _desiredItemSelectorReturnTypes;

}