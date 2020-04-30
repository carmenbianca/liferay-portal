/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.importer;

import java.io.File;

import java.util.List;

/**
 * @author Jorge Ferrer
 */
public interface FragmentsImporter {

	public List<String> importFile(
			long userId, long groupId, long fragmentCollectionId, File file,
			boolean overwrite)
		throws Exception;

}