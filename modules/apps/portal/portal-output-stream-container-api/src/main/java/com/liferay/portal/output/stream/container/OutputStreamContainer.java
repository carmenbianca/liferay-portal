/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.output.stream.container;

import java.io.OutputStream;

/**
 * @author Carlos Sierra Andrés
 */
public interface OutputStreamContainer {

	public String getDescription();

	public OutputStream getOutputStream();

}