/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.json;

/**
 * @author Igor Spasic
 */
public interface JSONContext {

	public void write(String content);

	public void writeQuoted(String content);

}