/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checkstyle.checks;

import com.liferay.portal.kernel.util.ListUtil;

import java.util.List;

/**
 * @author Hugo Huijser
 */
public class MapBuilderCheck extends BaseBuilderCheck {

	protected boolean allowNullValues() {
		return false;
	}

	protected List<BaseBuilderCheck.BuilderInformation>
		getBuilderInformationList() {

		return ListUtil.fromArray(
			new BaseBuilderCheck.BuilderInformation(
				"ConcurrentHashMap", "ConcurrentHashMapBuilder", "put",
				"putAll"),
			new BaseBuilderCheck.BuilderInformation(
				"HashMap", "HashMapBuilder", "put", "putAll"),
			new BaseBuilderCheck.BuilderInformation(
				"LinkedHashMap", "LinkedHashMapBuilder", "put", "putAll"),
			new BaseBuilderCheck.BuilderInformation(
				"TreeMap", "TreeMapBuilder", "put", "putAll"));
	}

	protected boolean isSupportsNestedMethodCalls() {
		return true;
	}

}