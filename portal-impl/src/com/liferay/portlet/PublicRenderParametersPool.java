/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutSet;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.servlet.PortalSessionContext;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.util.PropsValues;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Michael Young
 */
public class PublicRenderParametersPool {

	public static Map<String, String[]> get(
		HttpServletRequest httpServletRequest, long plid) {

		if (PropsValues.PORTLET_PUBLIC_RENDER_PARAMETER_DISTRIBUTION_LAYOUT) {
			return RenderParametersPool.getOrCreate(
				httpServletRequest, plid, _PUBLIC_RENDER_PARAMETERS);
		}

		HttpSession session = httpServletRequest.getSession();

		HttpSession portalSession = PortalSessionContext.get(session.getId());

		if (portalSession != null) {
			session = portalSession;
		}

		Map<Long, Map<String, String[]>> publicRenderParametersPool =
			(Map<Long, Map<String, String[]>>)session.getAttribute(
				WebKeys.PUBLIC_RENDER_PARAMETERS_POOL);

		if (publicRenderParametersPool == null) {
			publicRenderParametersPool = new ConcurrentHashMap<>();

			session.setAttribute(
				WebKeys.PUBLIC_RENDER_PARAMETERS_POOL,
				publicRenderParametersPool);
		}

		try {
			Layout layout = LayoutLocalServiceUtil.getLayout(plid);

			LayoutSet layoutSet = layout.getLayoutSet();

			return publicRenderParametersPool.computeIfAbsent(
				layoutSet.getLayoutSetId(), key -> new HashMap<>());
		}
		catch (Exception exception) {
			if (_log.isWarnEnabled()) {
				_log.warn(exception, exception);
			}

			return new HashMap<>();
		}
	}

	private static final String _PUBLIC_RENDER_PARAMETERS =
		"PUBLIC_RENDER_PARAMETERS";

	private static final Log _log = LogFactoryUtil.getLog(
		PublicRenderParametersPool.class);

}