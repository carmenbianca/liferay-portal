/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet;

import com.liferay.petra.string.CharPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.LayoutFriendlyURLComposite;
import com.liferay.portal.kernel.model.LayoutQueryStringComposite;
import com.liferay.portal.kernel.model.VirtualLayoutConstants;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Map;

/**
 * @author Eduardo García
 * @author Marco Leo
 */
@OSGiBeanProperties(service = FriendlyURLResolver.class)
public class VirtualLayoutFriendlyURLResolver implements FriendlyURLResolver {

	@Override
	public String getActualURL(
			long companyId, long groupId, boolean privateLayout,
			String mainPath, String friendlyURL, Map<String, String[]> params,
			Map<String, Object> requestContext)
		throws PortalException {

		// Group friendly URL

		String groupFriendlyURL = null;

		int pos = friendlyURL.indexOf(CharPool.SLASH, 3);

		if (pos != -1) {
			groupFriendlyURL = friendlyURL.substring(2, pos);
		}

		if (Validator.isNull(groupFriendlyURL)) {
			return mainPath;
		}

		Group group = GroupLocalServiceUtil.fetchFriendlyURLGroup(
			companyId, groupFriendlyURL);

		if (group == null) {
			return mainPath;
		}

		// Layout friendly URL

		String layoutFriendlyURL = null;

		if ((pos != -1) && ((pos + 1) != friendlyURL.length())) {
			layoutFriendlyURL = friendlyURL.substring(pos);
		}

		if (Validator.isNull(layoutFriendlyURL)) {
			return mainPath;
		}

		String actualURL = PortalUtil.getActualURL(
			group.getGroupId(), privateLayout, mainPath, layoutFriendlyURL,
			params, requestContext);

		return HttpUtil.addParameter(
			HttpUtil.removeParameter(actualURL, "p_v_l_s_g_id"), "p_v_l_s_g_id",
			groupId);
	}

	@Override
	public LayoutFriendlyURLComposite getLayoutFriendlyURLComposite(
			long companyId, long groupId, boolean privateLayout,
			String friendlyURL, Map<String, String[]> params,
			Map<String, Object> requestContext)
		throws PortalException {

		// Group friendly URL

		String groupFriendlyURL = null;

		int pos = friendlyURL.indexOf(CharPool.SLASH, 3);

		if (pos != -1) {
			groupFriendlyURL = friendlyURL.substring(2, pos);
		}

		Group group = GroupLocalServiceUtil.fetchFriendlyURLGroup(
			companyId, groupFriendlyURL);

		// Layout friendly URL

		String layoutFriendlyURL = null;

		if ((pos != -1) && ((pos + 1) != friendlyURL.length())) {
			layoutFriendlyURL = friendlyURL.substring(pos);
		}

		LayoutQueryStringComposite layoutQueryStringComposite =
			PortalUtil.getActualLayoutQueryStringComposite(
				group.getGroupId(), privateLayout, layoutFriendlyURL, params,
				requestContext);

		return new LayoutFriendlyURLComposite(
			layoutQueryStringComposite.getLayout(), layoutFriendlyURL);
	}

	@Override
	public LayoutFriendlyURLSeparatorComposite
			getLayoutFriendlyURLSeparatorComposite(
				long companyId, long groupId, boolean privateLayout,
				String friendlyURL, Map<String, String[]> params,
				Map<String, Object> requestContext)
		throws PortalException {

		LayoutFriendlyURLComposite layoutFriendlyURLComposite =
			getLayoutFriendlyURLComposite(
				companyId, groupId, privateLayout, friendlyURL, params,
				requestContext);

		return new LayoutFriendlyURLSeparatorComposite(
			layoutFriendlyURLComposite, Portal.FRIENDLY_URL_SEPARATOR);
	}

	@Override
	public String getURLSeparator() {
		return VirtualLayoutConstants.CANONICAL_URL_SEPARATOR;
	}

}