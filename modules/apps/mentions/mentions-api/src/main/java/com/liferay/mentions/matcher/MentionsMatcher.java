/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mentions.matcher;

/**
 * @author Adolfo Pérez
 */
public interface MentionsMatcher {

	public Iterable<String> match(String s);

}