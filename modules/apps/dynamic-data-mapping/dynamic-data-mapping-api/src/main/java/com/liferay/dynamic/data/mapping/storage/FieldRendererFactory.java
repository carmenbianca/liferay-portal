/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.storage;

import java.util.Map;

/**
 * @author Bruno Basto
 */
public class FieldRendererFactory {

	public static FieldRenderer getFieldRenderer(String dataType) {
		FieldRenderer fieldRenderer = _fieldRenderers.get(dataType);

		if (fieldRenderer == null) {
			fieldRenderer = _fieldRenderers.get(FieldConstants.STRING);
		}

		return fieldRenderer;
	}

	public void setFieldRenderers(Map<String, FieldRenderer> fieldRenderers) {
		_fieldRenderers = fieldRenderers;
	}

	private static Map<String, FieldRenderer> _fieldRenderers;

}