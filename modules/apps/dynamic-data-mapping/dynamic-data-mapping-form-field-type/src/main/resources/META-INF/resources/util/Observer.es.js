/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

export default class Observer {
	constructor() {
		this.handlers = [];
	}

	subscribe(fn) {
		this.handlers.push(fn);
	}

	unsubscribe(fn) {
		this.handlers = this.handlers.filter(handler => handler !== fn);
	}

	dispatch(value) {
		this.handlers.forEach(handler => handler(value));
	}
}
