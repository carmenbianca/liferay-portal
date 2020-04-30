/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.sort;

import com.liferay.portal.search.script.Script;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface ScriptSort extends Sort {

	public NestedSort getNestedSort();

	public Script getScript();

	public ScriptSortType getScriptSortType();

	public SortMode getSortMode();

	public void setNestedSort(NestedSort nestedSort);

	public void setSortMode(SortMode sortMode);

	public enum ScriptSortType {

		NUMBER, STRING

	}

}