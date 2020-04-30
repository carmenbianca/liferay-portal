/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Michael Hashimoto
 */
public class DefaultPortalTestBatch
	extends BasePortalTestBatch<PortalBatchBuildData, PortalWorkspace> {

	protected DefaultPortalTestBatch(
		PortalBatchBuildData portalBatchBuildData,
		PortalWorkspace portalWorkspace) {

		super(portalBatchBuildData, portalWorkspace);
	}

}