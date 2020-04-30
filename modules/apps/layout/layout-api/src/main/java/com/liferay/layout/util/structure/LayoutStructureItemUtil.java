/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.util.structure;

import com.liferay.layout.util.constants.LayoutDataItemTypeConstants;

import java.util.Objects;

/**
 * @author Eudaldo Alonso
 */
public class LayoutStructureItemUtil {

	public static LayoutStructureItem create(
		String itemType, String parentItemId) {

		if (Objects.equals(
				itemType, LayoutDataItemTypeConstants.TYPE_COLLECTION)) {

			return new CollectionLayoutStructureItem(parentItemId);
		}

		if (Objects.equals(
				itemType, LayoutDataItemTypeConstants.TYPE_COLLECTION_ITEM)) {

			return new CollectionItemLayoutStructureItem(parentItemId);
		}

		if (Objects.equals(itemType, LayoutDataItemTypeConstants.TYPE_COLUMN)) {
			return new ColumnLayoutStructureItem(parentItemId);
		}

		if (Objects.equals(
				itemType, LayoutDataItemTypeConstants.TYPE_CONTAINER)) {

			return new ContainerLayoutStructureItem(parentItemId);
		}

		if (Objects.equals(
				itemType, LayoutDataItemTypeConstants.TYPE_DROP_ZONE)) {

			return new DropZoneLayoutStructureItem(parentItemId);
		}

		if (Objects.equals(
				itemType, LayoutDataItemTypeConstants.TYPE_FRAGMENT)) {

			return new FragmentLayoutStructureItem(parentItemId);
		}

		if (Objects.equals(itemType, LayoutDataItemTypeConstants.TYPE_ROOT)) {
			return new RootLayoutStructureItem();
		}

		if (Objects.equals(itemType, LayoutDataItemTypeConstants.TYPE_ROW)) {
			return new RowLayoutStructureItem(parentItemId);
		}

		return null;
	}

}