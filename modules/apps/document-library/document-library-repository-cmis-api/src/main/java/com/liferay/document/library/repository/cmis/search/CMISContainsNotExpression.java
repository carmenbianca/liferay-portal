/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.repository.cmis.search;

import com.liferay.petra.string.StringPool;

/**
 * @author Mika Koivisto
 */
public class CMISContainsNotExpression implements CMISCriterion {

	public CMISContainsNotExpression(CMISCriterion cmisCriterion) {
		_cmisCriterion = cmisCriterion;
	}

	@Override
	public String toQueryFragment() {
		return StringPool.DASH.concat(_cmisCriterion.toQueryFragment());
	}

	private final CMISCriterion _cmisCriterion;

}