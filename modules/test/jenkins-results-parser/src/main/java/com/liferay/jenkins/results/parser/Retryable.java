/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Kenji Heigel
 */
public abstract class Retryable<T> {

	public Retryable() {
		this(5, 30, true);
	}

	public Retryable(
		boolean exceptionOnFail, int maxRetries, int retryPeriod,
		boolean verbose) {

		_exceptionOnFail = exceptionOnFail;
		_maxRetries = maxRetries;
		_retryPeriod = retryPeriod;
		_verbose = verbose;
	}

	public Retryable(int maxRetries, int retryPeriod, boolean verbose) {
		this(true, maxRetries, retryPeriod, verbose);
	}

	public abstract T execute();

	public final T executeWithRetries() {
		int retryCount = 0;

		while (true) {
			try {
				return execute();
			}
			catch (Exception exception) {
				retryCount++;

				if (_verbose) {
					System.out.println("An error has occurred: " + exception);
				}

				if ((_maxRetries >= 0) && (retryCount > _maxRetries)) {
					if (_exceptionOnFail) {
						throw exception;
					}

					return null;
				}

				sleep(_retryPeriod * 1000);

				if (_verbose) {
					System.out.println(
						"Retry attempt " + retryCount + " of " + _maxRetries);
				}
			}
		}
	}

	public void sleep(long duration) {
		try {
			Thread.sleep(duration);
		}
		catch (InterruptedException interruptedException) {
			throw new RuntimeException(interruptedException);
		}
	}

	private boolean _exceptionOnFail;
	private int _maxRetries;
	private int _retryPeriod;
	private boolean _verbose;

}