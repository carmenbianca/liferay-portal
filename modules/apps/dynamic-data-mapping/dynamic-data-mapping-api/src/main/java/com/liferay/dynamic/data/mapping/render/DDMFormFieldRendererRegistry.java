/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.render;

/**
 * @author Pablo Carvalho
 */
public interface DDMFormFieldRendererRegistry {

	public DDMFormFieldRenderer getDDMFormFieldRenderer(
		String ddmFormFieldType);

}