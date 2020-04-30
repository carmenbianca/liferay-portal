/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.linkback;

/**
 * @author Matthew Tambara
 */
public interface LinkbackConsumer {

	public void addNewTrackback(long commentId, String url, String entryURL);

	public void verifyNewTrackbacks();

	public void verifyTrackback(long commentId, String url, String entryURL);

}