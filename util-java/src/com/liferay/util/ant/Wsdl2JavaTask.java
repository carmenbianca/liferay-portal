/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.util.ant;

import java.io.File;

import org.apache.axis.tools.ant.wsdl.NamespaceMapping;
import org.apache.axis.tools.ant.wsdl.Wsdl2javaAntTask;

/**
 * @author Brian Wing Shun Chan
 */
public class Wsdl2JavaTask {

	public static void generateJava(String url, String output) {
		generateJava(url, output, null);
	}

	public static void generateJava(String url, String output, String mapping) {
		Wsdl2javaAntTask wsdl2Java = new Wsdl2javaAntTask();

		if (mapping != null) {
			NamespaceMapping namespaceMapping = new NamespaceMapping();

			namespaceMapping.setFile(new File(mapping));

			wsdl2Java.addMapping(namespaceMapping);
		}

		wsdl2Java.setFailOnNetworkErrors(true);
		wsdl2Java.setOutput(new File(output));
		wsdl2Java.setPrintStackTraceOnFailure(true);
		wsdl2Java.setProject(AntUtil.getProject());
		wsdl2Java.setServerSide(true);
		wsdl2Java.setTestCase(false);
		wsdl2Java.setURL(url);

		try {
			wsdl2Java.execute();
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}