/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.tags.navigation.web.internal.portlet.route;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.util.Validator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jürgen Kappler
 */
public class BaseAssetTagsFriendlyURLMapper extends DefaultFriendlyURLMapper {

	@Override
	public String buildPath(LiferayPortletURL liferayPortletURL) {
		Map<String, String> routeParameters = new HashMap<>();

		buildRouteParameters(liferayPortletURL, routeParameters);

		if (routeParameters.get("resetCur") == null) {
			routeParameters.put("resetCur", Boolean.TRUE.toString());
		}

		String friendlyURLPath = router.parametersToUrl(routeParameters);

		if (Validator.isNull(friendlyURLPath)) {
			return null;
		}

		addParametersIncludedInPath(liferayPortletURL, routeParameters);

		return StringPool.SLASH.concat(
			getMapping()
		).concat(
			friendlyURLPath
		);
	}

	@Override
	public String getMapping() {
		return _MAPPING;
	}

	private static final String _MAPPING = "tag";

}