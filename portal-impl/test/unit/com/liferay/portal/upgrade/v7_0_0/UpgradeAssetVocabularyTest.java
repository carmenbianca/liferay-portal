/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.v7_0_0;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author José Manuel Navarro
 */
public class UpgradeAssetVocabularyTest {

	@Test
	public void testUpgradeWithEmptySettings() {
		testUpgrade(
			"multiValued=false\nselectedClassNameIds=0\n",
			"multiValued=false\nselectedClassNameIds=0:-1\n");
	}

	@Test
	public void testUpgradeWithMultipleRequiredSettings() {
		testUpgrade(
			"multiValued=true\nrequiredClassNameIds=10005\n" +
				"selectedClassNameIds=10007,10005,10109\n",
			"multiValued=true\nrequiredClassNameIds=10005:-1\n" +
				"selectedClassNameIds=10007:-1,10005:-1,10109:-1\n");
	}

	@Test
	public void testUpgradeWithMultiValuedSettings() {
		testUpgrade(
			"multiValued=true\nselectedClassNameIds=10007,10005\n",
			"multiValued=true\nselectedClassNameIds=10007:-1,10005:-1\n");
	}

	@Test
	public void testUpgradeWithoutRequiredSettings() {
		testUpgrade(
			"multiValued=false\nselectedClassNameIds=10007\n",
			"multiValued=false\nselectedClassNameIds=10007:-1\n");
	}

	@Test
	public void testUpgradeWithRequiredSettings() {
		testUpgrade(
			"multiValued=false\nrequiredClassNameIds=10007\n" +
				"selectedClassNameIds=10007\n",
			"multiValued=false\nrequiredClassNameIds=10007:-1\n" +
				"selectedClassNameIds=10007:-1\n");
	}

	protected void testUpgrade(
		String oldSettings, String expectedUpgradedSettings) {

		UpgradeAsset upgradeAsset = new UpgradeAsset();

		String actualUpgradedSettings = upgradeAsset.upgradeVocabularySettings(
			oldSettings);

		Assert.assertEquals(expectedUpgradedSettings, actualUpgradedSettings);
	}

}