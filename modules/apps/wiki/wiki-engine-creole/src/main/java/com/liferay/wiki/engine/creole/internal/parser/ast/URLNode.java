/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.engine.creole.internal.parser.ast;

import com.liferay.wiki.configuration.WikiGroupServiceConfiguration;
import com.liferay.wiki.engine.creole.internal.util.WikiEngineCreoleComponentProvider;

/**
 * @author Miguel Pastor
 */
public abstract class URLNode extends ASTNode {

	public URLNode() {
		initSupportedProtocols();
	}

	public URLNode(int token) {
		super(token);

		initSupportedProtocols();
	}

	public URLNode(int token, String link) {
		super(token);

		_link = link;

		initSupportedProtocols();
	}

	public URLNode(String link) {
		_link = link;

		initSupportedProtocols();
	}

	public String getLink() {
		return _link;
	}

	public String[] getSupportedProtocols() {
		return _supportedProtocols;
	}

	public boolean isAbsoluteLink() {
		for (String supportedProtocol : getSupportedProtocols()) {
			if (_link.startsWith(supportedProtocol)) {
				return true;
			}
		}

		return false;
	}

	public void setLink(String link) {
		_link = link;
	}

	public void setSupportedProtocols(String[] supportedProtocols) {
		_supportedProtocols = supportedProtocols;
	}

	protected void initSupportedProtocols() {
		WikiEngineCreoleComponentProvider wikiEngineCreoleComponentProvider =
			WikiEngineCreoleComponentProvider.
				getWikiEngineCreoleComponentProvider();

		WikiGroupServiceConfiguration wikiGroupServiceConfiguration =
			wikiEngineCreoleComponentProvider.
				getWikiGroupServiceConfiguration();

		_supportedProtocols =
			wikiGroupServiceConfiguration.parsersCreoleSupportedProtocols();
	}

	private String _link;
	private String[] _supportedProtocols;

}