/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search.suggest;

import com.liferay.portal.kernel.search.SearchException;

import java.util.List;
import java.util.Map;

/**
 * @author Daniela Zapata
 * @author David Gonzalez
 */
public interface Collator {

	public String collate(
			Map<String, List<String>> suggestionsMap, List<String> tokens)
		throws SearchException;

}