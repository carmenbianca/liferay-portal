/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.image.gallery.display.kernel.display.context;

import com.liferay.portal.kernel.display.context.DisplayContextFactory;
import com.liferay.portal.kernel.repository.model.FileShortcut;
import com.liferay.portal.kernel.repository.model.FileVersion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Iván Zaera
 */
public interface IGDisplayContextFactory extends DisplayContextFactory {

	public IGViewFileVersionDisplayContext getIGViewFileVersionDisplayContext(
		IGViewFileVersionDisplayContext parentIGViewFileVersionDisplayContext,
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse, FileShortcut fileShortcut);

	public IGViewFileVersionDisplayContext getIGViewFileVersionDisplayContext(
		IGViewFileVersionDisplayContext parentIGViewFileVersionDisplayContext,
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse, FileVersion fileVersion);

}