/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.soy.builder.commands;

import java.io.File;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * @author Andrea Di Giorgi
 */
@RunWith(Parameterized.class)
public class ReplaceSoyTranslationCommandTest extends BaseSoyCommandTestCase {

	@Parameterized.Parameters(name = "{0}")
	public static String[] getTestDirNames() {
		return new String[] {"metal_cli", "metal_cli_2"};
	}

	public ReplaceSoyTranslationCommandTest(String testDirName) {
		_testDirName =
			"com/liferay/portal/tools/soy/builder/commands/dependencies" +
				"/replace_soy_translation/" + testDirName + "/";
	}

	@Override
	protected String getTestDirName() {
		return _testDirName;
	}

	@Override
	protected String[] getTestFileNames() {
		return new String[] {
			"footer.soy.js", "header.soy.js", "navigation.soy.js", "view.soy.js"
		};
	}

	@Override
	protected void testSoy(File dir) throws Exception {
		ReplaceSoyTranslationCommand replaceSoyTranslationCommand =
			new ReplaceSoyTranslationCommand();

		replaceSoyTranslationCommand.setDir(dir);

		replaceSoyTranslationCommand.execute();
	}

	private final String _testDirName;

}