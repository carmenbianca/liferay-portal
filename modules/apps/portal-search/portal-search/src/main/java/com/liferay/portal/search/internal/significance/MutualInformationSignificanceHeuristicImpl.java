/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.significance;

import com.liferay.portal.search.significance.MutualInformationSignificanceHeuristic;

/**
 * @author Michael C. Han
 * @author André de Oliveira
 */
public class MutualInformationSignificanceHeuristicImpl
	implements MutualInformationSignificanceHeuristic {

	public MutualInformationSignificanceHeuristicImpl(
		boolean backgroundIsSuperset, boolean includeNegatives) {

		_backgroundIsSuperset = backgroundIsSuperset;
		_includeNegatives = includeNegatives;
	}

	@Override
	public boolean isBackgroundIsSuperset() {
		return _backgroundIsSuperset;
	}

	@Override
	public boolean isIncludeNegatives() {
		return _includeNegatives;
	}

	private final boolean _backgroundIsSuperset;
	private final boolean _includeNegatives;

}