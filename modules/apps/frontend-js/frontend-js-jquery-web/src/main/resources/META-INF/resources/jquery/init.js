/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

(function($) {
	var jqueryInit = $.prototype.init;

	$.prototype.init = function(selector, context, root) {
		if (selector === '#') {
			selector = '';
		}

		return new jqueryInit(selector, context, root);
	};
})(window.$);
