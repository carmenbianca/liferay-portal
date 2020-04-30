/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.headless.delivery.dto.v1_0;

import com.liferay.asset.kernel.AssetRendererFactoryRegistryUtil;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.ClassType;
import com.liferay.asset.kernel.model.ClassTypeReader;
import com.liferay.headless.delivery.dto.v1_0.DisplayPageTemplate;
import com.liferay.layout.page.template.model.LayoutPageTemplateEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;

/**
 * @author Rubén Pulido
 */
public class DisplayPageTemplateConverterUtil {

	public static DisplayPageTemplate toDisplayPageTemplate(
		LayoutPageTemplateEntry layoutPageTemplateEntry) {

		return new DisplayPageTemplate() {
			{
				contentSubtypeName = _getClassTypeName(layoutPageTemplateEntry);
				contentTypeClassName = layoutPageTemplateEntry.getClassName();
				name = layoutPageTemplateEntry.getName();
			}
		};
	}

	private static String _getClassTypeName(
		LayoutPageTemplateEntry layoutPageTemplateEntry) {

		AssetRendererFactory assetRendererFactory =
			AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(
				layoutPageTemplateEntry.getClassName());

		if ((assetRendererFactory == null) ||
			!assetRendererFactory.isSupportsClassTypes()) {

			return null;
		}

		ClassTypeReader classTypeReader =
			assetRendererFactory.getClassTypeReader();

		ClassType classType = null;

		try {
			classType = classTypeReader.getClassType(
				layoutPageTemplateEntry.getClassTypeId(),
				LocaleUtil.getSiteDefault());
		}
		catch (PortalException portalException) {
			if (_log.isWarnEnabled()) {
				_log.warn("Unable to get class type", portalException);
			}
		}

		if (classType == null) {
			return null;
		}

		return classType.getName();
	}

	private static final Log _log = LogFactoryUtil.getLog(
		DisplayPageTemplateConverterUtil.class);

}