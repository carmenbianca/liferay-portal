/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.list.web.internal.servlet.taglib.util;

import com.liferay.asset.list.model.AssetListEntry;
import com.liferay.asset.list.web.internal.security.permission.resource.AssetListEntryPermission;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.taglib.security.PermissionsURLTag;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class AssetEntryListActionDropdownItems {

	public AssetEntryListActionDropdownItems(
		AssetListEntry assetListEntry,
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		_assetListEntry = assetListEntry;
		_liferayPortletResponse = liferayPortletResponse;

		_httpServletRequest = PortalUtil.getHttpServletRequest(
			liferayPortletRequest);
		_themeDisplay = (ThemeDisplay)liferayPortletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
	}

	public List<DropdownItem> getActionDropdownItems() throws Exception {
		return DropdownItemListBuilder.add(
			() -> AssetListEntryPermission.contains(
				_themeDisplay.getPermissionChecker(), _assetListEntry,
				ActionKeys.UPDATE),
			_getEditAssetListEntryActionUnsafeConsumer()
		).add(
			() -> AssetListEntryPermission.contains(
				_themeDisplay.getPermissionChecker(), _assetListEntry,
				ActionKeys.UPDATE),
			_getRenameAssetListEntryActionUnsafeConsumer()
		).add(
			() -> AssetListEntryPermission.contains(
				_themeDisplay.getPermissionChecker(), _assetListEntry,
				ActionKeys.PERMISSIONS),
			_getPermissionsAssetListEntryActionUnsafeConsumer()
		).add(
			_getViewAssetListEntryUsagesActionUnsafeConsumer()
		).add(
			() -> AssetListEntryPermission.contains(
				_themeDisplay.getPermissionChecker(), _assetListEntry,
				ActionKeys.DELETE),
			_getDeleteAssetListEntryActionUnsafeConsumer()
		).build();
	}

	private UnsafeConsumer<DropdownItem, Exception>
		_getDeleteAssetListEntryActionUnsafeConsumer() {

		PortletURL deleteAssetListEntryURL =
			_liferayPortletResponse.createActionURL();

		deleteAssetListEntryURL.setParameter(
			ActionRequest.ACTION_NAME, "/asset_list/delete_asset_list_entry");
		deleteAssetListEntryURL.setParameter(
			"redirect", _themeDisplay.getURLCurrent());
		deleteAssetListEntryURL.setParameter(
			"assetListEntryId",
			String.valueOf(_assetListEntry.getAssetListEntryId()));

		return dropdownItem -> {
			dropdownItem.putData("action", "deleteAssetListEntry");
			dropdownItem.putData(
				"deleteAssetListEntryURL", deleteAssetListEntryURL.toString());
			dropdownItem.setLabel(
				LanguageUtil.get(_httpServletRequest, "delete"));
		};
	}

	private UnsafeConsumer<DropdownItem, Exception>
		_getEditAssetListEntryActionUnsafeConsumer() {

		return dropdownItem -> {
			dropdownItem.setHref(
				_liferayPortletResponse.createRenderURL(), "mvcPath",
				"/edit_asset_list_entry.jsp", "redirect",
				_themeDisplay.getURLCurrent(), "assetListEntryId",
				_assetListEntry.getAssetListEntryId());
			dropdownItem.setLabel(
				LanguageUtil.get(_httpServletRequest, "edit"));
		};
	}

	private UnsafeConsumer<DropdownItem, Exception>
			_getPermissionsAssetListEntryActionUnsafeConsumer()
		throws Exception {

		String permissionsAssetEntryListURL = PermissionsURLTag.doTag(
			StringPool.BLANK, AssetListEntry.class.getName(),
			_assetListEntry.getTitle(), null,
			String.valueOf(_assetListEntry.getAssetListEntryId()),
			LiferayWindowState.POP_UP.toString(), null, _httpServletRequest);

		return dropdownItem -> {
			dropdownItem.putData("action", "permissionsAssetEntryList");
			dropdownItem.putData(
				"permissionsAssetEntryListURL", permissionsAssetEntryListURL);
			dropdownItem.setLabel(
				LanguageUtil.get(_httpServletRequest, "permissions"));
		};
	}

	private UnsafeConsumer<DropdownItem, Exception>
		_getRenameAssetListEntryActionUnsafeConsumer() {

		PortletURL renameAssetListEntryURL =
			_liferayPortletResponse.createActionURL();

		renameAssetListEntryURL.setParameter(
			ActionRequest.ACTION_NAME, "/asset_list/update_asset_list_entry");
		renameAssetListEntryURL.setParameter(
			"assetListEntryId",
			String.valueOf(_assetListEntry.getAssetListEntryId()));

		return dropdownItem -> {
			dropdownItem.putData("action", "renameAssetListEntry");
			dropdownItem.putData(
				"assetListEntryId",
				String.valueOf(_assetListEntry.getAssetListEntryId()));
			dropdownItem.putData(
				"assetListEntryTitle", _assetListEntry.getTitle());
			dropdownItem.putData(
				"renameAssetListEntryURL", renameAssetListEntryURL.toString());
			dropdownItem.setLabel(
				LanguageUtil.get(_httpServletRequest, "rename"));
		};
	}

	private UnsafeConsumer<DropdownItem, Exception>
		_getViewAssetListEntryUsagesActionUnsafeConsumer() {

		return dropdownItem -> {
			dropdownItem.setHref(
				_liferayPortletResponse.createRenderURL(), "mvcPath",
				"/view_asset_list_entry_usages.jsp", "redirect",
				_themeDisplay.getURLCurrent(), "assetListEntryId",
				_assetListEntry.getAssetListEntryId());
			dropdownItem.setLabel(
				LanguageUtil.get(_httpServletRequest, "view-usages"));
		};
	}

	private final AssetListEntry _assetListEntry;
	private final HttpServletRequest _httpServletRequest;
	private final LiferayPortletResponse _liferayPortletResponse;
	private final ThemeDisplay _themeDisplay;

}