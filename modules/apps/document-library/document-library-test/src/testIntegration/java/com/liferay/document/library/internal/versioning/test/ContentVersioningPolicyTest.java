/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.internal.versioning.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.document.library.kernel.model.DLVersionNumberIncrease;
import com.liferay.document.library.versioning.VersioningPolicy;
import com.liferay.portal.kernel.security.RandomUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portlet.documentlibrary.model.impl.DLFileVersionImpl;

import java.util.Optional;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Adolfo Pérez
 */
@RunWith(Arquillian.class)
public class ContentVersioningPolicyTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Test
	public void testComponentIsAvailable() {
		Assert.assertNotNull(_versioningPolicy);
	}

	@Test(expected = NullPointerException.class)
	public void testFailsWithNullNextDLFileVersion() {
		_versioningPolicy.computeDLVersionNumberIncrease(
			new DLFileVersionImpl(), null);
	}

	@Test(expected = NullPointerException.class)
	public void testFailsWithNullPreviousDLFileVersion() {
		_versioningPolicy.computeDLVersionNumberIncrease(
			null, new DLFileVersionImpl());
	}

	@Test
	public void testMajorVersionWhenContentChanges() {
		DLFileVersionImpl previousDLFileVersionImpl = new DLFileVersionImpl();

		previousDLFileVersionImpl.setSize(RandomUtil.nextInt(100) + 1);
		previousDLFileVersionImpl.setChecksum(StringUtil.randomString(5));

		DLFileVersionImpl nextDLFileVersionImpl = new DLFileVersionImpl();

		nextDLFileVersionImpl.setSize(previousDLFileVersionImpl.getSize());
		nextDLFileVersionImpl.setChecksum(StringUtil.randomString(6));

		Optional<DLVersionNumberIncrease> dlVersionNumberIncreaseOptional =
			_versioningPolicy.computeDLVersionNumberIncrease(
				previousDLFileVersionImpl, nextDLFileVersionImpl);

		Assert.assertTrue(dlVersionNumberIncreaseOptional.isPresent());
		Assert.assertEquals(
			DLVersionNumberIncrease.MAJOR,
			dlVersionNumberIncreaseOptional.get());
	}

	@Test
	public void testMajorVersionWhenSizeChanges() {
		DLFileVersionImpl previousDLFileVersionImpl = new DLFileVersionImpl();

		previousDLFileVersionImpl.setSize(RandomUtil.nextInt(100) + 1);

		DLFileVersionImpl nextDLFileVersionImpl = new DLFileVersionImpl();

		nextDLFileVersionImpl.setSize(previousDLFileVersionImpl.getSize() + 1);

		Optional<DLVersionNumberIncrease> dlVersionNumberIncreaseOptional =
			_versioningPolicy.computeDLVersionNumberIncrease(
				previousDLFileVersionImpl, nextDLFileVersionImpl);

		Assert.assertTrue(dlVersionNumberIncreaseOptional.isPresent());
		Assert.assertEquals(
			DLVersionNumberIncrease.MAJOR,
			dlVersionNumberIncreaseOptional.get());
	}

	@Test
	public void testNoVersionIncreaseWhenContentDoesntChange() {
		DLFileVersionImpl previousDLFileVersionImpl = new DLFileVersionImpl();

		previousDLFileVersionImpl.setSize(RandomUtil.nextInt(100) + 1);
		previousDLFileVersionImpl.setChecksum(StringUtil.randomString(5));

		DLFileVersionImpl nextDLFileVersionImpl = new DLFileVersionImpl();

		nextDLFileVersionImpl.setSize(previousDLFileVersionImpl.getSize());
		nextDLFileVersionImpl.setChecksum(
			previousDLFileVersionImpl.getChecksum());

		Optional<DLVersionNumberIncrease> dlVersionNumberIncreaseOptional =
			_versioningPolicy.computeDLVersionNumberIncrease(
				previousDLFileVersionImpl, nextDLFileVersionImpl);

		Assert.assertFalse(dlVersionNumberIncreaseOptional.isPresent());
	}

	@Test
	public void testNoVersionIncreaseWhenPreviousEmptyAndNextNonempty() {
		DLFileVersionImpl previousDLFileVersionImpl = new DLFileVersionImpl();

		previousDLFileVersionImpl.setSize(0);

		DLFileVersionImpl nextDLFileVersionImpl = new DLFileVersionImpl();

		nextDLFileVersionImpl.setSize(RandomUtil.nextInt(100) + 1);

		Optional<DLVersionNumberIncrease> dlVersionNumberIncreaseOptional =
			_versioningPolicy.computeDLVersionNumberIncrease(
				previousDLFileVersionImpl, nextDLFileVersionImpl);

		Assert.assertFalse(dlVersionNumberIncreaseOptional.isPresent());
	}

	@Inject(filter = "component.name=*.ContentVersioningPolicy")
	private VersioningPolicy _versioningPolicy;

}