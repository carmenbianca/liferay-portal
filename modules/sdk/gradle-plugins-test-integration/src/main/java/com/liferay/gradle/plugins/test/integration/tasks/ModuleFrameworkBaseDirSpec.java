/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.test.integration.tasks;

import java.io.File;

/**
 * @author Andrea Di Giorgi
 */
public interface ModuleFrameworkBaseDirSpec {

	public File getModuleFrameworkBaseDir();

	public void setModuleFrameworkBaseDir(Object moduleFrameworkBaseDir);

}