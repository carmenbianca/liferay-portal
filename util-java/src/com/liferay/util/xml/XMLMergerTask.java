/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.util.xml;

import java.io.File;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

/**
 * @author Jorge Ferrer
 */
public class XMLMergerTask extends Task {

	@Override
	public void execute() throws BuildException {
		_validateAttributes();

		try {
			XMLMergerRunner runner = new XMLMergerRunner(_type);

			runner.mergeAndSave(_masterFile, _slaveFile, _outputFile);
		}
		catch (Exception exception) {
			throw new BuildException(exception);
		}
	}

	public void setMasterFile(File masterFile) {
		_masterFile = masterFile;
	}

	public void setOutputFile(File outputFile) {
		_outputFile = outputFile;
	}

	public void setSlaveFile(File slaveFile) {
		_slaveFile = slaveFile;
	}

	public void setType(String type) {
		_type = type;
	}

	private void _validateAttributes() {
		_validateMandatoryAttribute(_masterFile, "masterFile");
		_validateMandatoryAttribute(_slaveFile, "slaveFile");
		_validateMandatoryAttribute(_outputFile, "outputFile");
	}

	private void _validateMandatoryAttribute(File value, String name) {
		if (value == null) {
			throw new BuildException(name + " is a required attribute");
		}
	}

	private File _masterFile;
	private File _outputFile;
	private File _slaveFile;
	private String _type;

}