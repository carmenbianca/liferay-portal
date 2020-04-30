/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser.test.clazz.group;

import com.liferay.jenkins.results.parser.PortalTestClassJob;

/**
 * @author Yi-Chen Tsai
 */
public class DefaultBatchTestClassGroup extends BatchTestClassGroup {

	@Override
	public int getAxisCount() {
		if (!isStableTestSuiteBatch() && testRelevantIntegrationUnitOnly) {
			return 0;
		}

		return super.getAxisCount();
	}

	protected DefaultBatchTestClassGroup(
		String batchName, BuildProfile buildProfile,
		PortalTestClassJob portalTestClassJob) {

		super(batchName, buildProfile, portalTestClassJob);

		addTestClass(
			BatchTestClass.getInstance(batchName, portalGitWorkingDirectory));

		setAxisTestClassGroups();
	}

}