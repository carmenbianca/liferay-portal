/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {render} from 'frontend-js-react-web';

export default function(renderFunction, renderData, placeholderId) {
	const element = document.getElementById(placeholderId);

	if (element) {
		render(renderFunction, renderData, element.parentElement);
	}
}
