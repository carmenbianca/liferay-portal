/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.synonym;

/**
 * @author Adam Brandizzi
 */
public class SynonymException extends Exception {

	public SynonymException(Exception exception) {
		super(exception);
	}

}