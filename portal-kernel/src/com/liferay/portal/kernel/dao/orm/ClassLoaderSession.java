/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.orm;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.sql.dsl.query.DSLQuery;

import java.io.Serializable;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author     Shuyang Zhou
 * @author     Brian Wing Shun Chan
 * @deprecated As of Mueller (7.2.x), with no direct replacement
 */
@Deprecated
public class ClassLoaderSession implements Session {

	public ClassLoaderSession(Session session, ClassLoader classLoader) {
		_session = session;
		_classLoader = classLoader;
	}

	@Override
	public void apply(UnsafeConsumer<Connection, SQLException> unsafeConsumer)
		throws ORMException {

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(_classLoader);
			}

			_session.apply(unsafeConsumer);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public void clear() throws ORMException {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(_classLoader);
			}

			_session.clear();
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public Connection close() throws ORMException {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(_classLoader);
			}

			return _session.close();
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public boolean contains(Object object) throws ORMException {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(_classLoader);
			}

			return _session.contains(object);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public Query createQuery(String queryString) throws ORMException {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(_classLoader);
			}

			return _session.createQuery(queryString);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public Query createQuery(String queryString, boolean strictName)
		throws ORMException {

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(_classLoader);
			}

			return _session.createQuery(queryString, strictName);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public SQLQuery createSQLQuery(String queryString) throws ORMException {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(_classLoader);
			}

			return _session.createSQLQuery(queryString);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public SQLQuery createSQLQuery(String queryString, boolean strictName)
		throws ORMException {

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(_classLoader);
			}

			return _session.createSQLQuery(queryString, strictName);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public SQLQuery createSynchronizedSQLQuery(DSLQuery dslQuery)
		throws ORMException {

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(_classLoader);
			}

			return _session.createSynchronizedSQLQuery(dslQuery);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public SQLQuery createSynchronizedSQLQuery(String queryString)
		throws ORMException {

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(_classLoader);
			}

			return _session.createSynchronizedSQLQuery(queryString);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public SQLQuery createSynchronizedSQLQuery(
			String queryString, boolean strictName)
		throws ORMException {

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(_classLoader);
			}

			return _session.createSynchronizedSQLQuery(queryString, strictName);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public void delete(Object object) throws ORMException {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(_classLoader);
			}

			_session.delete(object);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public void evict(Object object) throws ORMException {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(_classLoader);
			}

			_session.evict(object);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public void flush() throws ORMException {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(_classLoader);
			}

			_session.flush();
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public Object get(Class<?> clazz, Serializable id) throws ORMException {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(_classLoader);
			}

			return _session.get(clazz, id);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public Object get(Class<?> clazz, Serializable id, LockMode lockMode)
		throws ORMException {

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(_classLoader);
			}

			return _session.get(clazz, id, lockMode);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public Object getWrappedSession() throws ORMException {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(_classLoader);
			}

			return _session.getWrappedSession();
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public boolean isDirty() throws ORMException {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(_classLoader);
			}

			return _session.isDirty();
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public Object load(Class<?> clazz, Serializable id) throws ORMException {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(_classLoader);
			}

			return _session.load(clazz, id);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public Object merge(Object object) throws ORMException {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(_classLoader);
			}

			return _session.merge(object);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public Serializable save(Object object) throws ORMException {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(_classLoader);
			}

			return _session.save(object);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public void saveOrUpdate(Object object) throws ORMException {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(_classLoader);
			}

			_session.saveOrUpdate(object);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	private final ClassLoader _classLoader;
	private final Session _session;

}