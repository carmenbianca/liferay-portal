/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sharing.web.internal.renderer;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.sharing.model.SharingEntry;
import com.liferay.sharing.renderer.SharingEntryViewRenderer;
import com.liferay.sharing.web.internal.util.AssetRendererSharingUtil;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Alejandro Tardín
 */
public class AssetRendererSharingEntryViewRenderer
	implements SharingEntryViewRenderer {

	public AssetRendererSharingEntryViewRenderer(
		ServletContext servletContext) {

		_servletContext = servletContext;
	}

	@Override
	public void render(
			SharingEntry sharingEntry, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws IOException, PortalException {

		try {
			RequestDispatcher requestDispatcher =
				_servletContext.getRequestDispatcher(_JSP_PATH);

			httpServletRequest.setAttribute(
				AssetRenderer.class.getName(),
				AssetRendererSharingUtil.getAssetRenderer(sharingEntry));

			httpServletRequest.setAttribute(
				SharingEntry.class.getName(), sharingEntry);

			requestDispatcher.include(httpServletRequest, httpServletResponse);
		}
		catch (IOException | ServletException exception) {
			_log.error("Unable to include JSP " + _JSP_PATH, exception);

			throw new IOException(
				"Unable to include JSP " + _JSP_PATH, exception);
		}
	}

	private static final String _JSP_PATH =
		"/shared_assets/view_asset_entry_sharing_entry.jsp";

	private static final Log _log = LogFactoryUtil.getLog(
		AssetRendererSharingEntryViewRenderer.class);

	private final ServletContext _servletContext;

}