/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.display.context;

/**
 * @author André de Oliveira
 */
public interface IndexSearchPropsValues {

	public int getCollatedSpellCheckResultScoresThreshold();

	public int getQueryIndexingThreshold();

	public int getQuerySuggestionMax();

	public int getQuerySuggestionScoresThreshold();

	public boolean isCollatedSpellCheckResultEnabled();

	public boolean isQueryIndexingEnabled();

	public boolean isQuerySuggestionEnabled();

}