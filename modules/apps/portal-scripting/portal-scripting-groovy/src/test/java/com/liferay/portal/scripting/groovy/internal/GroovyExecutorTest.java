/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.scripting.groovy.internal;

import com.liferay.portal.kernel.util.StringUtil;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Miguel Pastor
 */
public class GroovyExecutorTest {

	@Test
	public void testBindingInputVariables() throws Exception {
		_execute(
			Collections.singletonMap("variable", "string"),
			Collections.emptySet(), "binding-input");
	}

	@Test
	public void testRuntimeError() throws Exception {
		try {
			_execute(
				Collections.emptyMap(), Collections.emptySet(),
				"runtime-error");

			Assert.fail("Should throw RuntimeException");
		}
		catch (RuntimeException runtimeException) {
		}
	}

	@Test
	public void testSimpleScript() throws Exception {
		_execute(Collections.emptyMap(), Collections.emptySet(), "simple");
	}

	@Test
	public void testSyntaxError() throws Exception {
		try {
			_execute(
				Collections.emptyMap(), Collections.emptySet(), "syntax-error");

			Assert.fail("Should throw UnsupportedOperationException");
		}
		catch (UnsupportedOperationException unsupportedOperationException) {
		}
	}

	private Map<String, Object> _execute(
			Map<String, Object> inputObjects, Set<String> outputNames,
			String fileName)
		throws Exception {

		GroovyExecutor groovyExecutor = new GroovyExecutor();

		return groovyExecutor.eval(
			null, inputObjects, outputNames,
			StringUtil.read(
				getClass().getResourceAsStream(
					"dependencies/" + fileName + ".groovy")));
	}

}