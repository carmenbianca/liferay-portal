/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.query;

import com.liferay.portal.search.query.function.CombineFunction;

/**
 * @author Michael C. Han
 */
public class CombineFunctionTranslator {

	public org.elasticsearch.common.lucene.search.function.CombineFunction
		translate(CombineFunction combineFunction) {

		if (combineFunction == CombineFunction.AVG) {
			return org.elasticsearch.common.lucene.search.function.
				CombineFunction.AVG;
		}
		else if (combineFunction == CombineFunction.MAX) {
			return org.elasticsearch.common.lucene.search.function.
				CombineFunction.MAX;
		}
		else if (combineFunction == CombineFunction.MIN) {
			return org.elasticsearch.common.lucene.search.function.
				CombineFunction.MIN;
		}
		else if (combineFunction == CombineFunction.MULTIPLY) {
			return org.elasticsearch.common.lucene.search.function.
				CombineFunction.MULTIPLY;
		}
		else if (combineFunction == CombineFunction.REPLACE) {
			return org.elasticsearch.common.lucene.search.function.
				CombineFunction.REPLACE;
		}
		else if (combineFunction == CombineFunction.SUM) {
			return org.elasticsearch.common.lucene.search.function.
				CombineFunction.SUM;
		}

		throw new IllegalArgumentException(
			"Invalid CombineFunction: " + combineFunction);
	}

}