/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.render;

/**
 * @author Marcellus Tavares
 */
public class DDMFormFieldValueRendererRegistryUtil {

	public static DDMFormFieldValueRenderer getDDMFormFieldValueRenderer(
		String ddmFormFieldType) {

		DDMFormFieldValueRendererRegistry ddmFormFieldValueRendererRegistry =
			getDDMFormFieldValueRendererRegistry();

		return ddmFormFieldValueRendererRegistry.getDDMFormFieldValueRenderer(
			ddmFormFieldType);
	}

	public static DDMFormFieldValueRendererRegistry
		getDDMFormFieldValueRendererRegistry() {

		return _ddmFormFieldValueRendererRegistry;
	}

	public void setDDMFormFieldValueRendererRegistry(
		DDMFormFieldValueRendererRegistry ddmFormFieldValueRendererRegistry) {

		_ddmFormFieldValueRendererRegistry = ddmFormFieldValueRendererRegistry;
	}

	private static DDMFormFieldValueRendererRegistry
		_ddmFormFieldValueRendererRegistry;

}