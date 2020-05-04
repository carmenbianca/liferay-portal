/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.example.sample;

import java.io.File;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.logging.Log;

/**
 * Prints a message.
 *
 * @author Andrea Di Giorgi
 * @goal hello-world
 */
public class HelloWorldMojo extends AbstractMojo {

	@Override
	public void execute() {
		Log log = getLog();

		if (log.isInfoEnabled()) {
			String message = _message;

			if (_upperCase) {
				message = message.toUpperCase();
			}

			log.info("Message from " + baseDir + ": " + message);
		}
	}

	/**
	 * The message to print.
	 *
	 * @parameter
	 */
	public void setMessage(String message) {
		_message = message;
	}

	/**
	 * @parameter
	 */
	public void setUpperCase(boolean upperCase) {
		_upperCase = upperCase;
	}

	/**
	 * @parameter default-value="${project.basedir}
	 * @readonly
	 */
	protected File baseDir;

	private String _message = "Hello, World!";
	private boolean _upperCase;

}