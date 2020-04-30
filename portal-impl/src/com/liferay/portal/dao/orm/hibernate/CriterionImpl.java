/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.orm.hibernate;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.orm.Criterion;

/**
 * @author Brian Wing Shun Chan
 */
public class CriterionImpl implements Criterion {

	public CriterionImpl(org.hibernate.criterion.Criterion criterion) {
		_criterion = criterion;
	}

	public org.hibernate.criterion.Criterion getWrappedCriterion() {
		return _criterion;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(3);

		sb.append("{_criterion=");
		sb.append(String.valueOf(_criterion));
		sb.append("}");

		return sb.toString();
	}

	private final org.hibernate.criterion.Criterion _criterion;

}