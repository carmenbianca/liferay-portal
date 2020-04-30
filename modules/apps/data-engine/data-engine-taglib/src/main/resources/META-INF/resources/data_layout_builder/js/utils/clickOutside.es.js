/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import dom from 'metal-dom';

export default (target, ...elements) => {
	return !elements.some(element => {
		if (typeof element === 'string') {
			return !!dom.closest(target, element);
		}

		return element && dom.contains(element, target);
	});
};
