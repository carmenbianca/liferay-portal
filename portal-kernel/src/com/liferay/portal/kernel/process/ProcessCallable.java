/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.process;

import java.io.Serializable;

/**
 * @author Shuyang Zhou
 */
public interface ProcessCallable<T extends Serializable> extends Serializable {

	public T call() throws ProcessException;

}