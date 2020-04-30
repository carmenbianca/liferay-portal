/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Michael Hashimoto
 */
public abstract class BaseTestBatch
	<T extends BatchBuildData, S extends Workspace>
		implements TestBatch<T, S> {

	public JDK getJDK() {
		return _jdk;
	}

	@Override
	public void run() {
		try {
			executeBatch();
		}
		catch (AntException antException) {
			throw new RuntimeException(antException);
		}
		finally {
			publishResults();
		}
	}

	protected BaseTestBatch(T batchBuildData, S workspace) {
		_batchBuildData = batchBuildData;
		_jdk = JDKFactory.getJDK(batchBuildData.getBatchName());
		_workspace = workspace;
	}

	protected abstract void executeBatch() throws AntException;

	protected String getAntOpts(String batchName) {
		return _jdk.getAntOpts();
	}

	protected T getBatchBuildData() {
		return _batchBuildData;
	}

	protected String getJavaHome(String batchName) {
		return _jdk.getJavaHome();
	}

	protected String getPath(String batchName) {
		String path = System.getenv("PATH");

		return path.replaceAll("jdk", _jdk.getName());
	}

	protected S getWorkspace() {
		return _workspace;
	}

	protected abstract void publishResults();

	private final T _batchBuildData;
	private final JDK _jdk;
	private final S _workspace;

}