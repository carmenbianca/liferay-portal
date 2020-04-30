/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

/**
 * Throttle implementation that fires on the leading and trailing edges.
 * If multiple calls come in during the throttle interval, the last call's
 * arguments and context are used, replacing those of any previously pending
 * calls.
 *
 * @param {!function()} fn
 * @param {number} interval
 * @return {!function()}
 */
export default function throttle(fn, interval) {
	let timeout = null;
	let last;

	return function(...args) {
		const context = this;
		const now = Date.now();

		const schedule = () => {
			timeout = setTimeout(() => {
				timeout = null;
			}, interval);
			last = now;
			fn.apply(context, args);
		};

		if (timeout === null) {
			schedule();
		}
		else {
			const remaining = Math.max(last + interval - now, 0);
			clearTimeout(timeout);
			timeout = setTimeout(schedule, remaining);
		}
	};
}
