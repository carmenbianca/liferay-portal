/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checkstyle.checks;

import com.liferay.portal.kernel.util.ListUtil;

import java.util.List;

/**
 * @author Hugo Huijser
 */
public class ItemListBuilderCheck extends BaseBuilderCheck {

	protected boolean allowNullValues() {
		return true;
	}

	protected List<BaseBuilderCheck.BuilderInformation>
		getBuilderInformationList() {

		return ListUtil.fromArray(
			new BaseBuilderCheck.BuilderInformation(
				"DropdownItemList", "DropdownItemListBuilder", "add",
				"addCheckbox", "addGroup", "addRadio", "addRadioGroup"),
			new BaseBuilderCheck.BuilderInformation(
				"LabelItemList", "LabelItemListBuilder", "add"),
			new BaseBuilderCheck.BuilderInformation(
				"NavigationItemList", "NavigationItemListBuilder", "add"));
	}

	protected boolean isSupportsNestedMethodCalls() {
		return false;
	}

}