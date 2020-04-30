/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.repository.cmis.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mika Koivisto
 */
public abstract class CMISJunction implements CMISCriterion {

	public CMISJunction() {
		_cmisCriterions = new ArrayList<>();
	}

	public void add(CMISCriterion cmisCriterion) {
		_cmisCriterions.add(cmisCriterion);
	}

	public boolean isEmpty() {
		return _cmisCriterions.isEmpty();
	}

	public List<CMISCriterion> list() {
		return _cmisCriterions;
	}

	@Override
	public abstract String toQueryFragment();

	private final List<CMISCriterion> _cmisCriterions;

}