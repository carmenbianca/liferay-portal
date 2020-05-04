/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.editor.configuration.internal;

import com.liferay.item.selector.ItemSelector;
import com.liferay.item.selector.ItemSelectorCriterion;
import com.liferay.item.selector.criteria.FileEntryItemSelectorReturnType;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.editor.configuration.EditorConfigContributor;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.wiki.configuration.WikiFileUploadConfiguration;
import com.liferay.wiki.constants.WikiPortletKeys;

import java.util.Map;

import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Ambrín Chaudhary
 */
@Component(
	configurationPid = "com.liferay.wiki.configuration.WikiFileUploadConfiguration",
	property = {
		"editor.config.key=contentEditor", "editor.name=alloyeditor",
		"editor.name=ckeditor", "javax.portlet.name=" + WikiPortletKeys.WIKI,
		"javax.portlet.name=" + WikiPortletKeys.WIKI_ADMIN,
		"javax.portlet.name=" + WikiPortletKeys.WIKI_DISPLAY,
		"service.ranking:Integer=100"
	},
	service = EditorConfigContributor.class
)
public class WikiAttachmentImageHTMLEditorConfigContributor
	extends BaseWikiAttachmentImageEditorConfigContributor {

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_wikiFileUploadConfiguration = ConfigurableUtil.createConfigurable(
			WikiFileUploadConfiguration.class, properties);
	}

	@Override
	protected String getItemSelectorURL(
		RequestBackedPortletURLFactory requestBackedPortletURLFactory,
		String itemSelectedEventName, long wikiPageResourcePrimKey,
		ThemeDisplay themeDisplay) {

		ItemSelectorCriterion imageItemSelectorCriterion =
			getImageItemSelectorCriterion(
				new FileEntryItemSelectorReturnType());

		if (wikiPageResourcePrimKey == 0) {
			PortletURL itemSelectorURL = _itemSelector.getItemSelectorURL(
				requestBackedPortletURLFactory, itemSelectedEventName,
				imageItemSelectorCriterion, getURLItemSelectorCriterion());

			return itemSelectorURL.toString();
		}

		ItemSelectorCriterion attachmentItemSelectorCriterion =
			getWikiAttachmentItemSelectorCriterion(
				wikiPageResourcePrimKey, new FileEntryItemSelectorReturnType());

		ItemSelectorCriterion uploadItemSelectorCriterion =
			getUploadItemSelectorCriterion(
				wikiPageResourcePrimKey, themeDisplay,
				requestBackedPortletURLFactory);

		PortletURL itemSelectorURL = _itemSelector.getItemSelectorURL(
			requestBackedPortletURLFactory, itemSelectedEventName,
			attachmentItemSelectorCriterion, imageItemSelectorCriterion,
			getURLItemSelectorCriterion(), uploadItemSelectorCriterion);

		return itemSelectorURL.toString();
	}

	@Override
	protected WikiFileUploadConfiguration getWikiFileUploadConfiguration() {
		return _wikiFileUploadConfiguration;
	}

	@Reference(unbind = "-")
	protected void setItemSelector(ItemSelector itemSelector) {
		_itemSelector = itemSelector;
	}

	protected void setWikiFileUploadConfiguration(
		WikiFileUploadConfiguration wikiFileUploadConfiguration) {

		_wikiFileUploadConfiguration = wikiFileUploadConfiguration;
	}

	private ItemSelector _itemSelector;
	private WikiFileUploadConfiguration _wikiFileUploadConfiguration;

}