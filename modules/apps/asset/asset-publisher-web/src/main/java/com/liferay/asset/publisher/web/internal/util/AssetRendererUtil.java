/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.publisher.web.internal.util;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Alejandro Tardín
 */
public class AssetRendererUtil {

	public static String getAssetRendererUserFullName(
			AssetRenderer assetRenderer, HttpServletRequest httpServletRequest)
		throws PortalException {

		if (assetRenderer.getUserId() > 0) {
			User assetRendererUser = UserLocalServiceUtil.getUser(
				assetRenderer.getUserId());

			return assetRendererUser.getFullName();
		}

		return LanguageUtil.get(httpServletRequest, "anonymous");
	}

}