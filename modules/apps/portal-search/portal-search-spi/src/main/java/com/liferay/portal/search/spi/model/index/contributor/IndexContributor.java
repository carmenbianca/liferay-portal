/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.spi.model.index.contributor;

/**
 * @author Adam Brandizzi
 */
public interface IndexContributor {

	public default void onAfterCreate(String indexName) {
	}

	public default void onBeforeRemove(String indexName) {
	}

}