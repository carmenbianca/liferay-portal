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
 * @author Pavel Savinov
 */
public interface FragmentEntryProcessor {

	public default void deleteFragmentEntryLinkData(
		FragmentEntryLink fragmentEntryLink) {
	}

	public default JSONArray getAvailableTagsJSONArray() {
		return null;
	}

	public default JSONArray getDataAttributesJSONArray() {
		return null;
	}

	public default JSONObject getDefaultEditableValuesJSONObject(
		String html, String configuration) {

		return null;
	}

	public default String processFragmentEntryLinkCSS(
			FragmentEntryLink fragmentEntryLink, String css,
			FragmentEntryProcessorContext fragmentEntryProcessorContext)
		throws PortalException {

		return css;
	}

	public default String processFragmentEntryLinkHTML(
			FragmentEntryLink fragmentEntryLink, String html,
			FragmentEntryProcessorContext fragmentEntryProcessorContext)
		throws PortalException {

		return html;
	}

	public void validateFragmentEntryHTML(String html, String configuration)
		throws PortalException;

}