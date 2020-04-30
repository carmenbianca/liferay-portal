/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.process;

import java.io.InputStream;

/**
 * @author Shuyang Zhou
 */
public interface OutputProcessor<O, E> {

	public E processStdErr(InputStream stdErrInputStream)
		throws ProcessException;

	public O processStdOut(InputStream stdOutInputStream)
		throws ProcessException;

}