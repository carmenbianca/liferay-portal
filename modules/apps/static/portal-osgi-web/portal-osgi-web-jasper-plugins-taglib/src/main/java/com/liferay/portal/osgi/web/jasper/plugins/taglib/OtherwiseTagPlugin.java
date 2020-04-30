/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.osgi.web.jasper.plugins.taglib;

import org.apache.jasper.compiler.tagplugin.TagPlugin;
import org.apache.jasper.compiler.tagplugin.TagPluginContext;

/**
 * @author Preston Crary
 * @see    ChooseTagPlugin
 * @see    WhenTagPlugin
 */
public class OtherwiseTagPlugin implements TagPlugin {

	@Override
	public void doTag(TagPluginContext tagPluginContext) {
		tagPluginContext.generateJavaSource("}\nelse {");
		tagPluginContext.generateBody();
	}

}