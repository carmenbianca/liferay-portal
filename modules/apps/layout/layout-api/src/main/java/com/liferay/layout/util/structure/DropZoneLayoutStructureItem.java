/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.util.structure;

import com.liferay.layout.util.constants.LayoutDataItemTypeConstants;
import com.liferay.petra.lang.HashUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author Eudaldo Alonso
 */
public class DropZoneLayoutStructureItem extends LayoutStructureItem {

	public DropZoneLayoutStructureItem(String parentItemId) {
		super(parentItemId);

		_fragmentEntryKeys = Collections.emptyList();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DropZoneLayoutStructureItem)) {
			return false;
		}

		DropZoneLayoutStructureItem dropZoneLayoutStructureItem =
			(DropZoneLayoutStructureItem)obj;

		if (!Objects.equals(
				_allowNewFragmentEntries,
				dropZoneLayoutStructureItem._allowNewFragmentEntries) ||
			!Objects.equals(
				_fragmentEntryKeys,
				dropZoneLayoutStructureItem._fragmentEntryKeys)) {

			return false;
		}

		return super.equals(obj);
	}

	public List<String> getFragmentEntryKeys() {
		return _fragmentEntryKeys;
	}

	@Override
	public JSONObject getItemConfigJSONObject() {
		return JSONUtil.put(
			"allowNewFragmentEntries", _allowNewFragmentEntries
		).put(
			"fragmentEntryKeys", _fragmentEntryKeys
		);
	}

	@Override
	public String getItemType() {
		return LayoutDataItemTypeConstants.TYPE_DROP_ZONE;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, getItemId());
	}

	public boolean isAllowNewFragmentEntries() {
		return _allowNewFragmentEntries;
	}

	public void setAllowNewFragmentEntries(boolean allowNewFragmentEntries) {
		_allowNewFragmentEntries = allowNewFragmentEntries;
	}

	public void setFragmentEntryKeys(List<String> fragmentEntryKeys) {
		_fragmentEntryKeys = fragmentEntryKeys;
	}

	@Override
	public void updateItemConfig(JSONObject itemConfigJSONObject) {
		if (itemConfigJSONObject.has("allowNewFragmentEntries")) {
			setAllowNewFragmentEntries(
				itemConfigJSONObject.getBoolean("allowNewFragmentEntries"));
		}

		if (itemConfigJSONObject.has("fragmentEntryKeys")) {
			JSONArray fragmentEntryKeysJSONArray =
				itemConfigJSONObject.getJSONArray("fragmentEntryKeys");

			_fragmentEntryKeys = JSONUtil.toStringList(
				fragmentEntryKeysJSONArray);
		}
	}

	private boolean _allowNewFragmentEntries = true;
	private List<String> _fragmentEntryKeys;

}