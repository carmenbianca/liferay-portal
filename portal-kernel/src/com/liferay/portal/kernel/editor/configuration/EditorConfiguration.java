/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.editor.configuration;

import com.liferay.portal.kernel.json.JSONObject;

import java.util.Map;

/**
 * @author Sergio González
 */
public interface EditorConfiguration {

	public JSONObject getConfigJSONObject();

	public Map<String, Object> getData();

	public EditorOptions getEditorOptions();

}