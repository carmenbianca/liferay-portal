/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.batch.engine.internal.reader;

import java.io.Closeable;

import java.util.Map;

/**
 * @author Ivica Cardic
 */
public interface BatchEngineImportTaskItemReader extends Closeable {

	public Map<String, Object> read() throws Exception;

}