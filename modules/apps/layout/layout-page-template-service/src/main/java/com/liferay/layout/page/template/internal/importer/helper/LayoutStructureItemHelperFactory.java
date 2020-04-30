/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.internal.importer.helper;

import com.liferay.headless.delivery.dto.v1_0.PageElement;

/**
 * @author Jürgen Kappler
 */
public class LayoutStructureItemHelperFactory {

	public static LayoutStructureItemHelperFactory getInstance() {
		return _layoutStructureItemHelperFactory;
	}

	public LayoutStructureItemHelper getLayoutStructureItemHelper(
		PageElement.Type pageElementType) {

		if (pageElementType == PageElement.Type.COLLECTION) {
			return new CollectionLayoutStructureItemHelper();
		}

		if (pageElementType == PageElement.Type.COLLECTION_ITEM) {
			return new CollectionItemLayoutStructureItemHelper();
		}

		if (pageElementType == PageElement.Type.COLUMN) {
			return new ColumnLayoutStructureItemHelper();
		}

		if (pageElementType == PageElement.Type.DROP_ZONE) {
			return new DropZoneLayoutStructureItemHelper();
		}

		if (pageElementType == PageElement.Type.FRAGMENT) {
			return new FragmentLayoutStructureItemHelper();
		}

		if (pageElementType == PageElement.Type.ROW) {
			return new RowLayoutStructureItemHelper();
		}

		if (pageElementType == PageElement.Type.SECTION) {
			return new ContainerLayoutStructureItemHelper();
		}

		if (pageElementType == PageElement.Type.WIDGET) {
			return new WidgetLayoutStructureItemHelper();
		}

		return null;
	}

	private LayoutStructureItemHelperFactory() {
	}

	private static final LayoutStructureItemHelperFactory
		_layoutStructureItemHelperFactory =
			new LayoutStructureItemHelperFactory();

}