/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.display.context;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.servlet.taglib.ui.Menu;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mauro Mariuzzo
 */
public class BaseDLViewFileEntryHistoryDisplayContext
	extends BaseDLDisplayContext<DLViewFileEntryHistoryDisplayContext>
	implements DLViewFileEntryHistoryDisplayContext {

	public BaseDLViewFileEntryHistoryDisplayContext(
		UUID uuid,
		DLViewFileEntryHistoryDisplayContext
			parentDLViewFileEntryHistoryDisplayContext,
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse, FileVersion fileVersion) {

		super(
			uuid, parentDLViewFileEntryHistoryDisplayContext,
			httpServletRequest, httpServletResponse);

		this.fileVersion = fileVersion;
	}

	@Override
	public Menu getMenu() throws PortalException {
		return parentDisplayContext.getMenu();
	}

	protected FileVersion fileVersion;

}