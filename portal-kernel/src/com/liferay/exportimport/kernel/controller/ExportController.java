/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.kernel.controller;

import com.liferay.exportimport.kernel.model.ExportImportConfiguration;

import java.io.File;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Daniel Kocsis
 */
@ProviderType
public interface ExportController extends ExportImportController {

	public File export(ExportImportConfiguration exportImportConfiguration)
		throws Exception;

}