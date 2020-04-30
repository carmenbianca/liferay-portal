/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.suggest;

/**
 * @author André de Oliveira
 */
public interface DictionaryVisitor {

	public void visitDictionaryEntry(DictionaryEntry dictionaryEntry);

}