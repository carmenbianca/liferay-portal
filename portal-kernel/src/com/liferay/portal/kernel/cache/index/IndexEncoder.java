/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.cache.index;

import java.io.Serializable;

/**
 * @author Preston Crary
 */
public interface IndexEncoder<I, K extends Serializable> {

	public I encode(K key);

}