/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.util.structure;

import com.liferay.layout.util.constants.LayoutDataItemTypeConstants;
import com.liferay.petra.lang.HashUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;

import java.util.Objects;

/**
 * @author Eudaldo Alonso
 */
public class FragmentLayoutStructureItem extends LayoutStructureItem {

	public FragmentLayoutStructureItem(String parentItemId) {
		super(parentItemId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FragmentLayoutStructureItem)) {
			return false;
		}

		FragmentLayoutStructureItem fragmentLayoutStructureItem =
			(FragmentLayoutStructureItem)obj;

		if (!Objects.equals(
				_fragmentEntryLinkId,
				fragmentLayoutStructureItem._fragmentEntryLinkId)) {

			return false;
		}

		return super.equals(obj);
	}

	public long getFragmentEntryLinkId() {
		return _fragmentEntryLinkId;
	}

	@Override
	public JSONObject getItemConfigJSONObject() {
		return JSONUtil.put(
			"fragmentEntryLinkId", String.valueOf(_fragmentEntryLinkId));
	}

	@Override
	public String getItemType() {
		return LayoutDataItemTypeConstants.TYPE_FRAGMENT;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, getItemId());
	}

	public void setFragmentEntryLinkId(long fragmentEntryLinkId) {
		_fragmentEntryLinkId = fragmentEntryLinkId;
	}

	@Override
	public void updateItemConfig(JSONObject itemConfigJSONObject) {
		if (itemConfigJSONObject.has("fragmentEntryLinkId")) {
			setFragmentEntryLinkId(
				itemConfigJSONObject.getLong("fragmentEntryLinkId"));
		}
	}

	private long _fragmentEntryLinkId;

}