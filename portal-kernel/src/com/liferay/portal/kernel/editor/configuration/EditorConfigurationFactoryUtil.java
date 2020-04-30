/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.editor.configuration;

import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.util.Map;

/**
 * @author Sergio González
 */
public class EditorConfigurationFactoryUtil {

	public static EditorConfiguration getEditorConfiguration(
		String portletName, String editorConfigKey, String editorName,
		Map<String, Object> inputEditorTaglibAttributes,
		ThemeDisplay themeDisplay,
		RequestBackedPortletURLFactory requestBackedPortletURLFactory) {

		return getEditorConfigurationFactory().getEditorConfiguration(
			portletName, editorConfigKey, editorName,
			inputEditorTaglibAttributes, themeDisplay,
			requestBackedPortletURLFactory);
	}

	public static EditorConfigurationFactory getEditorConfigurationFactory() {
		return _editorConfigurationFactory;
	}

	public void setEditorConfigurationFactory(
		EditorConfigurationFactory editorConfigurationFactory) {

		_editorConfigurationFactory = editorConfigurationFactory;
	}

	private static EditorConfigurationFactory _editorConfigurationFactory;

}