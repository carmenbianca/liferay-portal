/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.repository.capabilities;

import java.util.UUID;

/**
 * @author Iván Zaera
 */
public class TemporaryFileEntriesScope {

	public TemporaryFileEntriesScope(
		UUID callerUuid, long userId, String folderPath) {

		_callerUuid = callerUuid;
		_userId = userId;
		_folderPath = folderPath;
	}

	public UUID getCallerUuid() {
		return _callerUuid;
	}

	public String getFolderPath() {
		return _folderPath;
	}

	public long getUserId() {
		return _userId;
	}

	private final UUID _callerUuid;
	private final String _folderPath;
	private final long _userId;

}