/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.query.function.score;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 * @author Wade Cao
 * @author André de Oliveira
 */
@ProviderType
public interface WeightScoreFunction extends ScoreFunction {

	@Override
	public <T> T accept(ScoreFunctionTranslator<T> scoreFunctionTranslator);

}