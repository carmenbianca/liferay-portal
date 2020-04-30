/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.orm;

import java.sql.Connection;

/**
 * @author Brian Wing Shun Chan
 */
public interface SessionFactory {

	public void closeSession(Session session) throws ORMException;

	public Session getCurrentSession() throws ORMException;

	public Dialect getDialect() throws ORMException;

	public Session openNewSession(Connection connection) throws ORMException;

	public Session openSession() throws ORMException;

}