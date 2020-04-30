/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import EventScreen from './EventScreen.es';

/**
 * RenderURLScreen
 *
 * Inherits from {@link EventScreen|EventScreen}. This is the screen used for
 * all requests made to RenderURLs.
 */

class RenderURLScreen extends EventScreen {
	/**
	 * @inheritDoc
	 */

	constructor() {
		super();

		this.cacheable = true;
	}
}

export default RenderURLScreen;
