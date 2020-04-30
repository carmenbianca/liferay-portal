/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.admin.web.internal.servlet.taglib.clay;

import com.liferay.frontend.taglib.clay.servlet.taglib.soy.VerticalCard;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.site.admin.web.internal.constants.SiteAdminConstants;
import com.liferay.site.admin.web.internal.util.SiteInitializerItem;

import java.util.Map;
import java.util.Objects;

import javax.portlet.ActionRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class SelectSiteInitializerVerticalCard implements VerticalCard {

	public SelectSiteInitializerVerticalCard(
		SiteInitializerItem siteInitializerItem, RenderRequest renderRequest,
		RenderResponse renderResponse) {

		_siteInitializerItem = siteInitializerItem;
		_renderResponse = renderResponse;

		_httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
	}

	@Override
	public Map<String, String> getData() {
		return HashMapBuilder.put(
			"add-site-url",
			() -> {
				PortletURL addSiteURL = _renderResponse.createActionURL();

				addSiteURL.setParameter(ActionRequest.ACTION_NAME, "addGroup");

				addSiteURL.setParameter(
					"mvcPath", "/select_layout_set_prototype_entry.jsp");

				long parentGroupId = ParamUtil.getLong(
					_httpServletRequest, "parentGroupId");

				addSiteURL.setParameter(
					"parentGroupId", String.valueOf(parentGroupId));

				addSiteURL.setParameter(
					"creationType", _siteInitializerItem.getType());
				addSiteURL.setParameter(
					"siteInitializerKey",
					_siteInitializerItem.getSiteInitializerKey());

				return addSiteURL.toString();
			}
		).put(
			"checkbox-field-name",
			() -> {
				if (Objects.equals(
						_siteInitializerItem.getType(),
						SiteAdminConstants.CREATION_TYPE_SITE_TEMPLATE)) {

					return "layoutSetVisibilityPrivate";
				}

				return StringPool.BLANK;
			}
		).put(
			"layout-set-prototype-id",
			String.valueOf(_siteInitializerItem.getLayoutSetPrototypeId())
		).build();
	}

	@Override
	public String getElementClasses() {
		return "add-site-action-option card-interactive " +
			"card-interactive-secondary";
	}

	@Override
	public String getIcon() {
		return "site-template";
	}

	@Override
	public String getImageSrc() {
		if (_siteInitializerItem.isCreationTypeSiteTemplate()) {
			return null;
		}

		if (Validator.isNull(_siteInitializerItem.getIcon())) {
			return null;
		}

		return _siteInitializerItem.getIcon();
	}

	@Override
	public String getTitle() {
		return _siteInitializerItem.getName();
	}

	@Override
	public boolean isSelectable() {
		return false;
	}

	private final HttpServletRequest _httpServletRequest;
	private final RenderResponse _renderResponse;
	private final SiteInitializerItem _siteInitializerItem;

}