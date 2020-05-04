/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.service.persistence.impl;

import com.liferay.knowledge.base.model.KBArticle;
import com.liferay.knowledge.base.model.impl.KBArticleImpl;
import com.liferay.knowledge.base.service.persistence.KBArticleFinder;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Adolfo Pérez
 */
@Component(service = KBArticleFinder.class)
public class KBArticleFinderImpl
	extends KBArticleFinderBaseImpl implements KBArticleFinder {

	@Override
	public int countByUrlTitle(
		long groupId, String kbFolderUrlTitle, String kbArticleUrlTitle,
		int[] status) {

		Session session = null;

		try {
			session = openSession();

			String sql = _customSQL.get(
				KBArticleFinderImpl.class, _COUNT_BY_URL_TITLE);

			sql = replaceWorkflowStatus(sql, status);

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);
			queryPos.add(kbArticleUrlTitle);
			queryPos.add(kbFolderUrlTitle);

			Iterator<Long> itr = sqlQuery.iterate();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	public List<KBArticle> findByUrlTitle(
		long groupId, String kbFolderUrlTitle, String kbArticleUrlTitle,
		int[] status, int start, int end) {

		Session session = null;

		try {
			session = openSession();

			String sql = _customSQL.get(
				KBArticleFinderImpl.class, _FIND_BY_URL_TITLE);

			sql = replaceWorkflowStatus(sql, status);

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addEntity(KBArticleImpl.TABLE_NAME, KBArticleImpl.class);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);
			queryPos.add(kbArticleUrlTitle);
			queryPos.add(kbFolderUrlTitle);

			return (List)QueryUtil.list(sqlQuery, getDialect(), start, end);
		}
		finally {
			closeSession(session);
		}
	}

	protected String replaceWorkflowStatus(String sql, int[] status) {
		StringBundler sb = new StringBundler(status.length);

		for (int i = 0; i < status.length; i++) {
			sb.append(status[i]);

			if (i != (status.length - 1)) {
				sb.append(", ");
			}
		}

		return StringUtil.replace(sql, "[$WORKFLOW_STATUS$]", sb.toString());
	}

	private static final String _COUNT_BY_URL_TITLE =
		KBArticleFinder.class.getName() + ".countByUrlTitle";

	private static final String _FIND_BY_URL_TITLE =
		KBArticleFinder.class.getName() + ".findByUrlTitle";

	@Reference
	private CustomSQL _customSQL;

}