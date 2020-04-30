/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

/**
 * The analytics-client-js implementation relies on the non-standard
 * `innerText` property, which jsdom does not implement, so we need this
 * special helper in tests that sets `innerText` whenever `innerHTML` is
 * set.
 *
 * @see https://github.com/jsdom/jsdom/issues/1245
 */
global.setInnerHTML = (element, html) => {
	element.innerHTML = html;
	element.innerText = element.textContent;
};

if (!global.performance.timing) {
	Object.defineProperty(global.performance, 'timing', {
		get() {
			return {
				loadEventStart: 1,
				navigationStart: 0,
			};
		},
	});
}
