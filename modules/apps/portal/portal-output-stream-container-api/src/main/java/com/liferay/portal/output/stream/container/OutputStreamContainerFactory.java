/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.output.stream.container;

/**
 * @author Carlos Sierra Andrés
 */
public interface OutputStreamContainerFactory {

	public OutputStreamContainer create(String hint);

}