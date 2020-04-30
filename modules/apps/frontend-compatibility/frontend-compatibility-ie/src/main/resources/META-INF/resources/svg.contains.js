/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

SVGElement.prototype.contains = function(el) {
	while ((el = el.parentNode)) {
		if (el === this) {
			return true;
		}
	}

	return false;
};
