/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.service.persistence.impl;

import com.liferay.change.tracking.model.CTCollectionTable;
import com.liferay.change.tracking.model.CTProcess;
import com.liferay.change.tracking.model.CTProcessTable;
import com.liferay.change.tracking.model.impl.CTProcessImpl;
import com.liferay.change.tracking.service.persistence.CTProcessFinder;
import com.liferay.petra.sql.dsl.DSLFunctionFactoryUtil;
import com.liferay.petra.sql.dsl.DSLQueryFactoryUtil;
import com.liferay.petra.sql.dsl.expression.Predicate;
import com.liferay.petra.sql.dsl.query.LimitStep;
import com.liferay.portal.background.task.model.BackgroundTaskTable;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.WildcardMode;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Máté Thurzó
 */
@Component(service = CTProcessFinder.class)
public class CTProcessFinderImpl
	extends CTProcessFinderBaseImpl implements CTProcessFinder {

	@Override
	@SuppressWarnings("unchecked")
	public List<CTProcess> findByC_U_N_D_S(
		long companyId, long userId, String keywords, int status, int start,
		int end, OrderByComparator<?> orderByComparator) {

		Session session = null;

		try {
			session = openSession();

			Predicate predicate = CTProcessTable.INSTANCE.companyId.eq(
				companyId);

			if (userId > 0) {
				predicate = predicate.and(
					CTProcessTable.INSTANCE.userId.eq(userId));
			}

			if (status != WorkflowConstants.STATUS_ANY) {
				predicate = predicate.and(
					BackgroundTaskTable.INSTANCE.status.eq(status));
			}

			Predicate keywordsPredicate = null;

			for (String keyword :
					_customSQL.keywords(
						keywords, true, WildcardMode.SURROUND)) {

				if (keyword == null) {
					continue;
				}

				Predicate keywordPredicate = DSLFunctionFactoryUtil.lower(
					CTCollectionTable.INSTANCE.name
				).like(
					keyword
				).or(
					DSLFunctionFactoryUtil.lower(
						CTCollectionTable.INSTANCE.description
					).like(
						keyword
					)
				);

				if (keywordsPredicate == null) {
					keywordsPredicate = keywordPredicate;
				}
				else {
					keywordsPredicate = keywordsPredicate.or(keywordPredicate);
				}
			}

			if (keywordsPredicate != null) {
				predicate = predicate.and(keywordsPredicate.withParentheses());
			}

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(
				DSLQueryFactoryUtil.select(
					CTProcessTable.INSTANCE
				).from(
					CTProcessTable.INSTANCE
				).innerJoinON(
					CTCollectionTable.INSTANCE,
					CTCollectionTable.INSTANCE.ctCollectionId.eq(
						CTProcessTable.INSTANCE.ctCollectionId)
				).innerJoinON(
					BackgroundTaskTable.INSTANCE,
					BackgroundTaskTable.INSTANCE.backgroundTaskId.eq(
						CTProcessTable.INSTANCE.backgroundTaskId)
				).where(
					predicate
				).orderBy(
					orderByStep -> {
						if (orderByComparator != null) {
							LimitStep limitStep = orderByStep.orderBy(
								CTCollectionTable.INSTANCE, orderByComparator);

							if (limitStep == orderByStep) {
								return orderByStep.orderBy(
									CTProcessTable.INSTANCE, orderByComparator);
							}

							return limitStep;
						}

						return orderByStep.orderBy(
							CTProcessTable.INSTANCE.createDate.descending());
					}
				));

			sqlQuery.addEntity("CTProcess", CTProcessImpl.class);

			return (List<CTProcess>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Reference
	private CustomSQL _customSQL;

}