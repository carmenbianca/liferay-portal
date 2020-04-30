/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.validator;

import com.liferay.wiki.exception.PageTitleException;

/**
 * @author Roberto Díaz
 */
public interface WikiPageTitleValidator {

	public String normalize(String title);

	public void validate(String title) throws PageTitleException;

}