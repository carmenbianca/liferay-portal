/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.headless.delivery.dto.v1_0;

import com.liferay.headless.delivery.dto.v1_0.MasterPage;
import com.liferay.layout.page.template.model.LayoutPageTemplateEntry;

/**
 * @author Rubén Pulido
 */
public class MasterPageConverterUtil {

	public static MasterPage toMasterPage(
		LayoutPageTemplateEntry layoutPageTemplateEntry) {

		return new MasterPage() {
			{
				name = layoutPageTemplateEntry.getName();
			}
		};
	}

}