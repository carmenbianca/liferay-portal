/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.render;

/**
 * @author Marcellus Tavares
 */
public interface DDMFormFieldValueRendererRegistry {

	public DDMFormFieldValueRenderer getDDMFormFieldValueRenderer(
		String ddmFormFieldType);

}