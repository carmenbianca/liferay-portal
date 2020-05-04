/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bookmarks.web.internal.asset.model;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.bookmarks.model.BookmarksEntry;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.util.Props;
import com.liferay.portal.kernel.util.PropsUtil;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mockito;

/**
 * @author Adolfo Pérez
 */
public class BookmarksEntryAssetRendererTest {

	@Before
	public void setUp() {
		PropsUtil.setProps(Mockito.mock(Props.class));
	}

	@Test
	public void testHasViewPermissionReturnsFalseOnFailure() throws Exception {
		Mockito.when(
			_modelResourcePermission.contains(
				Mockito.any(PermissionChecker.class),
				Mockito.any(BookmarksEntry.class), Mockito.anyString())
		).thenThrow(
			new PrincipalException()
		);

		AssetRenderer<BookmarksEntry> assetRenderer =
			new BookmarksEntryAssetRenderer(
				_bookmarksEntry, _modelResourcePermission);

		Assert.assertFalse(assetRenderer.hasViewPermission(_permissionChecker));
	}

	@Test
	public void testHasViewPermissionReturnsFalseWhenUserDoesNotHavePermission()
		throws Exception {

		Mockito.when(
			_modelResourcePermission.contains(
				Mockito.any(PermissionChecker.class),
				Mockito.any(BookmarksEntry.class), Mockito.anyString())
		).thenReturn(
			false
		);

		AssetRenderer<BookmarksEntry> assetRenderer =
			new BookmarksEntryAssetRenderer(
				_bookmarksEntry, _modelResourcePermission);

		Assert.assertFalse(assetRenderer.hasViewPermission(_permissionChecker));
	}

	@Test
	public void testHasViewPermissionReturnsTrueWhenUserHasPermission()
		throws Exception {

		Mockito.when(
			_modelResourcePermission.contains(
				Mockito.any(PermissionChecker.class),
				Mockito.any(BookmarksEntry.class), Mockito.anyString())
		).thenReturn(
			true
		);

		AssetRenderer<BookmarksEntry> assetRenderer =
			new BookmarksEntryAssetRenderer(
				_bookmarksEntry, _modelResourcePermission);

		Assert.assertTrue(assetRenderer.hasViewPermission(_permissionChecker));
	}

	private final BookmarksEntry _bookmarksEntry = Mockito.mock(
		BookmarksEntry.class);
	private final ModelResourcePermission<BookmarksEntry>
		_modelResourcePermission = Mockito.mock(ModelResourcePermission.class);
	private final PermissionChecker _permissionChecker = Mockito.mock(
		PermissionChecker.class);

}