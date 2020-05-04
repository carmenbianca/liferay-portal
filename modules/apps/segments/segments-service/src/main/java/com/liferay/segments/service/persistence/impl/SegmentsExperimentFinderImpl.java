/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.segments.model.SegmentsExperiment;
import com.liferay.segments.model.impl.SegmentsExperimentImpl;
import com.liferay.segments.service.persistence.SegmentsExperimentFinder;

import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo García
 */
@Component(service = SegmentsExperimentFinder.class)
public class SegmentsExperimentFinderImpl
	extends SegmentsExperimentFinderBaseImpl
	implements SegmentsExperimentFinder {

	public static final String COUNT_BY_S_C_C_S =
		SegmentsExperimentFinder.class.getName() + ".countByS_C_C_S";

	public static final String FIND_BY_S_C_C_S =
		SegmentsExperimentFinder.class.getName() + ".findByS_C_C_S";

	@Override
	public int countByS_C_C_S(
		long segmentsExperienceId, long classNameId, long classPK,
		int[] statuses) {

		Session session = null;

		try {
			session = openSession();

			String sql = _customSQL.get(getClass(), COUNT_BY_S_C_C_S);

			sql = StringUtil.replace(
				sql, "[$STATUSES$]", getStatusesSQL(statuses));

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(segmentsExperienceId);
			queryPos.add(classNameId);
			queryPos.add(classPK);

			Iterator<Long> itr = sqlQuery.iterate();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	public List<SegmentsExperiment> findByS_C_C_S(
		long segmentsExperienceId, long classNameId, long classPK,
		int[] statuses, int start, int end,
		OrderByComparator<SegmentsExperiment> orderByComparator) {

		Session session = null;

		try {
			session = openSession();

			String sql = _customSQL.get(getClass(), FIND_BY_S_C_C_S);

			sql = StringUtil.replace(
				sql, "[$STATUSES$]", getStatusesSQL(statuses));

			sql = _customSQL.replaceOrderBy(sql, orderByComparator);

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addEntity(
				"SegmentsExperiment", SegmentsExperimentImpl.class);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(segmentsExperienceId);
			queryPos.add(classNameId);
			queryPos.add(classPK);

			return (List<SegmentsExperiment>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected String getStatusesSQL(int[] statuses) {
		if (ArrayUtil.isEmpty(statuses)) {
			return StringPool.BLANK;
		}

		StringBundler sb = new StringBundler();

		sb.append("AND SegmentsExperiment.status IN ");
		sb.append(StringPool.OPEN_PARENTHESIS);

		for (int status : statuses) {
			sb.append(status);
			sb.append(StringPool.COMMA_AND_SPACE);
		}

		sb.setIndex(sb.index() - 1);

		sb.append(StringPool.CLOSE_PARENTHESIS);

		return sb.toString();
	}

	@Reference
	private CustomSQL _customSQL;

}