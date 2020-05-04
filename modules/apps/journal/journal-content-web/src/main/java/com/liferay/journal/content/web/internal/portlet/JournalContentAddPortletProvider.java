/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.content.web.internal.portlet;

import com.liferay.asset.kernel.AssetRendererFactoryRegistryUtil;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.journal.constants.JournalContentPortletKeys;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalContentSearchLocalService;
import com.liferay.layout.model.LayoutClassedModelUsage;
import com.liferay.layout.service.LayoutClassedModelUsageLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.portlet.AddPortletProvider;
import com.liferay.portal.kernel.portlet.BasePortletProvider;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Portal;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component(
	immediate = true,
	property = "model.class.name=com.liferay.journal.model.JournalArticle",
	service = AddPortletProvider.class
)
public class JournalContentAddPortletProvider
	extends BasePortletProvider implements AddPortletProvider {

	@Override
	public String getPortletName() {
		return JournalContentPortletKeys.JOURNAL_CONTENT;
	}

	@Override
	public PortletURL getPortletURL(
			HttpServletRequest httpServletRequest, Group group)
		throws PortalException {

		return PortletURLFactoryUtil.create(
			httpServletRequest, getPortletName(), PortletRequest.RENDER_PHASE);
	}

	@Override
	public void updatePortletPreferences(
			PortletPreferences portletPreferences, String portletId,
			String className, long classPK, ThemeDisplay themeDisplay)
		throws Exception {

		AssetEntry assetEntry = _assetEntryLocalService.getEntry(
			className, classPK);

		AssetRendererFactory<JournalArticle> articleAssetRendererFactory =
			AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClass(
				JournalArticle.class);

		AssetRenderer<JournalArticle> articleAssetRenderer =
			articleAssetRendererFactory.getAssetRenderer(
				assetEntry.getClassPK());

		JournalArticle article = articleAssetRenderer.getAssetObject();

		portletPreferences.setValue("articleId", article.getArticleId());
		portletPreferences.setValue(
			"groupId", String.valueOf(article.getGroupId()));

		portletPreferences.setValue(
			"assetEntryId", String.valueOf(assetEntry.getEntryId()));

		Layout layout = themeDisplay.getLayout();

		_addLayoutClassedModelUsage(layout, portletId, article);

		_journalContentSearchLocalService.updateContentSearch(
			layout.getGroupId(), layout.isPrivateLayout(), layout.getLayoutId(),
			portletId, article.getArticleId(), true);
	}

	private void _addLayoutClassedModelUsage(
		Layout layout, String portletId, JournalArticle article) {

		LayoutClassedModelUsage layoutClassedModelUsage =
			_layoutClassedModelUsageLocalService.fetchLayoutClassedModelUsage(
				_portal.getClassNameId(JournalArticle.class),
				article.getResourcePrimKey(), portletId,
				_portal.getClassNameId(Portlet.class), layout.getPlid());

		if (layoutClassedModelUsage != null) {
			return;
		}

		_layoutClassedModelUsageLocalService.addLayoutClassedModelUsage(
			layout.getGroupId(), _portal.getClassNameId(JournalArticle.class),
			article.getResourcePrimKey(), portletId,
			_portal.getClassNameId(Portlet.class), layout.getPlid(),
			ServiceContextThreadLocal.getServiceContext());
	}

	@Reference
	private AssetEntryLocalService _assetEntryLocalService;

	@Reference
	private JournalContentSearchLocalService _journalContentSearchLocalService;

	@Reference
	private LayoutClassedModelUsageLocalService
		_layoutClassedModelUsageLocalService;

	@Reference
	private Portal _portal;

}