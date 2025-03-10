/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.my.subscriptions.web.internal.util;

import com.liferay.asset.kernel.AssetRendererFactoryRegistryUtil;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.blogs.model.BlogsEntry;
import com.liferay.document.library.kernel.model.DLFileEntryType;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLFileEntryTypeLocalServiceUtil;
import com.liferay.journal.model.JournalFolder;
import com.liferay.message.boards.model.MBCategory;
import com.liferay.message.boards.model.MBMessage;
import com.liferay.message.boards.model.MBThread;
import com.liferay.message.boards.service.MBThreadLocalServiceUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.PortletPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.wiki.constants.WikiPortletKeys;
import com.liferay.wiki.model.WikiNode;
import com.liferay.wiki.service.WikiNodeLocalServiceUtil;

import java.util.Locale;

/**
 * @author Peter Shin
 * @author Jonathan Lee
 */
public class MySubscriptionsUtil {

	public static AssetRenderer getAssetRenderer(
		String className, long classPK) {

		try {
			return doGetAssetRenderer(className, classPK);
		}
		catch (Exception exception) {
		}

		return null;
	}

	public static String getAssetURLViewInContext(
			ThemeDisplay themeDisplay, String className, long classPK)
		throws PortalException {

		if (className.equals(_BLOGS_ENTRY_CLASS_NAME)) {
			return PortalUtil.getLayoutFullURL(classPK, PortletKeys.BLOGS);
		}

		if (className.equals(Folder.class.getName())) {
			return PortalUtil.getLayoutFullURL(
				classPK, PortletKeys.DOCUMENT_LIBRARY);
		}

		if (className.equals(_KNOWLEDGE_BASE_MODEL_CLASS_NAME)) {
			return PortalUtil.getLayoutFullURL(
				classPK, _KNOWLEDGE_BASE_DISPLAY_PORTLET_ID);
		}

		if (className.equals(Layout.class.getName())) {
			return PortalUtil.getLayoutFullURL(
				LayoutLocalServiceUtil.getLayout(classPK), themeDisplay);
		}

		if (className.equals(MBCategory.class.getName())) {
			String portletId = PortletProviderUtil.getPortletId(
				MBMessage.class.getName(), PortletProvider.Action.VIEW);

			return PortalUtil.getLayoutFullURL(classPK, portletId);
		}

		if (className.equals(WikiNode.class.getName())) {
			long plid = PortalUtil.getPlidFromPortletId(
				themeDisplay.getScopeGroupId(), WikiPortletKeys.WIKI);

			if (plid == 0) {
				return null;
			}

			StringBundler sb = new StringBundler(5);

			String layoutFullURL = PortalUtil.getLayoutFullURL(
				LayoutLocalServiceUtil.getLayout(plid), themeDisplay);

			sb.append(layoutFullURL);

			sb.append(Portal.FRIENDLY_URL_SEPARATOR);
			sb.append("wiki/");
			sb.append(classPK);
			sb.append("/all_pages");

			return sb.toString();
		}

		return null;
	}

	public static String getTitleText(
			Locale locale, String className, long classPK, String title)
		throws PortalException {

		if (Validator.isNotNull(title)) {
			return title;
		}

		Group group = GroupLocalServiceUtil.fetchGroup(classPK);

		if (className.equals(BlogsEntry.class.getName()) ||
			className.equals(_BLOGS_ENTRY_CLASS_NAME)) {

			title = "Blog at ";
		}
		else if (className.equals(DLFileEntryType.class.getName())) {
			if (group != null) {
				return LanguageUtil.get(locale, "basic-document");
			}

			DLFileEntryType dlFileEntryType =
				DLFileEntryTypeLocalServiceUtil.getDLFileEntryType(classPK);

			return dlFileEntryType.getName(locale);
		}
		else if (className.equals(DLFolderConstants.getClassName()) ||
				 className.equals(Folder.class.getName())) {

			if (group != null) {
				return LanguageUtil.get(locale, "home");
			}
		}
		else if (className.equals(JournalFolder.class.getName())) {
			if (group != null) {
				return LanguageUtil.get(locale, "home");
			}
		}
		else if (className.equals(_KNOWLEDGE_BASE_MODEL_CLASS_NAME)) {
			title = "Knowledge Base Article at ";
		}
		else if (className.equals(Layout.class.getName())) {
			Layout layout = LayoutLocalServiceUtil.getLayout(classPK);

			return layout.getName(locale);
		}
		else if (className.equals(MBCategory.class.getName())) {
			title = "Message Board at ";
		}
		else if (className.equals(PortletPreferences.class.getName())) {
			PortletPreferences portletPreferences =
				PortletPreferencesLocalServiceUtil.getPortletPreferences(
					classPK);

			Layout layout = LayoutLocalServiceUtil.getLayout(
				portletPreferences.getPlid());

			javax.portlet.PortletPreferences jxPortletPreferences =
				PortletPreferencesFactoryUtil.getPortletSetup(
					layout, portletPreferences.getPortletId(), null);

			String portletTitle = jxPortletPreferences.getValue(
				"portletSetupTitle_" + LocaleUtil.toLanguageId(locale),
				StringPool.BLANK);

			if (Validator.isNull(portletTitle)) {
				portletTitle = "Asset Publisher";
			}

			return portletTitle;
		}
		else if (className.equals(WikiNode.class.getName())) {
			WikiNode wikiNode = WikiNodeLocalServiceUtil.getWikiNode(classPK);

			return wikiNode.getName();
		}

		if (group != null) {
			title += group.getDescriptiveName(locale);
		}

		if (Validator.isNull(title)) {
			title = String.valueOf(classPK);
		}

		return title;
	}

	protected static AssetRenderer doGetAssetRenderer(
			String className, long classPK)
		throws Exception {

		if (className.equals(Folder.class.getName())) {
			className = DLFolder.class.getName();
		}
		else if (className.equals(MBThread.class.getName())) {
			className = MBMessage.class.getName();

			MBThread mbThread = MBThreadLocalServiceUtil.getThread(classPK);

			classPK = mbThread.getRootMessageId();
		}

		AssetRendererFactory assetRendererFactory =
			AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(
				className);

		return assetRendererFactory.getAssetRenderer(classPK);
	}

	private static final String _BLOGS_ENTRY_CLASS_NAME =
		"com.liferay.blogs.kernel.model.BlogsEntry";

	private static final String _KNOWLEDGE_BASE_DISPLAY_PORTLET_ID =
		"com_liferay_knowledge_base_web_portlet_DisplayPortlet";

	private static final String _KNOWLEDGE_BASE_MODEL_CLASS_NAME =
		"com.liferay.knowledge.base.model.KBArticle";

}