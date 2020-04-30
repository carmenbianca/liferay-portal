/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.io.File;

/**
 * @author Michael Hashimoto
 */
public class DefaultBuildDatabase extends BaseBuildDatabase {

	public DefaultBuildDatabase(File basedir) {
		super(basedir);
	}

}