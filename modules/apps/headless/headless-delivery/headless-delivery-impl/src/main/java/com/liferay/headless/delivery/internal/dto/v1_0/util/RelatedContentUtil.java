/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.headless.delivery.internal.dto.v1_0.util;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.asset.kernel.service.AssetLinkLocalService;
import com.liferay.headless.delivery.dto.v1_0.RelatedContent;
import com.liferay.portal.vulcan.dto.converter.DTOConverter;
import com.liferay.portal.vulcan.dto.converter.DTOConverterRegistry;
import com.liferay.portal.vulcan.util.TransformUtil;

import java.util.Locale;

/**
 * @author Javier Gamarra
 */
public class RelatedContentUtil {

	public static RelatedContent[] toRelatedContents(
			AssetEntryLocalService assetEntryLocalService,
			AssetLinkLocalService assetLinkLocalService,
			DTOConverterRegistry dtoConverterRegistry, String className,
			long classPK, Locale locale)
		throws Exception {

		AssetEntry assetEntry = assetEntryLocalService.getEntry(
			className, classPK);

		return TransformUtil.transformToArray(
			assetLinkLocalService.getDirectLinks(assetEntry.getEntryId()),
			assetLink -> _toRelatedContent(
				assetEntryLocalService.getEntry(assetLink.getEntryId2()),
				dtoConverterRegistry, locale),
			RelatedContent.class);
	}

	private static RelatedContent _toRelatedContent(
		AssetEntry assetEntry, DTOConverterRegistry dtoConverterRegistry,
		Locale locale) {

		if (assetEntry == null) {
			return null;
		}

		return new RelatedContent() {
			{
				id = assetEntry.getClassPK();
				title = assetEntry.getTitle(locale);

				setContentType(
					() -> {
						DTOConverter dtoConverter =
							dtoConverterRegistry.getDTOConverter(
								assetEntry.getClassName());

						if (dtoConverter == null) {
							return assetEntry.getClassName();
						}

						return dtoConverter.getContentType();
					});
			}
		};
	}

}