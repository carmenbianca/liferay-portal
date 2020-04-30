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
public class CreationMenuBuilderCheck extends BaseBuilderCheck {

	protected boolean allowNullValues() {
		return true;
	}

	protected List<BaseBuilderCheck.BuilderInformation>
		getBuilderInformationList() {

		return ListUtil.fromArray(
			new BaseBuilderCheck.BuilderInformation(
				"CreationMenu", "CreationMenuBuilder", "addDropdownItem",
				"addFavoriteDropdownItem", "addPrimaryDropdownItem",
				"addRestDropdownItem"));
	}

	protected boolean isSupportsNestedMethodCalls() {
		return false;
	}

}