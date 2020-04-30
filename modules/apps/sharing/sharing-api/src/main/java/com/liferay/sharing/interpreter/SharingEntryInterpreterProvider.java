/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sharing.interpreter;

import com.liferay.sharing.model.SharingEntry;

/**
 * @author Alejandro Tardín
 */
public interface SharingEntryInterpreterProvider {

	public SharingEntryInterpreter getSharingEntryInterpreter(
		SharingEntry sharingEntry);

}