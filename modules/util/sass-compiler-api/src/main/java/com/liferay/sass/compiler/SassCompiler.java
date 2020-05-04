/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sass.compiler;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author David Truong
 */
public interface SassCompiler extends Closeable {

	@Override
	public default void close() throws IOException {
	}

	public String compileFile(String inputFileName, String includeDirName)
		throws SassCompilerException;

	public String compileFile(
			String inputFileName, String includeDirName,
			boolean generateSourceMap)
		throws SassCompilerException;

	public String compileFile(
			String inputFileName, String includeDirName,
			boolean generateSourceMap, String sourceMapFileName)
		throws SassCompilerException;

	public String compileString(String input, String includeDirName)
		throws SassCompilerException;

	public String compileString(
			String input, String inputFileName, String includeDirName,
			boolean generateSourceMap)
		throws SassCompilerException;

	public String compileString(
			String input, String inputFileName, String includeDirName,
			boolean generateSourceMap, String sourceMapFileName)
		throws SassCompilerException;

}