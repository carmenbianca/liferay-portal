/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.uad.display;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.user.associated.data.display.UADDisplay;
import com.liferay.user.associated.data.display.UADHierarchyDeclaration;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pei-Jung Lan
 */
@Component(service = UADHierarchyDeclaration.class)
public class DLUADHierarchyDeclaration implements UADHierarchyDeclaration {

	@Override
	public UADDisplay<?>[] getContainerUADDisplays() {
		return new UADDisplay<?>[] {_dlFolderUADDisplay};
	}

	@Override
	public String getEntitiesTypeLabel(Locale locale) {
		return LanguageUtil.get(
			ResourceBundleUtil.getBundle(
				locale, DLUADHierarchyDeclaration.class),
			"folders-and-files");
	}

	@Override
	public String[] getExtraColumnNames() {
		return new String[] {"description"};
	}

	@Override
	public UADDisplay<?>[] getNoncontainerUADDisplays() {
		return new UADDisplay<?>[] {_dlFileEntryUADDisplay};
	}

	@Reference
	private DLFileEntryUADDisplay _dlFileEntryUADDisplay;

	@Reference
	private DLFolderUADDisplay _dlFolderUADDisplay;

}