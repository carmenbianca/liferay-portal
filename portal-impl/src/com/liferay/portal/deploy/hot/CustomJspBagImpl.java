/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.deploy.hot;

import com.liferay.portal.kernel.url.URLContainer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Peter Fellwock
 * @author Raymond Augé
 */
public class CustomJspBagImpl implements CustomJspBag {

	public CustomJspBagImpl(
		URLContainer urlContainer, String customJspDir,
		boolean customJspGlobal) {

		_urlContainer = urlContainer;
		_customJspDir = customJspDir;
		_customJspGlobal = customJspGlobal;

		_customJsps = new ArrayList<>();
	}

	@Override
	public String getCustomJspDir() {
		return _customJspDir;
	}

	@Override
	public List<String> getCustomJsps() {
		return _customJsps;
	}

	@Override
	public URLContainer getURLContainer() {
		return _urlContainer;
	}

	@Override
	public boolean isCustomJspGlobal() {
		return _customJspGlobal;
	}

	private final String _customJspDir;
	private final boolean _customJspGlobal;
	private final List<String> _customJsps;
	private final URLContainer _urlContainer;

}