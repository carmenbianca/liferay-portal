/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.editor;

/**
 * @author Julio Camarero
 */
public class EditorModeUtil {

	public static String getEditorMode(String langType) {
		String editorMode = "php";

		if (langType.equals("css")) {
			editorMode = "css";
		}
		else if (langType.equals("xml") || langType.equals("xsl") ||
				 langType.equals("xsd")) {

			editorMode = "xml";
		}

		return editorMode;
	}

}