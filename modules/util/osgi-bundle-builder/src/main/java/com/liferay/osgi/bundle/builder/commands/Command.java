/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.osgi.bundle.builder.commands;

import com.liferay.osgi.bundle.builder.OSGiBundleBuilderArgs;

/**
 * @author David Truong
 */
public interface Command {

	public void build(OSGiBundleBuilderArgs osgiBundleBuilderArgs)
		throws Exception;

}