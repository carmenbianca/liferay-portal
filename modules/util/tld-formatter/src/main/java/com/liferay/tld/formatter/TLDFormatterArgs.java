/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.tld.formatter;

/**
 * @author Andrea Di Giorgi
 */
public class TLDFormatterArgs {

	public static final String BASE_DIR_NAME = "./";

	public static final String OUTPUT_KEY_MODIFIED_FILES =
		"tld.formatter.modified.files";

	public static final boolean PLUGIN = true;

	public String getBaseDirName() {
		return _baseDirName;
	}

	public boolean isPlugin() {
		return _plugin;
	}

	public void setBaseDirName(String baseDirName) {
		_baseDirName = baseDirName;
	}

	public void setPlugin(boolean plugin) {
		_plugin = plugin;
	}

	private String _baseDirName = BASE_DIR_NAME;
	private boolean _plugin = PLUGIN;

}