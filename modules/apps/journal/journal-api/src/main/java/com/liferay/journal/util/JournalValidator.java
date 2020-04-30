/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.util;

import com.liferay.journal.exception.FolderNameException;

/**
 * @author David Zhang
 */
public interface JournalValidator {

	public boolean isValidName(String name);

	public void validateFolderName(String folderName)
		throws FolderNameException;

}