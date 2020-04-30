/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.batch.engine.internal.writer;

import java.io.Closeable;

import java.util.Collection;

/**
 * @author Ivica Cardic
 */
public interface BatchEngineExportTaskItemWriter extends Closeable {

	public void write(Collection<?> items) throws Exception;

}