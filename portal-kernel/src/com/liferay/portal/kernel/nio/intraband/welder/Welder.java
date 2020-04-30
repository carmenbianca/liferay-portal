/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.nio.intraband.welder;

import com.liferay.portal.kernel.nio.intraband.Intraband;
import com.liferay.portal.kernel.nio.intraband.RegistrationReference;

import java.io.IOException;
import java.io.Serializable;

/**
 * @author Shuyang Zhou
 */
public interface Welder extends Serializable {

	public void destroy() throws IOException;

	public RegistrationReference weld(Intraband intraband) throws IOException;

}