/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.soy.builder.maven;

import com.liferay.portal.tools.soy.builder.commands.WrapSoyAlloyTemplateCommand;

/**
 * Wrap Soy templates into AlloyUI modules.
 *
 * @author Andrea Di Giorgi
 * @goal wrap-alloy-template
 */
public class WrapSoyAlloyTemplateMojo
	extends BaseSoyJsMojo<WrapSoyAlloyTemplateCommand> {

	/**
	 * The AlloyUI module name.
	 *
	 * @parameter
	 * @required
	 */
	public void setModuleName(String moduleName) {
		command.setModuleName(moduleName);
	}

	/**
	 * The Soy template namespace.
	 *
	 * @parameter
	 * @required
	 */
	public void setNamespace(String namespace) {
		command.setNamespace(namespace);
	}

	@Override
	protected WrapSoyAlloyTemplateCommand createCommand() {
		return new WrapSoyAlloyTemplateCommand();
	}

}