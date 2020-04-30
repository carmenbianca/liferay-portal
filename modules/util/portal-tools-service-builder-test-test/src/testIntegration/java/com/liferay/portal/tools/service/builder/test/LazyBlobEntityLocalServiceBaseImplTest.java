/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.service.builder.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.tools.service.builder.test.model.LazyBlobEntity;
import com.liferay.portal.tools.service.builder.test.service.LazyBlobEntityLocalService;

import java.io.InputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Kyle Miho
 */
@RunWith(Arquillian.class)
public class LazyBlobEntityLocalServiceBaseImplTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Before
	public void setUp() throws Exception {
		_group = GroupTestUtil.addGroup();
	}

	@Test
	public void testEmptyBlobReturnsEmptyInputStream() throws Exception {
		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(_group.getGroupId());

		LazyBlobEntity lazyBlobEntity =
			_lazyBlobEntityLocalService.addLazyBlobEntity(
				_group.getGroupId(), new byte[0], serviceContext);

		InputStream inputStream =
			_lazyBlobEntityLocalService.openBlob1InputStream(
				lazyBlobEntity.getLazyBlobEntityId());

		Assert.assertEquals(0, inputStream.available());
	}

	@Test
	public void testOpenBlobInputStream() throws Exception {
		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(_group.getGroupId());

		LazyBlobEntity lazyBlobEntity =
			_lazyBlobEntityLocalService.addLazyBlobEntity(
				_group.getGroupId(), _BYTES, serviceContext);

		InputStream inputStream =
			_lazyBlobEntityLocalService.openBlob1InputStream(
				lazyBlobEntity.getLazyBlobEntityId());

		Assert.assertEquals(_BYTE_SIZE, inputStream.available());
	}

	@Test(expected = SystemException.class)
	public void testOpenBlobInputStreamWithInvalidBlobEntityId() {
		_lazyBlobEntityLocalService.openBlob1InputStream(
			RandomTestUtil.randomLong());
	}

	private static final int _BYTE_SIZE = 10;

	private static final byte[] _BYTES = new byte[_BYTE_SIZE];

	static {
		for (int i = 0; i < 10; i++) {
			_BYTES[i] = (byte)i;
		}
	}

	@DeleteAfterTestRun
	private Group _group;

	@Inject
	private LazyBlobEntityLocalService _lazyBlobEntityLocalService;

}