/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.data.partitioning.sql.builder.internal.command;

import java.io.IOException;

/**
 * @author Manuel de la Peña
 */
public interface ExportProcessCommand {

	public void export() throws IOException;

}