/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.repository.external;

/**
 * @author Iván Zaera
 * @author Sergio González
 */
public interface CredentialsProvider {

	public String getLogin();

	public String getPassword();

}