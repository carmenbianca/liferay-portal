/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

/**
 * Debounces function execution until next animation frame.
 * @param {!function()} fn
 * @return {!function()}
 */
export default function debounceRAF(fn) {
	return function debounced() {
		const args = arguments;
		cancelDebounce(debounced);
		debounced.id = requestAnimationFrame(() => {
			fn(...args);
		});
	};
}

/**
 * Cancels the scheduled debounced function.
 * @param {function()} debounced
 */
function cancelDebounce(debounced) {
	cancelAnimationFrame(debounced.id);
}
