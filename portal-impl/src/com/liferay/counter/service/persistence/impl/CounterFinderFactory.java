/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.counter.service.persistence.impl;

import com.liferay.counter.kernel.service.persistence.CounterFinder;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.util.PropsValues;

import javax.sql.DataSource;

/**
 * @author Shuyang Zhou
 */
public class CounterFinderFactory {

	public static CounterFinder createCounterFinder(
		DataSource dataSource, SessionFactory sessionFactory) {

		CounterFinderImpl counterFinderImpl = null;

		if (PropsValues.COUNTER_DATA_CENTER_COUNT > 1) {
			counterFinderImpl = new MultiDataCenterCounterFinderImpl(
				PropsValues.COUNTER_DATA_CENTER_COUNT,
				PropsValues.COUNTER_DATA_CENTER_DEPLOYMENT_ID);
		}
		else {
			counterFinderImpl = new CounterFinderImpl();
		}

		counterFinderImpl.setDataSource(dataSource);
		counterFinderImpl.setSessionFactory(sessionFactory);

		return counterFinderImpl;
	}

}