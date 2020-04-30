/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.processor;

import com.liferay.fragment.model.FragmentEntryLink;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;

/**
 * @author Lance Ji
 */
public interface FragmentEntryProcessorRegistry {

	public void deleteFragmentEntryLinkData(
		FragmentEntryLink fragmentEntryLink);

	public default JSONArray getAvailableTagsJSONArray() {
		return null;
	}

	public default JSONArray getDataAttributesJSONArray() {
		return null;
	}

	public JSONObject getDefaultEditableValuesJSONObject(
		String html, String configuration);

	public default String processFragmentEntryLinkCSS(
			FragmentEntryLink fragmentEntryLink,
			FragmentEntryProcessorContext fragmentEntryProcessorContext)
		throws PortalException {

		return fragmentEntryLink.getCss();
	}

	public default String processFragmentEntryLinkHTML(
			FragmentEntryLink fragmentEntryLink,
			FragmentEntryProcessorContext fragmentEntryProcessorContext)
		throws PortalException {

		return fragmentEntryLink.getHtml();
	}

	public void validateFragmentEntryHTML(String html, String configuration)
		throws PortalException;

}