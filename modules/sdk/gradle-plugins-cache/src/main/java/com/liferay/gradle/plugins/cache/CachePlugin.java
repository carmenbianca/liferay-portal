/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.cache;

import com.liferay.gradle.plugins.cache.task.TaskCache;
import com.liferay.gradle.plugins.cache.task.TaskCacheApplicator;
import com.liferay.gradle.util.GradleUtil;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * @author Andrea Di Giorgi
 */
public class CachePlugin implements Plugin<Project> {

	public static final String EXTENSION_NAME = "cache";

	@Override
	public void apply(Project project) {
		final CacheExtension cacheExtension = GradleUtil.addExtension(
			project, EXTENSION_NAME, CacheExtension.class);

		project.afterEvaluate(
			new Action<Project>() {

				@Override
				public void execute(Project project) {
					applyTaskCaches(cacheExtension);
				}

			});
	}

	protected void applyTaskCaches(CacheExtension cacheExtension) {
		for (TaskCache taskCache : cacheExtension.getTasks()) {
			_taskCacheApplicator.apply(cacheExtension, taskCache);
		}
	}

	private static final TaskCacheApplicator _taskCacheApplicator =
		new TaskCacheApplicator();

}