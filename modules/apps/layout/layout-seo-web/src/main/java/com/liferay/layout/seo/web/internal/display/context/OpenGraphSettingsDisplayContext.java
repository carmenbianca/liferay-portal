/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.seo.web.internal.display.context;

import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.document.library.util.DLURLHelper;
import com.liferay.item.selector.ItemSelector;
import com.liferay.item.selector.ItemSelectorCriterion;
import com.liferay.item.selector.criteria.FileEntryItemSelectorReturnType;
import com.liferay.item.selector.criteria.URLItemSelectorReturnType;
import com.liferay.item.selector.criteria.image.criterion.ImageItemSelectorCriterion;
import com.liferay.layout.seo.model.LayoutSEOSite;
import com.liferay.layout.seo.open.graph.OpenGraphConfiguration;
import com.liferay.layout.seo.service.LayoutSEOSiteLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Optional;

import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Adolfo Pérez
 */
public class OpenGraphSettingsDisplayContext {

	public OpenGraphSettingsDisplayContext(
		DLAppService dlAppService, DLURLHelper dlurlHelper,
		HttpServletRequest httpServletRequest, ItemSelector itemSelector,
		LayoutSEOSiteLocalService layoutSEOSiteLocalService,
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		OpenGraphConfiguration openGraphConfiguration) {

		_dlAppService = dlAppService;
		_dlurlHelper = dlurlHelper;
		_httpServletRequest = httpServletRequest;
		_itemSelector = itemSelector;
		_layoutSEOSiteLocalService = layoutSEOSiteLocalService;
		_liferayPortletResponse = liferayPortletResponse;
		_openGraphConfiguration = openGraphConfiguration;

		_themeDisplay = (ThemeDisplay)liferayPortletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
	}

	public String getItemSelectorURL() {
		ItemSelectorCriterion imageItemSelectorCriterion =
			new ImageItemSelectorCriterion();

		imageItemSelectorCriterion.setDesiredItemSelectorReturnTypes(
			new FileEntryItemSelectorReturnType(),
			new URLItemSelectorReturnType());

		PortletURL itemSelectorURL = _itemSelector.getItemSelectorURL(
			RequestBackedPortletURLFactoryUtil.create(_httpServletRequest),
			_liferayPortletResponse.getNamespace() +
				"openGraphImageSelectedItem",
			imageItemSelectorCriterion);

		return itemSelectorURL.toString();
	}

	public LayoutSEOSite getLayoutSEOSite() {
		Group group = _getGroup();

		return _layoutSEOSiteLocalService.fetchLayoutSEOSiteByGroupId(
			group.getGroupId());
	}

	public long getOpenGraphImageFileEntryId() {
		return Optional.ofNullable(
			getLayoutSEOSite()
		).map(
			LayoutSEOSite::getOpenGraphImageFileEntryId
		).orElse(
			0L
		);
	}

	public String getOpenGraphImageTitle() {
		long openGraphImageFileEntryId = getOpenGraphImageFileEntryId();

		if (openGraphImageFileEntryId == 0) {
			return StringPool.BLANK;
		}

		try {
			FileEntry fileEntry = _dlAppService.getFileEntry(
				openGraphImageFileEntryId);

			if (fileEntry.isInTrash()) {
				return StringPool.BLANK;
			}

			return fileEntry.getTitle();
		}
		catch (PortalException portalException) {
			_log.error(portalException, portalException);

			return StringPool.BLANK;
		}
	}

	public String getOpenGraphImageURL() throws Exception {
		long openGraphImageFileEntryId = getOpenGraphImageFileEntryId();

		if (openGraphImageFileEntryId == 0) {
			return StringPool.BLANK;
		}

		try {
			FileEntry fileEntry = _dlAppService.getFileEntry(
				openGraphImageFileEntryId);

			if (fileEntry.isInTrash()) {
				return StringPool.BLANK;
			}

			return _dlurlHelper.getImagePreviewURL(fileEntry, _themeDisplay);
		}
		catch (PortalException portalException) {
			_log.error(portalException, portalException);

			return StringPool.BLANK;
		}
	}

	public boolean isOpenGraphEnabled() throws PortalException {
		return _openGraphConfiguration.isOpenGraphEnabled(_getGroup());
	}

	private Group _getGroup() {
		return Optional.ofNullable(
			(Group)_httpServletRequest.getAttribute("site.liveGroup")
		).orElseGet(
			() -> (Group)_httpServletRequest.getAttribute("site.group")
		);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		OpenGraphSettingsDisplayContext.class);

	private final DLAppService _dlAppService;
	private final DLURLHelper _dlurlHelper;
	private final HttpServletRequest _httpServletRequest;
	private final ItemSelector _itemSelector;
	private final LayoutSEOSiteLocalService _layoutSEOSiteLocalService;
	private final LiferayPortletResponse _liferayPortletResponse;
	private final OpenGraphConfiguration _openGraphConfiguration;
	private final ThemeDisplay _themeDisplay;

}