/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.admin.web.internal.asset.model;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.layout.admin.constants.LayoutAdminPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Portal;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo García
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + LayoutAdminPortletKeys.GROUP_PAGES,
	service = AssetRendererFactory.class
)
public class LayoutAssetRendererFactory
	extends BaseAssetRendererFactory<Layout> {

	public static final String TYPE = "layout";

	public LayoutAssetRendererFactory() {
		setClassName(Layout.class.getName());
		setSelectable(false);
		setPortletId(LayoutAdminPortletKeys.GROUP_PAGES);
	}

	@Override
	public AssetEntry getAssetEntry(long assetEntryId) throws PortalException {
		return getAssetEntry(getClassName(), assetEntryId);
	}

	@Override
	public AssetEntry getAssetEntry(String className, long classPK)
		throws PortalException {

		Layout layout = _layoutLocalService.getLayout(classPK);

		User user = _userLocalService.getUserById(layout.getUserId());

		AssetEntry assetEntry = _assetEntryLocalService.createAssetEntry(
			classPK);

		assetEntry.setGroupId(layout.getGroupId());
		assetEntry.setCompanyId(user.getCompanyId());
		assetEntry.setUserId(user.getUserId());
		assetEntry.setUserName(user.getFullName());
		assetEntry.setCreateDate(layout.getCreateDate());
		assetEntry.setClassNameId(
			_portal.getClassNameId(Layout.class.getName()));
		assetEntry.setClassPK(layout.getLayoutId());
		assetEntry.setTitle(layout.getHTMLTitle(LocaleUtil.getSiteDefault()));

		return assetEntry;
	}

	@Override
	public AssetRenderer<Layout> getAssetRenderer(long plid, int type)
		throws PortalException {

		LayoutAssetRenderer layoutAssetRenderer = new LayoutAssetRenderer(
			_layoutLocalService.getLayout(plid));

		layoutAssetRenderer.setAssetRendererType(type);
		layoutAssetRenderer.setServletContext(_servletContext);

		return layoutAssetRenderer;
	}

	@Override
	public String getClassName() {
		return Layout.class.getName();
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public boolean isSearchable() {
		return true;
	}

	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.layout.admin.web)",
		unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	@Reference(unbind = "-")
	protected void setAssetEntryLocalService(
		AssetEntryLocalService assetEntryLocalService) {

		_assetEntryLocalService = assetEntryLocalService;
	}

	@Reference(unbind = "-")
	protected void setLayoutLocalService(
		LayoutLocalService layoutLocalService) {

		_layoutLocalService = layoutLocalService;
	}

	@Reference(unbind = "-")
	protected void setUserLocalService(UserLocalService userLocalService) {
		_userLocalService = userLocalService;
	}

	private AssetEntryLocalService _assetEntryLocalService;
	private LayoutLocalService _layoutLocalService;

	@Reference
	private Portal _portal;

	private ServletContext _servletContext;
	private UserLocalService _userLocalService;

}