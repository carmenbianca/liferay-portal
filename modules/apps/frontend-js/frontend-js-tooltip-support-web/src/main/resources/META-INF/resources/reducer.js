/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

const STATES = {
	IDLE: {show: false},
	SHOW: {show: true},
	WAIT_HIDE: {show: true},
	WAIT_RESHOW: {show: true},
	WAIT_SHOW: {show: false},
};

export {STATES};

export default function reducer(state, action) {
	switch (action.type) {
		case 'show':
			if (state.current === STATES.IDLE) {
				return {
					...state,
					current: STATES.WAIT_SHOW,
					target: action.target,
					timestamp: Date.now(),
				};
			}
			else if (state.current === STATES.WAIT_SHOW) {
				return {
					...state,
					target: action.target,
					timestamp: Date.now(),
				};
			}
			else if (state.current === STATES.WAIT_RESHOW) {
				return {
					...state,
					nextTarget: action.target,
					timestamp: Date.now(),
				};
			}
			else if (state.current === STATES.WAIT_HIDE) {
				return {
					...state,
					current: STATES.WAIT_RESHOW,
					nextTarget: action.target,
				};
			}
			else {
				return {
					...state,
					timestamp: Date.now(),
				};
			}

		case 'hideDelayCompleted':
			if (state.current === STATES.WAIT_HIDE) {
				return {current: STATES.IDLE};
			}

			break;

		case 'showDelayCompleted':
			if (state.current === STATES.WAIT_SHOW) {
				return {
					...state,
					current: STATES.SHOW,
				};
			}
			else if (state.current === STATES.WAIT_RESHOW) {
				return {
					...state,
					current: STATES.SHOW,
					target: state.nextTarget,
				};
			}

			break;

		case 'hide':
			if (state.current === STATES.WAIT_SHOW) {
				return {current: STATES.IDLE};
			}
			else if (
				state.current === STATES.SHOW ||
				state.current === STATES.WAIT_RESHOW
			) {
				return {
					...state,
					current: STATES.WAIT_HIDE,
					timestamp: Date.now(),
				};
			}

			break;

		default:
			return state;
	}

	return state;
}
