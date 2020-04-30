/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bookmarks.configuration;

/**
 * @author Iván Zaera
 */
public interface BookmarksGroupServiceConfigurationOverride {

	public String emailEntryAddedBodyXml();

	public String emailEntryAddedSubjectXml();

	public String emailEntryUpdatedBodyXml();

	public String emailEntryUpdatedSubjectXml();

	public long rootFolderId();

}