/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.yaml.config;

/**
 * @author Peter Shin
 */
public class Application {

	public String getBaseURI() {
		return _baseURI;
	}

	public String getClassName() {
		return _className;
	}

	public String getName() {
		return _name;
	}

	public Security getSecurity() {
		return _security;
	}

	public void setBaseURI(String baseURI) {
		_baseURI = baseURI;
	}

	public void setClassName(String className) {
		_className = className;
	}

	public void setName(String name) {
		_name = name;
	}

	public void setSecurity(Security security) {
		_security = security;
	}

	private String _baseURI;
	private String _className;
	private String _name;
	private Security _security;

}