/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.lists.exporter;

import java.util.Set;

/**
 * @author Lance Ji
 */
public interface DDLExporterFactory {

	public Set<String> getAvailableFormats();

	public DDLExporter getDDLExporter(String format);

}