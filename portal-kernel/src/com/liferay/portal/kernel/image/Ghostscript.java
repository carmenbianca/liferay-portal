/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.image;

import java.util.List;
import java.util.concurrent.Future;

/**
 * @author Ivica Cardic
 */
public interface Ghostscript {

	public Future<?> execute(List<String> arguments) throws Exception;

	public boolean isEnabled();

	public void reset();

}