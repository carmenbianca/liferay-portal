/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

const STATES = {
	IDLE: {running: false, show: false},
	LONG_POLLING: {running: true, show: true},
	NOTIFY: {running: false, show: false},
	SHORT_POLLING: {running: true, show: false},
};

const TOASTS = {
	ERROR: {
		message: Liferay.Language.get('an-unexpected-error-occurred'),
		title: Liferay.Language.get('error'),
		type: 'danger',
	},
	SUCCESS: {
		message: Liferay.Language.get('changes-saved'),
	},
};

export {STATES};

export default function reducer(state, action) {
	switch (action.type) {
		case 'check':
			if (state.current === STATES.LONG_POLLING) {
				return {
					...state,
					timestamp: Date.now(),
				};
			}
			break;

		case 'error':
			return {
				...state,
				current: STATES.NOTIFY,
				toast: TOASTS.ERROR,
			};

		case 'initialDelayCompleted':
			if (state.current === STATES.SHORT_POLLING) {
				return {
					...state,
					current: STATES.LONG_POLLING,
					timestamp: Date.now(),
				};
			}

			break;

		case 'notificationCompleted':
			if (state.current === STATES.NOTIFY) {
				return {
					...state,
					current: STATES.IDLE,
				};
			}

			break;

		case 'start':
			if (state.current === STATES.IDLE) {
				return {
					...state,
					current: STATES.SHORT_POLLING,
				};
			}

			break;

		case 'success':
			return {
				...state,
				current: STATES.NOTIFY,
				toast: TOASTS.SUCCESS,
			};

		default:
			return state;
	}

	return state;
}
