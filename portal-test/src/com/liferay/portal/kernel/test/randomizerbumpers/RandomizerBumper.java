/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.test.randomizerbumpers;

/**
 * @author Shuyang Zhou
 */
public interface RandomizerBumper<T> {

	public boolean accept(T randomValue);

}