/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.query.function.score;

import com.liferay.portal.search.query.function.score.ScoreFunctionTranslator;
import com.liferay.portal.search.query.function.score.WeightScoreFunction;

/**
 * @author Michael C. Han
 * @author Wade Cao
 * @author André de Oliveira
 */
public class WeightScoreFunctionImpl
	extends ScoreFunctionImpl implements WeightScoreFunction {

	@Override
	public <T> T accept(ScoreFunctionTranslator<T> scoreFunctionTranslator) {
		return scoreFunctionTranslator.translate(this);
	}

}