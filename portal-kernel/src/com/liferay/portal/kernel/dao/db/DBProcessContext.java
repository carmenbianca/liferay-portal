/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.db;

import java.io.OutputStream;

/**
 * @author Carlos Sierra Andrés
 */
public interface DBProcessContext {

	public DBContext getDBContext();

	public OutputStream getOutputStream();

}