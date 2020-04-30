/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.yaml.openapi;

/**
 * @author Peter Shin
 */
public class Info {

	public String getDescription() {
		return _description;
	}

	public License getLicense() {
		return _license;
	}

	public String getTitle() {
		return _title;
	}

	public String getVersion() {
		return _version;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public void setLicense(License license) {
		_license = license;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public void setVersion(String version) {
		_version = version;
	}

	private String _description;
	private License _license;
	private String _title;
	private String _version;

}