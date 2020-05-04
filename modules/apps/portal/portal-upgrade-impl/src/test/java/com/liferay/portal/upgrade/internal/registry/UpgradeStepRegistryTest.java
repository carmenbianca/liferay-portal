/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.internal.registry;

import com.liferay.portal.kernel.dao.db.DBProcessContext;
import com.liferay.portal.kernel.upgrade.UpgradeStep;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import org.osgi.framework.Version;

/**
 * @author Carlos Sierra Andrés
 */
public class UpgradeStepRegistryTest {

	@Test
	public void testCreateUpgradeInfos() {
		UpgradeStepRegistry upgradeStepRegistry = new UpgradeStepRegistry(0);

		TestUpgradeStep testUpgradeStep = new TestUpgradeStep();

		upgradeStepRegistry.register(
			"0.0.0", "1.0.0", testUpgradeStep, testUpgradeStep, testUpgradeStep,
			testUpgradeStep);

		List<UpgradeInfo> upgradeInfos = upgradeStepRegistry.getUpgradeInfos();

		Assert.assertEquals(upgradeInfos.toString(), 4, upgradeInfos.size());
		Assert.assertEquals(
			Arrays.asList(
				new UpgradeInfo("0.0.0", "1.0.0.step-3", 0, testUpgradeStep),
				new UpgradeInfo(
					"1.0.0.step-3", "1.0.0.step-2", 0, testUpgradeStep),
				new UpgradeInfo(
					"1.0.0.step-2", "1.0.0.step-1", 0, testUpgradeStep),
				new UpgradeInfo("1.0.0.step-1", "1.0.0", 0, testUpgradeStep)),
			upgradeInfos);

		for (UpgradeInfo upgradeInfo : upgradeInfos) {
			new Version(upgradeInfo.getFromSchemaVersionString());
			new Version(upgradeInfo.getToSchemaVersionString());
		}
	}

	@Test
	public void testCreateUpgradeInfosWithNoSteps() {
		UpgradeStepRegistry upgradeStepRegistry = new UpgradeStepRegistry(0);

		upgradeStepRegistry.register("0.0.0", "1.0.0");

		List<UpgradeInfo> upgradeInfos = upgradeStepRegistry.getUpgradeInfos();

		Assert.assertTrue(upgradeInfos.toString(), upgradeInfos.isEmpty());
	}

	@Test
	public void testCreateUpgradeInfosWithOneStep() {
		UpgradeStepRegistry upgradeStepRegistry = new UpgradeStepRegistry(0);

		TestUpgradeStep testUpgradeStep = new TestUpgradeStep();

		upgradeStepRegistry.register("0.0.0", "1.0.0", testUpgradeStep);

		List<UpgradeInfo> upgradeInfos = upgradeStepRegistry.getUpgradeInfos();

		Assert.assertEquals(upgradeInfos.toString(), 1, upgradeInfos.size());
		Assert.assertEquals(
			new UpgradeInfo("0.0.0", "1.0.0", 0, testUpgradeStep),
			upgradeInfos.get(0));
	}

	private static class TestUpgradeStep implements UpgradeStep {

		@Override
		public void upgrade(DBProcessContext dbProcessContext) {
		}

	}

}