/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.headless.delivery.internal.dto.v1_0.util;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.headless.delivery.dto.v1_0.TaxonomyCategoryBrief;
import com.liferay.portal.vulcan.util.LocalizedMapUtil;

import java.util.Locale;

/**
 * @author Javier Gamarra
 */
public class TaxonomyCategoryBriefUtil {

	public static TaxonomyCategoryBrief toTaxonomyCategoryBrief(
		boolean acceptAllLanguages, AssetCategory assetCategory,
		Locale locale) {

		return new TaxonomyCategoryBrief() {
			{
				taxonomyCategoryId = assetCategory.getCategoryId();
				taxonomyCategoryName = assetCategory.getTitle(locale);
				taxonomyCategoryName_i18n = LocalizedMapUtil.getI18nMap(
					acceptAllLanguages, assetCategory.getTitleMap());
			}
		};
	}

}