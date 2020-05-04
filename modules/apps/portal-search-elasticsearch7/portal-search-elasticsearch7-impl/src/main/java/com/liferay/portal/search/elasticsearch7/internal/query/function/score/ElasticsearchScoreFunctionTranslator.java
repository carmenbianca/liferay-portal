/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.query.function.score;

import com.liferay.portal.search.elasticsearch7.internal.script.ScriptTranslator;
import com.liferay.portal.search.query.function.score.ExponentialDecayScoreFunction;
import com.liferay.portal.search.query.function.score.FieldValueFactorScoreFunction;
import com.liferay.portal.search.query.function.score.GaussianDecayScoreFunction;
import com.liferay.portal.search.query.function.score.LinearDecayScoreFunction;
import com.liferay.portal.search.query.function.score.RandomScoreFunction;
import com.liferay.portal.search.query.function.score.ScoreFunctionTranslator;
import com.liferay.portal.search.query.function.score.ScriptScoreFunction;
import com.liferay.portal.search.query.function.score.WeightScoreFunction;

import org.elasticsearch.index.query.functionscore.ExponentialDecayFunctionBuilder;
import org.elasticsearch.index.query.functionscore.FieldValueFactorFunctionBuilder;
import org.elasticsearch.index.query.functionscore.GaussDecayFunctionBuilder;
import org.elasticsearch.index.query.functionscore.LinearDecayFunctionBuilder;
import org.elasticsearch.index.query.functionscore.RandomScoreFunctionBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilder;
import org.elasticsearch.index.query.functionscore.ScriptScoreFunctionBuilder;
import org.elasticsearch.index.query.functionscore.WeightBuilder;

/**
 * @author Michael C. Han
 */
public class ElasticsearchScoreFunctionTranslator
	implements ScoreFunctionTranslator<ScoreFunctionBuilder<?>> {

	@Override
	public ScoreFunctionBuilder<?> translate(
		ExponentialDecayScoreFunction exponentialDecayScoreFunction) {

		if (exponentialDecayScoreFunction.getDecay() != null) {
			return new ExponentialDecayFunctionBuilder(
				exponentialDecayScoreFunction.getField(),
				exponentialDecayScoreFunction.getOrigin(),
				exponentialDecayScoreFunction.getScale(),
				exponentialDecayScoreFunction.getOffset(),
				exponentialDecayScoreFunction.getDecay());
		}

		return new ExponentialDecayFunctionBuilder(
			exponentialDecayScoreFunction.getField(),
			exponentialDecayScoreFunction.getOrigin(),
			exponentialDecayScoreFunction.getScale(),
			exponentialDecayScoreFunction.getOffset());
	}

	@Override
	public ScoreFunctionBuilder<?> translate(
		FieldValueFactorScoreFunction fieldValueFactorScoreFunction) {

		return new FieldValueFactorFunctionBuilder(
			fieldValueFactorScoreFunction.getField());
	}

	@Override
	public ScoreFunctionBuilder<?> translate(
		GaussianDecayScoreFunction gaussianDecayScoreFunction) {

		if (gaussianDecayScoreFunction.getDecay() != null) {
			return new GaussDecayFunctionBuilder(
				gaussianDecayScoreFunction.getField(),
				gaussianDecayScoreFunction.getOrigin(),
				gaussianDecayScoreFunction.getScale(),
				gaussianDecayScoreFunction.getOffset(),
				gaussianDecayScoreFunction.getDecay());
		}

		return new GaussDecayFunctionBuilder(
			gaussianDecayScoreFunction.getField(),
			gaussianDecayScoreFunction.getOrigin(),
			gaussianDecayScoreFunction.getScale(),
			gaussianDecayScoreFunction.getOffset());
	}

	@Override
	public ScoreFunctionBuilder<?> translate(
		LinearDecayScoreFunction linearDecayScoreFunction) {

		if (linearDecayScoreFunction.getDecay() != null) {
			return new LinearDecayFunctionBuilder(
				linearDecayScoreFunction.getField(),
				linearDecayScoreFunction.getOrigin(),
				linearDecayScoreFunction.getScale(),
				linearDecayScoreFunction.getOffset(),
				linearDecayScoreFunction.getDecay());
		}

		return new LinearDecayFunctionBuilder(
			linearDecayScoreFunction.getField(),
			linearDecayScoreFunction.getOrigin(),
			linearDecayScoreFunction.getScale(),
			linearDecayScoreFunction.getOffset());
	}

	@Override
	public ScoreFunctionBuilder<?> translate(
		RandomScoreFunction randomScoreFunction) {

		RandomScoreFunctionBuilder randomScoreFunctionBuilder =
			new RandomScoreFunctionBuilder();

		if (randomScoreFunction.getField() != null) {
			randomScoreFunctionBuilder.setField(randomScoreFunction.getField());
		}

		if (randomScoreFunction.getSeed() != null) {
			randomScoreFunctionBuilder.seed(randomScoreFunction.getSeed());
		}

		return randomScoreFunctionBuilder;
	}

	@Override
	public ScoreFunctionBuilder<?> translate(
		ScriptScoreFunction scriptScoreFunction) {

		return new ScriptScoreFunctionBuilder(
			_scriptTranslator.translate(scriptScoreFunction.getScript()));
	}

	@Override
	public ScoreFunctionBuilder<?> translate(
		WeightScoreFunction weightScoreFunction) {

		return new WeightBuilder();
	}

	private final ScriptTranslator _scriptTranslator = new ScriptTranslator();

}