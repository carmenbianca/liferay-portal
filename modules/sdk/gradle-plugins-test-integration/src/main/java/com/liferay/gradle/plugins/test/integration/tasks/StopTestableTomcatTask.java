/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.test.integration.tasks;

import com.liferay.gradle.plugins.test.integration.internal.util.GradleUtil;

import java.io.File;

import org.gradle.api.logging.Logger;
import org.gradle.api.tasks.CacheableTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.PathSensitive;
import org.gradle.api.tasks.PathSensitivity;

/**
 * @author Andrea Di Giorgi
 */
@CacheableTask
public class StopTestableTomcatTask
	extends StopAppServerTask implements ModuleFrameworkBaseDirSpec {

	@Input
	@Override
	@PathSensitive(PathSensitivity.RELATIVE)
	public File getModuleFrameworkBaseDir() {
		return GradleUtil.toFile(getProject(), _moduleFrameworkBaseDir);
	}

	@Input
	public boolean isDeleteTestModules() {
		return _deleteTestModules;
	}

	public void setDeleteTestModules(boolean deleteTestModules) {
		_deleteTestModules = deleteTestModules;
	}

	@Override
	public void setModuleFrameworkBaseDir(Object moduleFrameworkBaseDir) {
		_moduleFrameworkBaseDir = moduleFrameworkBaseDir;
	}

	@Override
	public void stopAppServer() throws Exception {
		super.stopAppServer();

		if (isDeleteTestModules()) {
			_deleteTestModules();
		}
	}

	private void _deleteTestModules() {
		Logger logger = getLogger();

		File moduleFrameworkBaseDir = getModuleFrameworkBaseDir();

		File modulesDir = new File(moduleFrameworkBaseDir, "modules");
		File testDir = new File(moduleFrameworkBaseDir, "test");

		for (File file : testDir.listFiles()) {
			File moduleFile = new File(modulesDir, file.getName());

			if (!moduleFile.exists()) {
				continue;
			}

			boolean deleted = moduleFile.delete();

			if (!deleted && logger.isWarnEnabled()) {
				logger.warn("Unable to delete {}", moduleFile);
			}
		}
	}

	private boolean _deleteTestModules = true;
	private Object _moduleFrameworkBaseDir;

}