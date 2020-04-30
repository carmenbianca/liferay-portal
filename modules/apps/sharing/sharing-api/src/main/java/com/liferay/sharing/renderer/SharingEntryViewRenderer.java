/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sharing.renderer;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.sharing.model.SharingEntry;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Sergio González
 */
public interface SharingEntryViewRenderer {

	public void render(
			SharingEntry sharingEntry, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws IOException, PortalException;

}