/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import Component from 'metal-component';
import Soy from 'metal-soy';
import {Config} from 'metal-state';

import templates from './PageRenderer.soy';

class PageRenderer extends Component {}

PageRenderer.STATE = {
	items: Config.arrayOf(
		Config.shapeOf({
			type: Config.string(),
		})
	),
};

Soy.register(PageRenderer, templates);

export default PageRenderer;
