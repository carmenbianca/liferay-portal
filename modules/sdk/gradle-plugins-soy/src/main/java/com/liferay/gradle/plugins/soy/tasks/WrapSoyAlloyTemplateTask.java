/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.soy.tasks;

import com.liferay.gradle.plugins.soy.internal.util.GradleUtil;
import com.liferay.portal.tools.soy.builder.commands.WrapSoyAlloyTemplateCommand;

import java.io.File;
import java.io.IOException;

import org.gradle.api.tasks.CacheableTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.SourceTask;
import org.gradle.api.tasks.TaskAction;

/**
 * @author     Andrea Di Giorgi
 * @deprecated As of Judson (7.1.x), with no direct replacement
 */
@CacheableTask
@Deprecated
public class WrapSoyAlloyTemplateTask extends SourceTask {

	@Input
	public String getModuleName() {
		return GradleUtil.toString(_moduleName);
	}

	@Input
	public String getNamespace() {
		return GradleUtil.toString(_namespace);
	}

	public void setModuleName(Object moduleName) {
		_moduleName = moduleName;
	}

	public void setNamespace(Object namespace) {
		_namespace = namespace;
	}

	@TaskAction
	public void wrapAlloyTemplate() throws IOException {
		_wrapSoyAlloyTemplateCommand.setModuleName(getModuleName());
		_wrapSoyAlloyTemplateCommand.setNamespace(getNamespace());

		for (File file : getSource()) {
			_wrapSoyAlloyTemplateCommand.execute(file.toPath());
		}
	}

	private Object _moduleName;
	private Object _namespace;
	private final WrapSoyAlloyTemplateCommand _wrapSoyAlloyTemplateCommand =
		new WrapSoyAlloyTemplateCommand();

}