/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.util.template;

import com.liferay.layout.util.structure.ColumnLayoutStructureItem;
import com.liferay.layout.util.structure.LayoutStructure;
import com.liferay.layout.util.structure.LayoutStructureItem;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Layout;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eudaldo Alonso
 */
public class LayoutData {

	public static LayoutData of(
		Layout layout,
		UnsafeConsumer<LayoutRow, Exception>... unsafeConsumers) {

		return new LayoutData(layout, unsafeConsumers);
	}

	public JSONObject getLayoutDataJSONObject() {
		LayoutStructure layoutStructure = new LayoutStructure();

		LayoutStructureItem rootLayoutStructureItem =
			layoutStructure.addRootLayoutStructureItem();

		int i = 0;

		for (LayoutRow layoutRow : _layoutRows) {
			LayoutStructureItem containerLayoutStructureItem =
				layoutStructure.addContainerLayoutStructureItem(
					rootLayoutStructureItem.getItemId(), i++);

			List<LayoutColumn> layoutColumns = layoutRow.getLayoutColumns();

			LayoutStructureItem rowLayoutStructureItem =
				layoutStructure.addRowLayoutStructureItem(
					containerLayoutStructureItem.getItemId(), 0,
					layoutColumns.size());

			int j = 0;

			for (LayoutColumn layoutColumn : layoutColumns) {
				ColumnLayoutStructureItem columnLayoutStructureItem =
					(ColumnLayoutStructureItem)
						layoutStructure.addColumnLayoutStructureItem(
							rowLayoutStructureItem.getItemId(), j++);

				columnLayoutStructureItem.setSize(layoutColumn.getSize());

				int k = 0;

				for (long fragmentEntryLinkId :
						layoutColumn.getFragmentEntryLinkIds()) {

					layoutStructure.addFragmentLayoutStructureItem(
						fragmentEntryLinkId,
						columnLayoutStructureItem.getItemId(), k++);
				}
			}
		}

		return layoutStructure.toJSONObject();
	}

	private LayoutData(
		Layout layout,
		UnsafeConsumer<LayoutRow, Exception>... unsafeConsumers) {

		for (UnsafeConsumer<LayoutRow, Exception> unsafeConsumer :
				unsafeConsumers) {

			_layoutRows.add(LayoutRow.of(layout, unsafeConsumer));
		}
	}

	private final List<LayoutRow> _layoutRows = new ArrayList<>();

}