/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

(function($) {
	$.ajaxSetup({
		data: {},
		type: 'POST',
	});

	$.ajaxPrefilter(options => {
		if (options.crossDomain) {
			options.contents.script = false;
		}

		if (options.url) {
			options.url = Liferay.Util.getURLWithSessionId(options.url);
		}
	});
})(window.$);
