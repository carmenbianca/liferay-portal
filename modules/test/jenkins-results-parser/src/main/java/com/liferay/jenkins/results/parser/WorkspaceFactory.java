/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.lang.reflect.Proxy;

/**
 * @author Michael Hashimoto
 */
public abstract class WorkspaceFactory {

	public static Workspace newBatchWorkspace(
		String gitHubURL, String upstreamBranchName, String batchName,
		String branchSHA) {

		if (gitHubURL == null) {
			throw new RuntimeException("GitHub URL is null");
		}

		if (!BasePortalWorkspace.isPortalGitHubURL(gitHubURL)) {
			throw new RuntimeException("Unsupported GitHub URL " + gitHubURL);
		}

		if (batchName == null) {
			batchName = "default";
		}

		Workspace workspace = null;

		if (batchName.contains("functional")) {
			workspace = new FunctionalBatchPortalWorkspace(
				gitHubURL, upstreamBranchName, branchSHA);
		}
		else if (batchName.contains("integration") ||
				 batchName.contains("unit")) {

			workspace = new JunitBatchPortalWorkspace(
				gitHubURL, upstreamBranchName, branchSHA);
		}
		else {
			workspace = new BatchPortalWorkspace(
				gitHubURL, upstreamBranchName, branchSHA);
		}

		if (workspace == null) {
			throw new RuntimeException("Invalid workspace");
		}

		if (workspace instanceof PortalWorkspace) {
			return (PortalWorkspace)Proxy.newProxyInstance(
				PortalWorkspace.class.getClassLoader(),
				new Class<?>[] {PortalWorkspace.class},
				new MethodLogger(workspace));
		}

		return (Workspace)Proxy.newProxyInstance(
			Workspace.class.getClassLoader(), new Class<?>[] {Workspace.class},
			new MethodLogger(workspace));
	}

	public static Workspace newSimpleWorkspace() {
		Workspace workspace = new SimpleWorkspace();

		return (Workspace)Proxy.newProxyInstance(
			Workspace.class.getClassLoader(), new Class<?>[] {Workspace.class},
			new MethodLogger(workspace));
	}

	public static Workspace newTopLevelWorkspace(
		String gitHubURL, String upstreamBranchName) {

		if (gitHubURL == null) {
			throw new RuntimeException("GitHub URL is null");
		}

		if (!BasePortalWorkspace.isPortalGitHubURL(gitHubURL)) {
			throw new RuntimeException("Unsupported GitHub URL " + gitHubURL);
		}

		Workspace workspace = new TopLevelPortalWorkspace(
			gitHubURL, upstreamBranchName);

		if (workspace instanceof PortalWorkspace) {
			return (PortalWorkspace)Proxy.newProxyInstance(
				PortalWorkspace.class.getClassLoader(),
				new Class<?>[] {PortalWorkspace.class},
				new MethodLogger(workspace));
		}

		return (Workspace)Proxy.newProxyInstance(
			Workspace.class.getClassLoader(), new Class<?>[] {Workspace.class},
			new MethodLogger(workspace));
	}

}