/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.data.provider;

/**
 * @author Marcellus Tavares
 */
public interface DDMDataProviderInvoker {

	public DDMDataProviderResponse invoke(
		DDMDataProviderRequest ddmDataProviderRequest);

}