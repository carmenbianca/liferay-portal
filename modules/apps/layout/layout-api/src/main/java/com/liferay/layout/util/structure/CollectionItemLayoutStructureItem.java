/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.util.structure;

import com.liferay.layout.util.constants.LayoutDataItemTypeConstants;
import com.liferay.petra.lang.HashUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

/**
 * @author Víctor Galán
 */
public class CollectionItemLayoutStructureItem extends LayoutStructureItem {

	public CollectionItemLayoutStructureItem(String parentItemId) {
		super(parentItemId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CollectionItemLayoutStructureItem)) {
			return false;
		}

		return super.equals(obj);
	}

	@Override
	public JSONObject getItemConfigJSONObject() {
		return JSONFactoryUtil.createJSONObject();
	}

	@Override
	public String getItemType() {
		return LayoutDataItemTypeConstants.TYPE_COLLECTION_ITEM;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, getItemId());
	}

	@Override
	public void updateItemConfig(JSONObject itemConfigJSONObject) {
	}

}