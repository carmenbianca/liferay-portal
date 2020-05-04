/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.web.internal.servlet.taglib.util;

import com.liferay.fragment.constants.FragmentActionKeys;
import com.liferay.fragment.web.internal.security.permission.resource.FragmentPermission;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jürgen Kappler
 */
public class FragmentCollectionResourceActionDropdownItemsProvider {

	public FragmentCollectionResourceActionDropdownItemsProvider(
		FileEntry fileEntry, RenderRequest renderRequest,
		RenderResponse renderResponse) {

		_fileEntry = fileEntry;
		_renderResponse = renderResponse;

		_httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);

		_themeDisplay = (ThemeDisplay)_httpServletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
	}

	public List<DropdownItem> getActionDropdownItems() {
		return DropdownItemListBuilder.add(
			() -> FragmentPermission.contains(
				_themeDisplay.getPermissionChecker(),
				_themeDisplay.getScopeGroupId(),
				FragmentActionKeys.MANAGE_FRAGMENT_ENTRIES),
			_getDeleteFragmentCollectionResourceActionUnsafeConsumer()
		).build();
	}

	private UnsafeConsumer<DropdownItem, Exception>
		_getDeleteFragmentCollectionResourceActionUnsafeConsumer() {

		PortletURL deleteFragmentCollectionResourceURL =
			_renderResponse.createActionURL();

		deleteFragmentCollectionResourceURL.setParameter(
			ActionRequest.ACTION_NAME,
			"/fragment/delete_fragment_collection_resources");
		deleteFragmentCollectionResourceURL.setParameter(
			"redirect", _themeDisplay.getURLCurrent());
		deleteFragmentCollectionResourceURL.setParameter(
			"fileEntryId", String.valueOf(_fileEntry.getFileEntryId()));

		return dropdownItem -> {
			dropdownItem.putData("action", "deleteFragmentCollectionResource");
			dropdownItem.putData(
				"deleteFragmentCollectionResourceURL",
				deleteFragmentCollectionResourceURL.toString());
			dropdownItem.setLabel(
				LanguageUtil.get(_httpServletRequest, "delete"));
		};
	}

	private final FileEntry _fileEntry;
	private final HttpServletRequest _httpServletRequest;
	private final RenderResponse _renderResponse;
	private final ThemeDisplay _themeDisplay;

}