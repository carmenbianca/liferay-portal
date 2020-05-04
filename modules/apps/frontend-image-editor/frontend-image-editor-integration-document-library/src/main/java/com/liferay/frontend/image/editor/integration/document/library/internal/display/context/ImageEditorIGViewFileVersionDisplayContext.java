/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.image.editor.integration.document.library.internal.display.context;

import com.liferay.document.library.util.DLURLHelper;
import com.liferay.frontend.image.editor.integration.document.library.internal.display.context.logic.ImageEditorDLDisplayContextHelper;
import com.liferay.image.gallery.display.kernel.display.context.BaseIGViewFileVersionDisplayContext;
import com.liferay.image.gallery.display.kernel.display.context.IGViewFileVersionDisplayContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.servlet.taglib.ui.Menu;
import com.liferay.portal.kernel.servlet.taglib.ui.MenuItem;

import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ambrín Chaudhary
 */
public class ImageEditorIGViewFileVersionDisplayContext
	extends BaseIGViewFileVersionDisplayContext {

	public ImageEditorIGViewFileVersionDisplayContext(
		IGViewFileVersionDisplayContext parentIGDisplayContext,
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse, FileVersion fileVersion,
		ResourceBundle resourceBundle, DLURLHelper dlURLHelper) {

		super(
			_UUID, parentIGDisplayContext, httpServletRequest,
			httpServletResponse, fileVersion);

		_resourceBundle = resourceBundle;
		_dlURLHelper = dlURLHelper;

		try {
			FileEntry fileEntry = null;

			if (fileVersion != null) {
				fileEntry = fileVersion.getFileEntry();
			}

			_fileEntry = fileEntry;

			_imageEditorDLDisplayContextHelper =
				new ImageEditorDLDisplayContextHelper(
					fileVersion, httpServletRequest, dlURLHelper);
		}
		catch (PortalException portalException) {
			throw new SystemException(
				"Unable to create image editor image gallery view file " +
					"version display context for file version " + fileVersion,
				portalException);
		}
	}

	@Override
	public Menu getMenu() throws PortalException {
		Menu menu = super.getMenu();

		if (!_imageEditorDLDisplayContextHelper.isShowImageEditorAction()) {
			return menu;
		}

		List<MenuItem> menuItems = menu.getMenuItems();

		ImageEditorDLDisplayContextHelper imageEditorDLDisplayContextHelper =
			new ImageEditorDLDisplayContextHelper(
				fileVersion, request, _dlURLHelper);

		menuItems.add(
			imageEditorDLDisplayContextHelper.
				getJavacriptEditWithImageEditorMenuItem(_resourceBundle));

		return menu;
	}

	private static final UUID _UUID = UUID.fromString(
		"1cc61284-8baf-4904-8a65-b7b3845e64d7");

	private final DLURLHelper _dlURLHelper;
	private final FileEntry _fileEntry;
	private final ImageEditorDLDisplayContextHelper
		_imageEditorDLDisplayContextHelper;
	private final ResourceBundle _resourceBundle;

}