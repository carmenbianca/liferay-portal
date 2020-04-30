/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser.test.clazz.group;

import com.liferay.jenkins.results.parser.Job;
import com.liferay.jenkins.results.parser.PortalTestClassJob;

/**
 * @author Michael Hashimoto
 */
public class TestClassGroupFactory {

	public static BatchTestClassGroup newBatchTestClassGroup(
		String batchName, BatchTestClassGroup.BuildProfile buildProfile,
		Job job) {

		if (job instanceof PortalTestClassJob) {
			PortalTestClassJob portalTestClassJob = (PortalTestClassJob)job;

			if (batchName.contains("functional-") ||
				batchName.contains("subrepository-functional-")) {

				return new FunctionalBatchTestClassGroup(
					batchName, buildProfile, portalTestClassJob);
			}

			if (batchName.startsWith("integration-") ||
				batchName.startsWith("junit-test-") ||
				batchName.startsWith("subrepository-integration-") ||
				batchName.startsWith("subrepository-unit-") ||
				batchName.startsWith("unit-")) {

				return new JUnitBatchTestClassGroup(
					batchName, buildProfile, portalTestClassJob);
			}

			if (batchName.startsWith("modules-compile-")) {
				return new ModulesCompileBatchTestClassGroup(
					batchName, buildProfile, portalTestClassJob);
			}

			if (batchName.startsWith("modules-integration-") ||
				batchName.startsWith("modules-unit-")) {

				return new ModulesJUnitBatchTestClassGroup(
					batchName, buildProfile, portalTestClassJob);
			}

			if (batchName.startsWith("modules-semantic-versioning-")) {
				return new ModulesSemVerBatchTestClassGroup(
					batchName, buildProfile, portalTestClassJob);
			}

			if (batchName.startsWith("plugins-compile-")) {
				return new PluginsBatchTestClassGroup(
					batchName, buildProfile, portalTestClassJob);
			}

			if (batchName.startsWith("js-test-") ||
				batchName.startsWith("portal-frontend-js-")) {

				return new NPMTestBatchTestClassGroup(
					batchName, buildProfile, portalTestClassJob);
			}

			if (batchName.startsWith("service-builder-")) {
				return new ServiceBuilderBatchTestClassGroup(
					batchName, buildProfile, portalTestClassJob);
			}

			if (batchName.startsWith("tck-")) {
				return new TCKJunitBatchTestClassGroup(
					batchName, buildProfile, portalTestClassJob);
			}

			return new DefaultBatchTestClassGroup(
				batchName, buildProfile, portalTestClassJob);
		}

		throw new IllegalArgumentException("Unknown test class group");
	}

}