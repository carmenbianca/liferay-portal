/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.chat.service.persistence.impl;

import com.liferay.chat.model.Entry;
import com.liferay.chat.model.EntryConstants;
import com.liferay.chat.model.impl.EntryImpl;
import com.liferay.chat.service.persistence.EntryFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(service = EntryFinder.class)
public class EntryFinderImpl
	extends EntryFinderBaseImpl implements EntryFinder {

	public static final String FIND_BY_EMPTY_CONTENT =
		EntryFinder.class.getName() + ".findByEmptyContent";

	public static final String FIND_BY_NEW =
		EntryFinder.class.getName() + ".findByNew";

	public static final String FIND_BY_OLD =
		EntryFinder.class.getName() + ".findByOld";

	@Override
	public List<Entry> findByEmptyContent(
		long fromUserId, long toUserId, int start, int end) {

		Session session = null;

		try {
			session = openSession();

			String sql = _customSQL.get(getClass(), FIND_BY_EMPTY_CONTENT);

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addEntity("Chat_Entry", EntryImpl.class);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(fromUserId);
			queryPos.add(toUserId);

			return (List<Entry>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	public List<Entry> findByNew(
		long userId, long createDate, int start, int end) {

		Session session = null;

		try {
			session = openSession();

			String sql = _customSQL.get(getClass(), FIND_BY_NEW);

			if (createDate > 0) {
				sql = StringUtil.replace(sql, _FLAG_SQL, _CREATE_DATE_SQL);
			}

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addEntity("Chat_Entry", EntryImpl.class);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(userId);
			queryPos.add(userId);

			if (createDate > 0) {
				queryPos.add(createDate);
			}
			else {
				queryPos.add(EntryConstants.FLAG_UNREAD);
			}

			return (List<Entry>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	public List<Entry> findByOld(long createDate, int start, int end) {
		Session session = null;

		try {
			session = openSession();

			String sql = _customSQL.get(getClass(), FIND_BY_OLD);

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addEntity("Chat_Entry", EntryImpl.class);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(createDate);

			return (List<Entry>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _CREATE_DATE_SQL = "(createDate > ?)";

	private static final String _FLAG_SQL = "(flag = ?)";

	@Reference
	private CustomSQL _customSQL;

}