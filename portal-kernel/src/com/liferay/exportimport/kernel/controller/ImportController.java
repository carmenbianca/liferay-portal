/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.kernel.controller;

import com.liferay.exportimport.kernel.lar.MissingReferences;
import com.liferay.exportimport.kernel.model.ExportImportConfiguration;

import java.io.File;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Daniel Kocsis
 */
@ProviderType
public interface ImportController extends ExportImportController {

	public void importDataDeletions(
			ExportImportConfiguration exportImportConfiguration, File file)
		throws Exception;

	public void importFile(
			ExportImportConfiguration exportImportConfiguration, File file)
		throws Exception;

	public MissingReferences validateFile(
			ExportImportConfiguration exportImportConfiguration, File file)
		throws Exception;

}