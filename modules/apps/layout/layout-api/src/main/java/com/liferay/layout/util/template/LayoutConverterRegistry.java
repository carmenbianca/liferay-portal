/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.util.template;

/**
 * @author Eudaldo Alonso
 */
public interface LayoutConverterRegistry {

	public LayoutConverter getLayoutConverter(String layoutTemplateId);

}