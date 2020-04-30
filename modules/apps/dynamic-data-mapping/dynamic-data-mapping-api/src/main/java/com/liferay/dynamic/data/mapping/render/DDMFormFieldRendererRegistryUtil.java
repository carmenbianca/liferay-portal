/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.render;

/**
 * @author Pablo Carvalho
 */
public class DDMFormFieldRendererRegistryUtil {

	public static DDMFormFieldRenderer getDDMFormFieldRenderer(
		String ddmFormFieldType) {

		return getDDMFormFieldRendererRegistry().getDDMFormFieldRenderer(
			ddmFormFieldType);
	}

	public static DDMFormFieldRendererRegistry
		getDDMFormFieldRendererRegistry() {

		return _ddmFormFieldRendererRegistry;
	}

	public void setDDMFormFieldRendererRegistry(
		DDMFormFieldRendererRegistry ddmFormFieldRendererRegistry) {

		_ddmFormFieldRendererRegistry = ddmFormFieldRendererRegistry;
	}

	private static DDMFormFieldRendererRegistry _ddmFormFieldRendererRegistry;

}