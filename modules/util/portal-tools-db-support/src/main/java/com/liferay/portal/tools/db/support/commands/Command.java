/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.db.support.commands;

import com.liferay.portal.tools.db.support.DBSupportArgs;

/**
 * @author Andrea Di Giorgi
 */
public interface Command {

	public void execute(DBSupportArgs dbSupportArgs) throws Exception;

}