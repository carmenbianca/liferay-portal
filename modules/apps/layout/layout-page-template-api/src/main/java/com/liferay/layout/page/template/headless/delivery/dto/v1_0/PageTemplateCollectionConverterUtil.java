/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.headless.delivery.dto.v1_0;

import com.liferay.headless.delivery.dto.v1_0.PageTemplateCollection;
import com.liferay.layout.page.template.model.LayoutPageTemplateCollection;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Jürgen Kappler
 */
public class PageTemplateCollectionConverterUtil {

	public static PageTemplateCollection toPageTemplateCollection(
		LayoutPageTemplateCollection layoutPageTemplateCollection) {

		return new PageTemplateCollection() {
			{
				name = layoutPageTemplateCollection.getName();

				setDescription(
					() -> {
						String description =
							layoutPageTemplateCollection.getDescription();

						if (Validator.isNull(description)) {
							return null;
						}

						return description;
					});
			}
		};
	}

}