/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.orm.hibernate;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.Junction;

/**
 * @author Raymond Augé
 */
public class DisjunctionImpl extends CriterionImpl implements Disjunction {

	public DisjunctionImpl(org.hibernate.criterion.Disjunction disjunction) {
		super(disjunction);

		_disjunction = disjunction;
	}

	@Override
	public Junction add(Criterion criterion) {
		CriterionImpl criterionImpl = (CriterionImpl)criterion;

		_disjunction.add(criterionImpl.getWrappedCriterion());

		return this;
	}

	public org.hibernate.criterion.Disjunction getWrappedDisjunction() {
		return _disjunction;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(3);

		sb.append("{_disjunction=");
		sb.append(String.valueOf(_disjunction));
		sb.append("}");

		return sb.toString();
	}

	private final org.hibernate.criterion.Disjunction _disjunction;

}