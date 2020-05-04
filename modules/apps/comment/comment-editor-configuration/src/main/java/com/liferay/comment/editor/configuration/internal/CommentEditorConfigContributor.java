/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.comment.editor.configuration.internal;

import com.liferay.portal.kernel.editor.configuration.BaseEditorConfigContributor;
import com.liferay.portal.kernel.editor.configuration.EditorConfigContributor;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PropsValues;

import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * @author Ambrín Chaudhary
 */
@Component(
	property = "editor.config.key=commentEditor",
	service = EditorConfigContributor.class
)
public class CommentEditorConfigContributor
	extends BaseEditorConfigContributor {

	@Override
	public void populateConfigJSONObject(
		JSONObject jsonObject, Map<String, Object> inputEditorTaglibAttributes,
		ThemeDisplay themeDisplay,
		RequestBackedPortletURLFactory requestBackedPortletURLFactory) {

		jsonObject.put(
			"allowedContent", PropsValues.DISCUSSION_COMMENTS_ALLOWED_CONTENT
		).put(
			"toolbars", JSONFactoryUtil.createJSONObject()
		);

		if (PropsValues.DISCUSSION_COMMENTS_FORMAT.equals("bbcode")) {
			String extraPlugins = jsonObject.getString("extraPlugins");

			if (Validator.isNull(extraPlugins)) {
				extraPlugins = "bbcode";
			}
			else if (!extraPlugins.contains("bbcode")) {
				extraPlugins = extraPlugins + ",bbcode";
			}

			jsonObject.put("extraPlugins", extraPlugins);
		}
	}

}