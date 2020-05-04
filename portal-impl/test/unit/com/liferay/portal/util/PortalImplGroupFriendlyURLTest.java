/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sergio González
 */
public class PortalImplGroupFriendlyURLTest {

	@Test
	public void testGroupFriendlyURLIndexWithConflictiveLayoutFullURL1() {
		int[] groupFriendlyURLIndex = _portalImpl.getGroupFriendlyURLIndex(
			"/web/guest/web-content-page");

		Assert.assertEquals(4, groupFriendlyURLIndex[0]);
		Assert.assertEquals(10, groupFriendlyURLIndex[1]);
	}

	@Test
	public void testGroupFriendlyURLIndexWithConflictiveLayoutFullURL2() {
		int[] groupFriendlyURLIndex = _portalImpl.getGroupFriendlyURLIndex(
			"/web/guest/group-content-page");

		Assert.assertEquals(4, groupFriendlyURLIndex[0]);
		Assert.assertEquals(10, groupFriendlyURLIndex[1]);
	}

	@Test
	public void testGroupFriendlyURLIndexWithConflictiveLayoutFullURL3() {
		int[] groupFriendlyURLIndex = _portalImpl.getGroupFriendlyURLIndex(
			"/web/guest/user-content-page");

		Assert.assertEquals(4, groupFriendlyURLIndex[0]);
		Assert.assertEquals(10, groupFriendlyURLIndex[1]);
	}

	@Test
	public void testGroupFriendlyURLIndexWithConflictiveLayoutURL1() {
		int[] groupFriendlyURLIndex = _portalImpl.getGroupFriendlyURLIndex(
			"/web-content-page");

		Assert.assertNull(groupFriendlyURLIndex);
	}

	@Test
	public void testGroupFriendlyURLIndexWithConflictiveLayoutURL2() {
		int[] groupFriendlyURLIndex = _portalImpl.getGroupFriendlyURLIndex(
			"/group-content-page");

		Assert.assertNull(groupFriendlyURLIndex);
	}

	@Test
	public void testGroupFriendlyURLIndexWithConflictiveLayoutURL3() {
		int[] groupFriendlyURLIndex = _portalImpl.getGroupFriendlyURLIndex(
			"/user-content-page");

		Assert.assertNull(groupFriendlyURLIndex);
	}

	@Test
	public void testGroupFriendlyURLIndexWithFullLayoutURL() {
		int[] groupFriendlyURLIndex = _portalImpl.getGroupFriendlyURLIndex(
			"/web/guest/home");

		Assert.assertEquals(4, groupFriendlyURLIndex[0]);
		Assert.assertEquals(10, groupFriendlyURLIndex[1]);
	}

	@Test
	public void testGroupFriendlyURLIndexWithLayoutURL() {
		int[] groupFriendlyURLIndex = _portalImpl.getGroupFriendlyURLIndex(
			"/home");

		Assert.assertNull(groupFriendlyURLIndex);
	}

	private final PortalImpl _portalImpl = new PortalImpl();

}