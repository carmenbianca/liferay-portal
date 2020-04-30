/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.seo.service.impl;

import com.liferay.layout.seo.model.LayoutSEOEntry;
import com.liferay.layout.seo.service.base.LayoutSEOEntryServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.permission.LayoutPermissionUtil;

import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * @author Adolfo Pérez
 */
@Component(
	property = {
		"json.web.service.context.name=layout",
		"json.web.service.context.path=LayoutSEOEntry"
	},
	service = AopService.class
)
public class LayoutSEOEntryServiceImpl extends LayoutSEOEntryServiceBaseImpl {

	@Override
	public LayoutSEOEntry updateLayoutSEOEntry(
			long groupId, boolean privateLayout, long layoutId,
			boolean canonicalURLEnabled, Map<Locale, String> canonicalURLMap,
			boolean openGraphDescriptionEnabled,
			Map<Locale, String> openGraphDescriptionMap,
			Map<Locale, String> openGraphImageAltMap,
			long openGraphImageFileEntryId, boolean openGraphTitleEnabled,
			Map<Locale, String> openGraphTitleMap,
			ServiceContext serviceContext)
		throws PortalException {

		Layout layout = layoutLocalService.getLayout(
			groupId, privateLayout, layoutId);

		LayoutPermissionUtil.check(
			getPermissionChecker(), layout, ActionKeys.UPDATE);

		return layoutSEOEntryLocalService.updateLayoutSEOEntry(
			getUserId(), groupId, privateLayout, layoutId, canonicalURLEnabled,
			canonicalURLMap, openGraphDescriptionEnabled,
			openGraphDescriptionMap, openGraphImageAltMap,
			openGraphImageFileEntryId, openGraphTitleEnabled, openGraphTitleMap,
			serviceContext);
	}

	@Override
	public LayoutSEOEntry updateLayoutSEOEntry(
			long groupId, boolean privateLayout, long layoutId,
			boolean enabledCanonicalURLMap, Map<Locale, String> canonicalURLMap,
			ServiceContext serviceContext)
		throws PortalException {

		Layout layout = layoutLocalService.getLayout(
			groupId, privateLayout, layoutId);

		LayoutPermissionUtil.check(
			getPermissionChecker(), layout, ActionKeys.UPDATE);

		return layoutSEOEntryLocalService.updateLayoutSEOEntry(
			getUserId(), groupId, privateLayout, layoutId,
			enabledCanonicalURLMap, canonicalURLMap, serviceContext);
	}

}