/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.util;

import com.liferay.fragment.model.FragmentEntryLink;
import com.liferay.layout.page.template.constants.LayoutPageTemplateEntryTypeConstants;
import com.liferay.layout.util.structure.LayoutStructure;
import com.liferay.layout.util.structure.LayoutStructureItem;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.List;

/**
 * @author Jürgen
 */
public class LayoutPageTemplateStructureHelperUtil {

	public static JSONObject generateContentLayoutStructure(
		List<FragmentEntryLink> fragmentEntryLinks) {

		return generateContentLayoutStructure(
			fragmentEntryLinks,
			LayoutPageTemplateEntryTypeConstants.TYPE_BASIC);
	}

	public static JSONObject generateContentLayoutStructure(
		List<FragmentEntryLink> fragmentEntryLinks, int type) {

		if (fragmentEntryLinks.isEmpty() &&
			(type == LayoutPageTemplateEntryTypeConstants.TYPE_MASTER_LAYOUT)) {

			LayoutStructure layoutStructure = new LayoutStructure();

			LayoutStructureItem rootLayoutStructureItem =
				layoutStructure.addRootLayoutStructureItem();

			layoutStructure.addDropZoneLayoutStructureItem(
				rootLayoutStructureItem.getItemId(), 0);

			return layoutStructure.toJSONObject();
		}

		if (fragmentEntryLinks.isEmpty()) {
			LayoutStructure layoutStructure = new LayoutStructure();

			layoutStructure.addRootLayoutStructureItem();

			return layoutStructure.toJSONObject();
		}

		LayoutStructure layoutStructure = new LayoutStructure();

		LayoutStructureItem rootLayoutStructureItem =
			layoutStructure.addRootLayoutStructureItem();

		LayoutStructureItem containerLayoutStructureItem =
			layoutStructure.addContainerLayoutStructureItem(
				rootLayoutStructureItem.getItemId(), 0);

		for (int i = 0; i < fragmentEntryLinks.size(); i++) {
			FragmentEntryLink fragmentEntryLink = fragmentEntryLinks.get(i);

			layoutStructure.addFragmentLayoutStructureItem(
				fragmentEntryLink.getFragmentEntryLinkId(),
				containerLayoutStructureItem.getItemId(), i);
		}

		return layoutStructure.toJSONObject();
	}

}