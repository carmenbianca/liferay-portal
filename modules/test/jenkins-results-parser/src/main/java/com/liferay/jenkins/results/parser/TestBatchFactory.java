/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.lang.reflect.Proxy;

/**
 * @author Michael Hashimoto
 */
public class TestBatchFactory {

	public static TestBatch newTestBatch(
		BatchBuildData batchBuildData, Workspace workspace) {

		TestBatch testBatch = null;

		if ((batchBuildData instanceof PortalBatchBuildData) &&
			(workspace instanceof PortalWorkspace)) {

			PortalBatchBuildData portalBatchBuildData =
				(PortalBatchBuildData)batchBuildData;
			PortalWorkspace portalWorkspace = (PortalWorkspace)workspace;

			String batchName = batchBuildData.getBatchName();

			if (batchName.contains("functional")) {
				testBatch = new FunctionalPortalTestBatch(
					portalBatchBuildData, portalWorkspace);
			}
			else if (batchName.contains("integration") ||
					 batchName.contains("unit")) {

				testBatch = new JunitPortalTestBatch(
					portalBatchBuildData, portalWorkspace);
			}
			else {
				testBatch = new DefaultPortalTestBatch(
					portalBatchBuildData, portalWorkspace);
			}
		}

		if (testBatch == null) {
			throw new RuntimeException("Unsuppported batch");
		}

		return (TestBatch)Proxy.newProxyInstance(
			TestBatch.class.getClassLoader(), new Class<?>[] {TestBatch.class},
			new MethodLogger(testBatch));
	}

}