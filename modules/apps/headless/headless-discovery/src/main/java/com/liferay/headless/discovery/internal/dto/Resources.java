/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.headless.discovery.internal.dto;

import java.util.Map;
import java.util.TreeMap;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Javier Gamarra
 */
@XmlRootElement
public class Resources {

	public Resources() {
	}

	public Resources(Map<String, Resource> resources) {
		_resources = resources;
	}

	public Map<String, Resource> getResources() {
		return _resources;
	}

	public void setResources(Map<String, Resource> resources) {
		_resources = resources;
	}

	private Map<String, Resource> _resources = new TreeMap<>();

}