/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.test.util;

import com.liferay.portal.kernel.search.facet.collector.TermCollector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author André de Oliveira
 */
public class TermCollectorUtil {

	public static Map<String, Integer> toMap(
		List<TermCollector> termCollectors) {

		Map<String, Integer> map = new HashMap<>();

		for (TermCollector termCollector : termCollectors) {
			map.put(termCollector.getTerm(), termCollector.getFrequency());
		}

		return map;
	}

}