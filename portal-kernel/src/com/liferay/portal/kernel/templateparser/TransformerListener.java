/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.templateparser;

import com.liferay.portal.kernel.xml.Document;

import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 * @author Tina Tina
 */
public interface TransformerListener {

	public String onOutput(
		String output, String languageId, Map<String, String> tokens);

	public String onScript(
		String script, Document document, String languageId,
		Map<String, String> tokens);

	public Document onXml(
		Document document, String languageId, Map<String, String> tokens);

}