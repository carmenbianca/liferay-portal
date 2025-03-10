/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.layout.page.template.admin.web.internal.headless.delivery.dto.v1_0.structure.importer;

import com.liferay.headless.delivery.dto.v1_0.PageElement;
import com.liferay.layout.util.constants.LayoutDataItemTypeConstants;
import com.liferay.layout.util.structure.LayoutStructure;
import com.liferay.layout.util.structure.LayoutStructureItem;
import com.liferay.layout.util.structure.RowLayoutStructureItem;
import com.liferay.portal.kernel.model.Layout;

import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jürgen Kappler
 */
@Component(service = LayoutStructureItemImporter.class)
public class RowLayoutStructureItemImporter
	extends BaseLayoutStructureItemImporter
	implements LayoutStructureItemImporter {

	@Override
	public LayoutStructureItem addLayoutStructureItem(
			Layout layout, LayoutStructure layoutStructure,
			PageElement pageElement, String parentItemId, int position)
		throws Exception {

		RowLayoutStructureItem rowLayoutStructureItem =
			(RowLayoutStructureItem)layoutStructure.addLayoutStructureItem(
				LayoutDataItemTypeConstants.TYPE_ROW, parentItemId, position);

		Map<String, Object> definitionMap = getDefinitionMap(
			pageElement.getDefinition());

		if (definitionMap != null) {
			rowLayoutStructureItem.setGutters(
				(Boolean)definitionMap.get("gutters"));

			if (definitionMap.containsKey("reverseOrder")) {
				rowLayoutStructureItem.setModulesPerRow(
					(Integer)definitionMap.get("modulesPerRow"));
			}

			rowLayoutStructureItem.setNumberOfColumns(
				(Integer)definitionMap.get("numberOfColumns"));

			if (definitionMap.containsKey("reverseOrder")) {
				rowLayoutStructureItem.setReverseOrder(
					(Boolean)definitionMap.get("reverseOrder"));
			}

			if (definitionMap.containsKey("verticalAlignment")) {
				rowLayoutStructureItem.setVerticalAlignment(
					(String)definitionMap.get("verticalAlignment"));
			}
		}

		return rowLayoutStructureItem;
	}

	@Override
	public PageElement.Type getPageElementType() {
		return PageElement.Type.ROW;
	}

}