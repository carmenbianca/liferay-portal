/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.configuration.admin.web.internal.exporter;

import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;

import java.util.Dictionary;

import org.apache.felix.cm.file.ConfigurationHandler;

/**
 * @author Pei-Jung Lan
 */
public class ConfigurationExporter {

	public static byte[] getPropertiesAsBytes(Dictionary properties)
		throws Exception {

		UnsyncByteArrayOutputStream unsyncByteArrayOutputStream =
			new UnsyncByteArrayOutputStream();

		ConfigurationHandler.write(unsyncByteArrayOutputStream, properties);

		return unsyncByteArrayOutputStream.toByteArray();
	}

}