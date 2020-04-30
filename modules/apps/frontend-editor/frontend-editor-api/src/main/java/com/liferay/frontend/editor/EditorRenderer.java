/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.editor;

/**
 * @author Iván Zaera Avellón
 */
public interface EditorRenderer {

	public String getAttributeNamespace();

	public String[] getJavaScriptModules();

	public String getJspPath();

	public String getResourcesJspPath();

	public String getResourceType();

}