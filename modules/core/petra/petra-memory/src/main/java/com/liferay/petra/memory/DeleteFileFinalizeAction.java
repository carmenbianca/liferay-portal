/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.memory;

import java.io.File;

import java.lang.ref.Reference;

/**
 * @author Shuyang Zhou
 */
public class DeleteFileFinalizeAction implements FinalizeAction {

	public DeleteFileFinalizeAction(String fileName) {
		_fileName = fileName;
	}

	@Override
	public void doFinalize(Reference<?> reference) {
		File file = new File(_fileName);

		file.delete();
	}

	private final String _fileName;

}