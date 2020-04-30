/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.io.exporter;

import com.liferay.dynamic.data.mapping.exception.FormInstanceRecordExporterException;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Leonardo Barros
 */
@ProviderType
public interface DDMFormInstanceRecordExporter {

	public DDMFormInstanceRecordExporterResponse export(
			DDMFormInstanceRecordExporterRequest
				ddmFormInstanceRecordExporterRequest)
		throws FormInstanceRecordExporterException;

}