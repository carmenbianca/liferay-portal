/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.tld.formatter;

import java.util.ArrayList;
import java.util.List;

import org.gradle.api.tasks.CacheableTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.JavaExec;

/**
 * @author Andrea Di Giorgi
 */
@CacheableTask
public class FormatTLDTask extends JavaExec {

	public FormatTLDTask() {
		setMain("com.liferay.tld.formatter.TLDFormatter");
	}

	@Override
	public void exec() {
		setArgs(getCompleteArgs());

		super.exec();
	}

	@Input
	public boolean isPlugin() {
		return _plugin;
	}

	public void setPlugin(boolean plugin) {
		_plugin = plugin;
	}

	protected List<String> getCompleteArgs() {
		List<String> args = new ArrayList<>(getArgs());

		args.add("tld.plugin=" + isPlugin());

		return args;
	}

	private boolean _plugin = true;

}