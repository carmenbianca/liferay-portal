/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.remote.soap.extender.test;

import javax.jws.WebService;

/**
 * @author Carlos Sierra Andrés
 */
@WebService
public interface Greeter {

	public String greet();

}