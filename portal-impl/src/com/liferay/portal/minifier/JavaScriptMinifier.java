/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.minifier;

/**
 * @author Carlos Sierra Andrés
 */
public interface JavaScriptMinifier {

	public String compress(String resourceName, String content);

}