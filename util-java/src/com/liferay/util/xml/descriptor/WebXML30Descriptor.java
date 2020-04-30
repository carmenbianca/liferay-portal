/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.util.xml.descriptor;

/**
 * @author Shuyang Zhou
 */
public class WebXML30Descriptor extends WebXML24Descriptor {

	public WebXML30Descriptor() {
		orderedChildren.put(
			"servlet",
			new String[] {
				"icon", "servlet-name", "display-name", "description",
				"servlet-class", "jsp-file", "init-param", "load-on-startup",
				"async-supported", "run-as", "security-role-ref"
			});
	}

}