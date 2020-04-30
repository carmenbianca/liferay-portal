/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.chat.util;

import java.util.List;

/**
 * @author Ankit Srivastava
 */
public interface BuddyFinder {

	public List<Object[]> getBuddies(long companyId, long userId);

}