/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search.reindexer;

/**
 * @author André de Oliveira
 */
public interface ReindexerBridge {

	public void reindex(long companyId, String className, long... classPKs);

}