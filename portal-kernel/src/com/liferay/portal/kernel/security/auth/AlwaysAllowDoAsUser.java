/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.auth;

import java.util.Collection;

/**
 * @author Iván Zaera
 */
public interface AlwaysAllowDoAsUser {

	public Collection<String> getActionNames();

	public Collection<String> getMVCRenderCommandNames();

	public Collection<String> getPaths();

	public Collection<String> getStrutsActions();

}