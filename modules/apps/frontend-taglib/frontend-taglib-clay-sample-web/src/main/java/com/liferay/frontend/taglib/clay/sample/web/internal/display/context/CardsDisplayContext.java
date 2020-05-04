/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.clay.sample.web.internal.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.LabelItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.LabelItemListBuilder;
import com.liferay.portal.kernel.security.RandomUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;

import java.util.List;
import java.util.Map;

/**
 * @author Julien Castelain
 */
public class CardsDisplayContext {

	public List<DropdownItem> getActionDropdownItems() {
		if (_actionDropdownItems != null) {
			return _actionDropdownItems;
		}

		_actionDropdownItems = DropdownItemListBuilder.add(
			dropdownItem -> {
				dropdownItem.setHref("#1");
				dropdownItem.setLabel("Edit");
				dropdownItem.setSeparator(true);
			}
		).add(
			dropdownItem -> {
				dropdownItem.setHref("#2");
				dropdownItem.setLabel("Save");
			}
		).build();

		return _actionDropdownItems;
	}

	public List<LabelItem> getLabelItems() {
		int numItems = 1 + RandomUtil.nextInt(3);

		return LabelItemListBuilder.add(
			labelItem -> {
				labelItem.setLabel("Approved");
				labelItem.setStyle("success");
			}
		).add(
			() -> numItems > 1, labelItem -> labelItem.setLabel("Pending")
		).add(
			() -> numItems > 2,
			labelItem -> {
				labelItem.setLabel("Canceled");
				labelItem.setStyle("danger");
			}
		).build();
	}

	public Map<String, String> getLabelStylesMap() {
		if (_labelStylesMap != null) {
			return _labelStylesMap;
		}

		_labelStylesMap = HashMapBuilder.put(
			"Pending", "warning"
		).build();

		return _labelStylesMap;
	}

	private List<DropdownItem> _actionDropdownItems;
	private Map<String, String> _labelStylesMap;

}