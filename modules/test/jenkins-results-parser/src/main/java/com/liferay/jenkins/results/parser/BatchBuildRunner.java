/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Michael Hashimoto
 */
public abstract class BatchBuildRunner
	<T extends BatchBuildData, S extends Workspace>
		extends BaseBuildRunner<T, S> {

	protected BatchBuildRunner(T batchBuildData) {
		super(batchBuildData);
	}

}