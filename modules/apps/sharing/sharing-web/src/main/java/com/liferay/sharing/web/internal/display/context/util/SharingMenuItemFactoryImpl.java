/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sharing.web.internal.display.context.util;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.servlet.taglib.ui.JavaScriptMenuItem;
import com.liferay.portal.kernel.servlet.taglib.ui.JavaScriptToolbarItem;
import com.liferay.portal.kernel.servlet.taglib.ui.MenuItem;
import com.liferay.portal.kernel.servlet.taglib.ui.ToolbarItem;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.sharing.display.context.util.SharingDropdownItemFactory;
import com.liferay.sharing.display.context.util.SharingJavaScriptFactory;
import com.liferay.sharing.display.context.util.SharingMenuItemFactory;
import com.liferay.sharing.display.context.util.SharingToolbarItemFactory;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Adolfo Pérez
 */
@Component(
	immediate = true,
	service = {
		SharingDropdownItemFactory.class, SharingMenuItemFactory.class,
		SharingToolbarItemFactory.class
	}
)
public class SharingMenuItemFactoryImpl
	implements SharingDropdownItemFactory, SharingMenuItemFactory,
			   SharingToolbarItemFactory {

	@Override
	public DropdownItem createManageCollaboratorsDropdownItem(
			String className, long classPK,
			HttpServletRequest httpServletRequest)
		throws PortalException {

		DropdownItem dropdownItem = new DropdownItem();

		String manageCollaboratorsOnClickMethod =
			_sharingJavaScriptFactory.createManageCollaboratorsOnClickMethod(
				className, classPK, httpServletRequest);

		dropdownItem.setHref("javascript:" + manageCollaboratorsOnClickMethod);

		dropdownItem.setLabel(_getManageCollaboratorsLabel(httpServletRequest));

		return dropdownItem;
	}

	@Override
	public MenuItem createManageCollaboratorsMenuItem(
			String className, long classPK,
			HttpServletRequest httpServletRequest)
		throws PortalException {

		JavaScriptMenuItem javaScriptMenuItem = new JavaScriptMenuItem();

		javaScriptMenuItem.setKey("#manage-collaborators");
		javaScriptMenuItem.setLabel(
			_getManageCollaboratorsLabel(httpServletRequest));
		javaScriptMenuItem.setOnClick(
			_sharingJavaScriptFactory.createManageCollaboratorsOnClickMethod(
				className, classPK, httpServletRequest));

		return javaScriptMenuItem;
	}

	@Override
	public ToolbarItem createManageCollaboratorsToolbarItem(
			String className, long classPK,
			HttpServletRequest httpServletRequest)
		throws PortalException {

		JavaScriptToolbarItem javaScriptToolbarItem =
			new JavaScriptToolbarItem();

		javaScriptToolbarItem.setKey("#manage-collaborators");
		javaScriptToolbarItem.setLabel(
			_getManageCollaboratorsLabel(httpServletRequest));
		javaScriptToolbarItem.setOnClick(
			_sharingJavaScriptFactory.createManageCollaboratorsOnClickMethod(
				className, classPK, httpServletRequest));

		return javaScriptToolbarItem;
	}

	@Override
	public DropdownItem createShareDropdownItem(
			String className, long classPK,
			HttpServletRequest httpServletRequest)
		throws PortalException {

		DropdownItem dropdownItem = new DropdownItem();

		String sharingOnClickMethod =
			_sharingJavaScriptFactory.createSharingOnClickMethod(
				className, classPK, httpServletRequest);

		dropdownItem.setHref("javascript:" + sharingOnClickMethod);

		dropdownItem.setLabel(_getSharingLabel(httpServletRequest));

		return dropdownItem;
	}

	@Override
	public MenuItem createShareMenuItem(
			String className, long classPK,
			HttpServletRequest httpServletRequest)
		throws PortalException {

		JavaScriptMenuItem javaScriptMenuItem = new JavaScriptMenuItem();

		javaScriptMenuItem.setKey("#share");
		javaScriptMenuItem.setLabel(_getSharingLabel(httpServletRequest));
		javaScriptMenuItem.setOnClick(
			_sharingJavaScriptFactory.createSharingOnClickMethod(
				className, classPK, httpServletRequest));

		return javaScriptMenuItem;
	}

	@Override
	public ToolbarItem createShareToolbarItem(
			String className, long classPK,
			HttpServletRequest httpServletRequest)
		throws PortalException {

		JavaScriptToolbarItem javaScriptToolbarItem =
			new JavaScriptToolbarItem();

		javaScriptToolbarItem.setKey("#share");
		javaScriptToolbarItem.setLabel(_getSharingLabel(httpServletRequest));
		javaScriptToolbarItem.setOnClick(
			_sharingJavaScriptFactory.createSharingOnClickMethod(
				className, classPK, httpServletRequest));

		return javaScriptToolbarItem;
	}

	private String _getLabel(
		String key, HttpServletRequest httpServletRequest) {

		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			_portal.getLocale(httpServletRequest),
			SharingJavaScriptFactoryImpl.class);

		return _language.get(resourceBundle, key);
	}

	private String _getManageCollaboratorsLabel(
		HttpServletRequest httpServletRequest) {

		return _getLabel("manage-collaborators", httpServletRequest);
	}

	private String _getSharingLabel(HttpServletRequest httpServletRequest) {
		return _getLabel("share", httpServletRequest);
	}

	@Reference
	private Language _language;

	@Reference
	private Portal _portal;

	@Reference
	private SharingJavaScriptFactory _sharingJavaScriptFactory;

}