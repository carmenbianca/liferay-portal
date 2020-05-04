/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.baseline.internal.work;

import org.gradle.api.file.DirectoryProperty;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.provider.Property;
import org.gradle.workers.WorkParameters;

/**
 * @author Peter Shin
 */
public interface BaselineWorkParameters extends WorkParameters {

	public RegularFileProperty getBndFile();

	public Property<Boolean> getForceCalculatedVersion();

	public Property<Boolean> getIgnoreExcessiveVersionIncreases();

	public Property<Boolean> getIgnoreFailures();

	public RegularFileProperty getLogFile();

	public RegularFileProperty getNewJarFile();

	public RegularFileProperty getOldJarFile();

	public Property<Boolean> getReportDiff();

	public Property<Boolean> getReportOnlyDirtyPackages();

	public DirectoryProperty getSourceDir();

}