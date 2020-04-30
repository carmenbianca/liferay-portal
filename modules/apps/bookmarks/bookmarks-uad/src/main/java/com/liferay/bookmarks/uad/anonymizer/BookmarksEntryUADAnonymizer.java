/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bookmarks.uad.anonymizer;

import com.liferay.user.associated.data.anonymizer.UADAnonymizer;

import org.osgi.service.component.annotations.Component;

/**
 * @author Noah Sherrill
 */
@Component(immediate = true, service = UADAnonymizer.class)
public class BookmarksEntryUADAnonymizer
	extends BaseBookmarksEntryUADAnonymizer {
}