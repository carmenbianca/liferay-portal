/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.service.persistence.impl;

import com.liferay.change.tracking.constants.CTConstants;
import com.liferay.change.tracking.model.CTCollectionTable;
import com.liferay.change.tracking.model.CTEntryTable;
import com.liferay.change.tracking.service.persistence.CTEntryFinder;
import com.liferay.petra.sql.dsl.DSLQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Preston Crary
 */
@Component(service = CTEntryFinder.class)
public class CTEntryFinderImpl
	extends CTEntryFinderBaseImpl implements CTEntryFinder {

	@Override
	public long findByMCNI_MCPK_SD(
		long modelClassNameId, long modelClassPK, Date statusDate) {

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(
				DSLQueryFactoryUtil.select(
					CTEntryTable.INSTANCE.ctCollectionId
				).from(
					CTEntryTable.INSTANCE
				).innerJoinON(
					CTCollectionTable.INSTANCE,
					CTCollectionTable.INSTANCE.ctCollectionId.eq(
						CTEntryTable.INSTANCE.ctCollectionId
					).and(
						CTCollectionTable.INSTANCE.status.eq(
							WorkflowConstants.STATUS_APPROVED)
					)
				).where(
					CTEntryTable.INSTANCE.modelClassNameId.eq(
						modelClassNameId
					).and(
						CTEntryTable.INSTANCE.modelClassPK.eq(modelClassPK)
					).and(
						CTCollectionTable.INSTANCE.statusDate.gt(statusDate)
					)
				).orderBy(
					CTCollectionTable.INSTANCE.statusDate.ascending()
				));

			sqlQuery.addScalar(
				CTEntryTable.INSTANCE.ctCollectionId.getName(), Type.LONG);

			List<Long> ctCollectionIds = (List<Long>)QueryUtil.list(
				sqlQuery, getDialect(), 0, 1);

			if (ctCollectionIds.isEmpty()) {
				return CTConstants.CT_COLLECTION_ID_PRODUCTION;
			}

			return ctCollectionIds.get(0);
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
		finally {
			closeSession(session);
		}
	}

}