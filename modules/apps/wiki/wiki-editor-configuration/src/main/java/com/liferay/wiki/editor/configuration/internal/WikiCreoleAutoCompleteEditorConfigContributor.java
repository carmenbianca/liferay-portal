/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.editor.configuration.internal;

import com.liferay.portal.kernel.editor.configuration.BaseEditorConfigContributor;
import com.liferay.portal.kernel.editor.configuration.EditorConfigContributor;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.wiki.constants.WikiPortletKeys;

import java.util.Map;

import javax.portlet.ResourceURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Roberto Díaz
 */
@Component(
	property = {
		"editor.name=alloyeditor_creole", "editor.name=ckeditor_creole",
		"javax.portlet.name=" + WikiPortletKeys.WIKI,
		"javax.portlet.name=" + WikiPortletKeys.WIKI_ADMIN,
		"javax.portlet.name=" + WikiPortletKeys.WIKI_DISPLAY,
		"service.ranking:Integer=100"
	},
	service = EditorConfigContributor.class
)
public class WikiCreoleAutoCompleteEditorConfigContributor
	extends BaseEditorConfigContributor {

	@Override
	public void populateConfigJSONObject(
		JSONObject jsonObject, Map<String, Object> inputEditorTaglibAttributes,
		ThemeDisplay themeDisplay,
		RequestBackedPortletURLFactory requestBackedPortletURLFactory) {

		JSONObject autoCompleteConfigJSONObject = JSONUtil.put(
			"requestTemplate", "query={query}");

		JSONObject triggerJSONObject = JSONUtil.put(
			"resultFilters", "function(query, results) {return results;}"
		).put(
			"resultTextLocator", "title"
		);

		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		ResourceURL autoCompletePageTitleURL =
			(ResourceURL)requestBackedPortletURLFactory.createResourceURL(
				portletDisplay.getId());

		Map<String, String> fileBrowserParams =
			(Map<String, String>)inputEditorTaglibAttributes.get(
				"liferay-ui:input-editor:fileBrowserParams");

		autoCompletePageTitleURL.setParameter(
			"nodeId", fileBrowserParams.get("nodeId"));

		autoCompletePageTitleURL.setResourceID("/wiki/autocomplete_page_title");

		String source =
			autoCompletePageTitleURL.toString() + "&" +
				_portal.getPortletNamespace(portletDisplay.getId());

		triggerJSONObject.put(
			"source", source
		).put(
			"term", "["
		).put(
			"tplReplace", "<a href=\"{title}\">{title}</a>"
		).put(
			"tplResults", "<span class=\"h5 text-truncate\">{title}</span>"
		);

		autoCompleteConfigJSONObject.put(
			"trigger", JSONUtil.put(triggerJSONObject));

		jsonObject.put("autocomplete", autoCompleteConfigJSONObject);

		String extraPlugins = jsonObject.getString("extraPlugins");

		if (Validator.isNotNull(extraPlugins)) {
			extraPlugins += ",autocomplete";
		}
		else {
			extraPlugins =
				"autocomplete,ae_placeholder,ae_selectionregion,ae_uicore";
		}

		jsonObject.put("extraPlugins", extraPlugins);
	}

	@Reference
	private Portal _portal;

}