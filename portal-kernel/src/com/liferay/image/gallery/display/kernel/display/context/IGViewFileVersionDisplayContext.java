/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.image.gallery.display.kernel.display.context;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.servlet.taglib.ui.Menu;
import com.liferay.portal.kernel.servlet.taglib.ui.MenuItem;

import java.util.List;

/**
 * @author Iván Zaera
 */
public interface IGViewFileVersionDisplayContext extends IGDisplayContext {

	public Menu getMenu() throws PortalException;

	public List<MenuItem> getMenuItems() throws PortalException;

}