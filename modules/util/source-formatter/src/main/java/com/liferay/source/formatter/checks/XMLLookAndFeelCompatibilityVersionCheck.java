/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.source.formatter.checks.util.SourceUtil;

import java.io.IOException;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

/**
 * @author Peter Shin
 */
public class XMLLookAndFeelCompatibilityVersionCheck extends BaseFileCheck {

	@Override
	public boolean isLiferaySourceCheck() {
		return true;
	}

	@Override
	protected String doProcess(
			String fileName, String absolutePath, String content)
		throws DocumentException, IOException {

		if (fileName.endsWith("-look-and-feel.xml")) {
			_checkCompatibility(fileName, absolutePath, content);
		}

		return content;
	}

	private void _checkCompatibility(
			String fileName, String absolutePath, String content)
		throws DocumentException, IOException {

		if (!isPortalSource() || !isModulesApp(absolutePath, false)) {
			return;
		}

		boolean privateApp = isModulesApp(absolutePath, true);

		String portalVersion = getPortalVersion(privateApp);

		if (Validator.isNull(portalVersion)) {
			return;
		}

		Document document = SourceUtil.readXML(content);

		Element rootElement = document.getRootElement();

		List<Element> compatibilityElements = rootElement.elements(
			"compatibility");

		for (Element compatibilityElement : compatibilityElements) {
			if (!_hasPortalVersions(compatibilityElement, portalVersion)) {
				StringBundler sb = new StringBundler(4);

				sb.append("Missing version: <version>");
				sb.append(portalVersion);
				sb.append(StringPool.PLUS);
				sb.append("</version>");

				addMessage(fileName, sb.toString());
			}
		}
	}

	private boolean _hasPortalVersions(
		Element compatibilityElement, String portalVersion) {

		List<Element> versionElements = compatibilityElement.elements(
			"version");

		for (Element versionElement : versionElements) {
			String version = versionElement.getText();

			if (StringUtil.equalsIgnoreCase(version, portalVersion + "+")) {
				return true;
			}
		}

		return false;
	}

}