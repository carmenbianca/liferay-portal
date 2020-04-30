/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.repository.capabilities.util;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.portal.kernel.repository.model.FileEntry;

/**
 * @author Iván Zaera
 */
public class RepositoryEntryConverter {

	public DLFileEntry getDLFileEntry(FileEntry fileEntry) {
		Object model = fileEntry.getModel();

		if (model instanceof DLFileEntry) {
			return (DLFileEntry)model;
		}

		throw new IllegalArgumentException(
			"Invalid file entry model " + model.getClass());
	}

}