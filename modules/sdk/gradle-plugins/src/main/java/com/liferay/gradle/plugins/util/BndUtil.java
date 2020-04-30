/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.util;

import com.liferay.gradle.plugins.extensions.BundleExtension;
import com.liferay.gradle.plugins.internal.util.GradleUtil;

import java.util.Map;

import org.gradle.api.Project;
import org.gradle.api.UnknownDomainObjectException;
import org.gradle.api.plugins.ExtensionContainer;

/**
 * @author Andrea Di Giorgi
 * @author Raymond Augé
 */
public class BndUtil {

	public static String getInstruction(Project project, String key) {
		Map<String, Object> bundleInstructions = getInstructions(project);

		return GradleUtil.toString(bundleInstructions.get(key));
	}

	public static BundleExtension getInstructions(Project project) {
		try {
			return GradleUtil.getExtension(project, BundleExtension.class);
		}
		catch (UnknownDomainObjectException unknownDomainObjectException) {
			BundleExtension bundleExtension = new BundleExtension();

			ExtensionContainer extensionContainer = project.getExtensions();

			extensionContainer.add(
				BundleExtension.class, "bundle", bundleExtension);

			return bundleExtension;
		}
	}

}