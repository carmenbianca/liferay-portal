/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.util.work;

import org.gradle.api.provider.ListProperty;
import org.gradle.api.provider.Property;
import org.gradle.workers.WorkParameters;

/**
 * @author Peter Shin
 */
public interface ExecuteJavaWorkParameters extends WorkParameters {

	public ListProperty<String> getArgs();

	public Property<String> getMain();

}