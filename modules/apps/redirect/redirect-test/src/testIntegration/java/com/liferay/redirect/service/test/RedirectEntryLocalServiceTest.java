/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.redirect.service.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.redirect.exception.DuplicateRedirectEntrySourceURLException;
import com.liferay.redirect.model.RedirectEntry;
import com.liferay.redirect.model.RedirectNotFoundEntry;
import com.liferay.redirect.service.RedirectEntryLocalService;
import com.liferay.redirect.service.RedirectNotFoundEntryLocalService;
import com.liferay.redirect.test.util.RedirectTestUtil;

import java.time.Instant;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Alejandro Tardín
 */
@RunWith(Arquillian.class)
public class RedirectEntryLocalServiceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Before
	public void setUp() throws Exception {
		_group = GroupTestUtil.addGroup();
	}

	@Test
	public void testAddRedirectEntryDeletesRedirectNotFoundEntry()
		throws Exception {

		_redirectNotFoundEntry =
			_redirectNotFoundEntryLocalService.addOrUpdateRedirectNotFoundEntry(
				_groupLocalService.getGroup(_group.getGroupId()), "sourceURL");

		_redirectEntry = _redirectEntryLocalService.addRedirectEntry(
			_group.getGroupId(), "destinationURL", null, false, "sourceURL",
			ServiceContextTestUtil.getServiceContext());

		Assert.assertNull(
			_redirectNotFoundEntryLocalService.fetchRedirectNotFoundEntry(
				_group.getGroupId(), "sourceURL"));
	}

	@Test(expected = DuplicateRedirectEntrySourceURLException.class)
	public void testAddRedirectEntryFailsWhenDuplicateSourceURL()
		throws Exception {

		_redirectEntry = _redirectEntryLocalService.addRedirectEntry(
			_group.getGroupId(), "destinationURL", null, false, "sourceURL",
			ServiceContextTestUtil.getServiceContext());

		_redirectEntryLocalService.addRedirectEntry(
			_group.getGroupId(), "destinationURL", null, false, "sourceURL",
			ServiceContextTestUtil.getServiceContext());
	}

	@Test(expected = DuplicateRedirectEntrySourceURLException.class)
	public void testAddRedirectEntryFailsWhenDuplicateSourceURLAndDifferentType()
		throws Exception {

		_redirectEntry = _redirectEntryLocalService.addRedirectEntry(
			_group.getGroupId(), "destinationURL", null, true, "sourceURL",
			ServiceContextTestUtil.getServiceContext());

		_redirectEntryLocalService.addRedirectEntry(
			_group.getGroupId(), "destinationURL", null, false, "sourceURL",
			ServiceContextTestUtil.getServiceContext());
	}

	@Test(expected = DuplicateRedirectEntrySourceURLException.class)
	public void testAddRedirectEntryFailsWhenDuplicateSourceURLAndExpirationDate()
		throws Exception {

		_redirectEntry = _redirectEntryLocalService.addRedirectEntry(
			_group.getGroupId(), "destinationURL", new Date(), true,
			"sourceURL", ServiceContextTestUtil.getServiceContext());

		_redirectEntryLocalService.addRedirectEntry(
			_group.getGroupId(), "destinationURL", new Date(), false,
			"sourceURL", ServiceContextTestUtil.getServiceContext());
	}

	@Test
	public void testFetchExpiredRedirectEntry() throws Exception {
		Instant instant = Instant.now();

		_redirectEntry = _redirectEntryLocalService.addRedirectEntry(
			_group.getGroupId(), "destinationURL",
			Date.from(instant.minusSeconds(3600)), false, "sourceURL",
			ServiceContextTestUtil.getServiceContext());

		Assert.assertNull(
			_redirectEntryLocalService.fetchRedirectEntry(
				_group.getGroupId(), "sourceURL"));
	}

	@Test
	public void testFetchNotExpiredRedirectEntry() throws Exception {
		Instant instant = Instant.now();

		_redirectEntry = _redirectEntryLocalService.addRedirectEntry(
			_group.getGroupId(), "destinationURL",
			Date.from(instant.plusSeconds(3600)), false, "sourceURL",
			ServiceContextTestUtil.getServiceContext());

		Assert.assertEquals(
			_redirectEntry,
			_redirectEntryLocalService.fetchRedirectEntry(
				_group.getGroupId(), "sourceURL"));
	}

	@Test
	public void testFetchRedirectEntry() throws Exception {
		_redirectEntry = _redirectEntryLocalService.addRedirectEntry(
			_group.getGroupId(), "destinationURL", null, false, "sourceURL",
			ServiceContextTestUtil.getServiceContext());

		Assert.assertEquals(
			_redirectEntry,
			_redirectEntryLocalService.fetchRedirectEntry(
				_group.getGroupId(), "sourceURL"));
	}

	@Test
	public void testFetchRedirectEntryDoesNotUpdateTheLastOccurrenceDate()
		throws Exception {

		_redirectEntry = _redirectEntryLocalService.addRedirectEntry(
			_group.getGroupId(), "destinationURL", null, false, "sourceURL",
			ServiceContextTestUtil.getServiceContext());

		Assert.assertNull(_redirectEntry.getLastOccurrenceDate());

		_redirectEntry = _redirectEntryLocalService.fetchRedirectEntry(
			_group.getGroupId(), "sourceURL");

		Assert.assertNull(_redirectEntry.getLastOccurrenceDate());
	}

	@Test
	public void testFetchRedirectEntryUpdatesTheLastOccurrenceDate()
		throws Exception {

		_redirectEntry = _redirectEntryLocalService.addRedirectEntry(
			_group.getGroupId(), "destinationURL", null, false, "sourceURL",
			ServiceContextTestUtil.getServiceContext());

		Assert.assertNull(_redirectEntry.getLastOccurrenceDate());

		_redirectEntry = _redirectEntryLocalService.fetchRedirectEntry(
			_group.getGroupId(), "sourceURL", true);

		Date lastOccurrenceDate = _redirectEntry.getLastOccurrenceDate();

		Assert.assertTrue(lastOccurrenceDate.before(DateUtil.newDate()));
	}

	@Test
	public void testFetchRedirectEntryUpdatesTheLastOccurrenceDateOnceADay()
		throws Exception {

		_redirectEntry = _redirectEntryLocalService.addRedirectEntry(
			_group.getGroupId(), "destinationURL", null, false, "sourceURL",
			ServiceContextTestUtil.getServiceContext());

		Assert.assertNull(_redirectEntry.getLastOccurrenceDate());

		_redirectEntry = _redirectEntryLocalService.fetchRedirectEntry(
			_group.getGroupId(), "sourceURL", true);

		Date lastOccurrenceDate = _redirectEntry.getLastOccurrenceDate();

		_redirectEntry = _redirectEntryLocalService.fetchRedirectEntry(
			_group.getGroupId(), "sourceURL", true);

		Assert.assertEquals(
			lastOccurrenceDate, _redirectEntry.getLastOccurrenceDate());
	}

	@Test
	public void testFetchRedirectEntryWhenDisabled() throws Exception {
		RedirectTestUtil.withRedirectDisabled(
			() -> {
				_redirectEntry = _redirectEntryLocalService.addRedirectEntry(
					_group.getGroupId(), "destinationURL", null, false,
					"sourceURL", ServiceContextTestUtil.getServiceContext());

				Assert.assertNull(
					_redirectEntryLocalService.fetchRedirectEntry(
						_group.getGroupId(), "sourceURL"));
			});
	}

	@DeleteAfterTestRun
	private Group _group;

	@Inject
	private GroupLocalService _groupLocalService;

	@DeleteAfterTestRun
	private RedirectEntry _redirectEntry;

	@Inject
	private RedirectEntryLocalService _redirectEntryLocalService;

	@DeleteAfterTestRun
	private RedirectNotFoundEntry _redirectNotFoundEntry;

	@Inject
	private RedirectNotFoundEntryLocalService
		_redirectNotFoundEntryLocalService;

}